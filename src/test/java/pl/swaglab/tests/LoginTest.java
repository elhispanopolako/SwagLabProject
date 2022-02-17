package pl.swaglab.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.swaglab.pages.HomePage;
import pl.swaglab.pages.LoginPage;
import pl.swaglab.utils.SeleniumHelper;

import java.io.IOException;

public class LoginTest extends BaseTest {
    @Test
    public void correctLoginTest() throws IOException {
        ExtentTest test = extentReports.createTest("Logowanie standardowego użytkownika");
        HomePage homePage = new LoginPage(driver)
                .login("standard_user", "secret_sauce");
        Assert.assertEquals(homePage.titleProductText(), "PRODUCTS");
        test.log(Status.PASS, "Set correct Login Done-Assertions Passed", SeleniumHelper.getScreenshot(driver));
    }

    @Test
    public void blockUserLoginTest() throws IOException {
        ExtentTest test = extentReports.createTest("Logowanie zablokowanego użytkownika");
        LoginPage loginPage = new LoginPage(driver)
                .badLogin("standard_user1", "secret");
        Assert.assertTrue(loginPage.errorLoginMessage());
        test.log(Status.PASS, "Set Wrong Login Done-Assertions Passed", SeleniumHelper.getScreenshot(driver));
    }

    @Test
    public void addProductTest() throws IOException {
        ExtentTest test = extentReports.createTest("Dodanie produktu do koszyka");
        HomePage homePage = new LoginPage(driver)
                .login("standard_user", "secret_sauce")
                .addProduct(0);
        Assert.assertTrue(homePage.shoppingBadge());
        test.log(Status.PASS, "Add Product Done-Assertions Passed", SeleniumHelper.getScreenshot(driver));
    }


}
