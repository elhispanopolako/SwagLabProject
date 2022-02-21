package pl.swaglab.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.swaglab.pages.CheckoutPage;
import pl.swaglab.pages.HomePage;
import pl.swaglab.pages.LoginPage;
import pl.swaglab.pages.ShoppingCartPage;
import pl.swaglab.utils.SeleniumHelper;

import java.io.IOException;

public class HomePageTest extends BaseTest {
    @Test
    public void addProductFromProductPageTest() throws IOException {
        ExtentTest test = extentReports.createTest("Dodanie produktu do koszyka przez strone produktu");
        HomePage homePage = new LoginPage(driver)
                .login("standard_user", "secret_sauce")
                .selectZToASort()
                .gotoProductPage(0)
                .addProductFromProductPage()
                .backToProductList();
        Assert.assertTrue(homePage.shoppingBadge());
        test.log(Status.PASS, "Add Product Done-Assertions Passed", SeleniumHelper.getScreenshot(driver));

    }

    @Test
    public void addProductAfterAllSort() throws IOException {
        ExtentTest test = extentReports.createTest("Dodanie produktu do koszyka po każdym sortowaniu");
        ShoppingCartPage cartPage = new LoginPage(driver)
                .login("standard_user", "secret_sauce")
                .selectZToASort()
                .addProduct(0)
                .selectHighToLowSort()
                .addProduct(0)
                .selectLowToHighSort()
                .addProduct(0)
                .selectAToZSort()
                .addProduct(0)
                .goToShoppingCart();
        Assert.assertEquals(cartPage.cartSize(), 4);
        test.log(Status.PASS, "4 products in cart-Assertion Passed", SeleniumHelper.getScreenshot(driver));
    }

    @Test
    public void orderAllProductsTest() throws IOException {
        ExtentTest test = extentReports.createTest("Zamówienie wszytkie produkty z głównej strony");
        HomePage homePage = new LoginPage(driver)
                .login("standard_user", "secret_sauce");
        for (int i = 0; i < homePage.productSize(); i++) {
            homePage.addProduct(i);
        }
        Assert.assertEquals(homePage.shoppingBadgeText(), "6");
        test.log(Status.PASS, "Add 6 products-Assertions Passed", SeleniumHelper.getScreenshot(driver));
        homePage.goToShoppingCart()
                .clickCheckoutBtn()
                .setCheckoutForm("Alex", "Testowy", "39340");
        CheckoutPage checkPage = new CheckoutPage(driver);
        Assert.assertEquals(checkPage.completeOrderText(), "THANK YOU FOR YOUR ORDER");
        test.log(Status.PASS, "Order Done-Assertions Passed", SeleniumHelper.getScreenshot(driver));
    }
}
