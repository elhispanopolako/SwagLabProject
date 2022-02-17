package pl.swaglab.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.swaglab.pages.CheckoutPage;
import pl.swaglab.pages.LoginPage;
import pl.swaglab.pages.ShoppingCartPage;
import pl.swaglab.utils.SeleniumHelper;

import java.io.IOException;

public class ShoppingCartTest extends BaseTest {
    @Test
    public void removeProductTest() throws IOException {
        ExtentTest test = extentReports.createTest("Usunięcie produktu z koszyka");
        ShoppingCartPage cartPage = new LoginPage(driver)
                .login("standard_user", "secret_sauce")
                .addProduct(0)
                .goToShoppingCart();
        test.log(Status.PASS, "Add product to Cart", SeleniumHelper.getScreenshot(driver));
        cartPage.removeProduct(0);
        Assert.assertTrue(cartPage.removedItemAssert());
        test.log(Status.PASS, "Remove product-Assertions Passed", SeleniumHelper.getScreenshot(driver));
    }

    @Test
    public void orderProductTest() throws IOException {
        ExtentTest test = extentReports.createTest("Zamówienie Produktu z koszyka");
        CheckoutPage checkPage = new LoginPage(driver)
                .login("standard_user", "secret_sauce")
                .addProduct(0)
                .goToShoppingCart()
                .clickCheckoutBtn()
                .setCheckoutForm("Alex", "Testowy", "39340");
        Assert.assertEquals(checkPage.completeOrderText(), "THANK YOU FOR YOUR ORDER");
        test.log(Status.PASS, "Order Done-Assertions Passed", SeleniumHelper.getScreenshot(driver));
    }

    @Test
    public void add3CheaperProductsOrder2Test() throws IOException {
        ExtentTest test = extentReports.createTest("add3CheaperProductsOrder2");
        CheckoutPage checkPage = new LoginPage(driver)
                .login("standard_user", "secret_sauce")
                .selectLowToHighSort()
                .addProduct(0)
                .addProduct(1)
                .addProduct(2)
                .goToShoppingCart()
                .removeProduct(2)
                .clickCheckoutBtn()
                .setCheckoutForm("Alex", "Testowy", "39340");
        Assert.assertEquals(checkPage.completeOrderText(), "THANK YOU FOR YOUR ORDER");
        test.log(Status.PASS, "Order Done-Assertions Passed", SeleniumHelper.getScreenshot(driver));

    }

    @Test
    public void orderTheMostExpensiveProduct() throws IOException {
        ExtentTest test = extentReports.createTest("Order the most expensive product");
        CheckoutPage checkPage = new LoginPage(driver)
                .login("standard_user", "secret_sauce")
                .selectHighToLowSort()
                .addProduct(0)
                .goToShoppingCart()
                .clickCheckoutBtn()
                .setCheckoutForm("Alex", "Testowy", "39340");
        Assert.assertEquals(checkPage.completeOrderText(), "THANK YOU FOR YOUR ORDER");
        test.log(Status.PASS, "Order Done-Assertions Passed", SeleniumHelper.getScreenshot(driver));
    }


}
