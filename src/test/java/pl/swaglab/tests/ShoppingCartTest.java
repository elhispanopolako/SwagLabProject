package pl.swaglab.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.swaglab.pages.CheckoutPage;
import pl.swaglab.pages.HomePage;
import pl.swaglab.pages.ShoppingCartPage;
import pl.swaglab.utils.SeleniumHelper;

import java.io.IOException;

public class ShoppingCartTest extends BaseTest {
    @Test
    public void removeProductTest() throws IOException {
        ExtentTest test = extentReports.createTest("Usunięcie produktu z koszyka");
        HomePage homePage = new HomePage(driver);
        homePage.login("standard_user", "secret_sauce");
        Assert.assertEquals(homePage.titleProductText(), "PRODUCTS");
        homePage.addProduct(0);
        homePage.goToShoppingCart();
        test.log(Status.PASS, "Add product to Cart", SeleniumHelper.getScreenshot(driver));

        ShoppingCartPage cartPage = new ShoppingCartPage(driver);
        cartPage.removeProduct(0);
        Assert.assertTrue(cartPage.removedItemAssert());
        test.log(Status.PASS, "Remove product-Assertions Passed", SeleniumHelper.getScreenshot(driver));
    }

    @Test
    public void orderProductTest() throws IOException {
        ExtentTest test = extentReports.createTest("Zamówienie Produktu z koszyka");
        HomePage homePage = new HomePage(driver);
        homePage.login("standard_user", "secret_sauce");
        Assert.assertEquals(homePage.titleProductText(), "PRODUCTS");
        homePage.addProduct(0);
        homePage.goToShoppingCart();
        test.log(Status.PASS, "Add Product", SeleniumHelper.getScreenshot(driver));
        ShoppingCartPage cartPage = new ShoppingCartPage(driver);
        cartPage.clickCheckoutBtn();
        CheckoutPage checkPage = new CheckoutPage(driver);
        checkPage.setCheckoutForm("Alex", "Testowy", "39340");
        Assert.assertEquals(checkPage.completeOrderText(), "THANK YOU FOR YOUR ORDER");
        test.log(Status.PASS, "Order Done-Assertions Passed", SeleniumHelper.getScreenshot(driver));
    }

    @Test
    public void add3CheaperProductsOrder2Test() throws IOException {
        ExtentTest test = extentReports.createTest("add3CheaperProductsOrder2");
        HomePage homePage = new HomePage(driver);
        homePage.login("standard_user", "secret_sauce");
        Assert.assertEquals(homePage.titleProductText(), "PRODUCTS");
        homePage.selectLowToHighsort();
        test.log(Status.PASS, "Sort low to high Done", SeleniumHelper.getScreenshot(driver));
        homePage.addProduct(0);
        homePage.addProduct(1);
        homePage.addProduct(2);
        homePage.goToShoppingCart();
        test.log(Status.PASS, "Add 3 products", SeleniumHelper.getScreenshot(driver));
        ShoppingCartPage cartPage = new ShoppingCartPage(driver);
        cartPage.removeProduct(2);
        Assert.assertTrue(cartPage.removedItemAssert());
        test.log(Status.PASS, "Remove 1 product", SeleniumHelper.getScreenshot(driver));
        cartPage.clickCheckoutBtn();
        CheckoutPage checkPage = new CheckoutPage(driver);
        checkPage.setCheckoutForm("Alex", "Testowy", "39340");
        Assert.assertEquals(checkPage.completeOrderText(), "THANK YOU FOR YOUR ORDER");
        test.log(Status.PASS, "Order Done-Assertions Passed", SeleniumHelper.getScreenshot(driver));

    }

    @Test
    public void orderTheMostExpensiveProduct() throws IOException {
        ExtentTest test = extentReports.createTest("Order the most expensive product");
        HomePage homePage = new HomePage(driver);
        homePage.login("standard_user", "secret_sauce");
        Assert.assertEquals(homePage.titleProductText(), "PRODUCTS");
        homePage.selectHighToLowsort();
        homePage.addProduct(0);
        homePage.goToShoppingCart();
        test.log(Status.PASS, "Sort High to Low and add the most expensive product", SeleniumHelper.getScreenshot(driver));
        ShoppingCartPage cartPage = new ShoppingCartPage(driver);
        cartPage.clickCheckoutBtn();
        CheckoutPage checkPage = new CheckoutPage(driver);
        checkPage.setCheckoutForm("Alex", "Testowy", "39340");
        Assert.assertEquals(checkPage.completeOrderText(), "THANK YOU FOR YOUR ORDER");
        test.log(Status.PASS, "Order Done-Assertions Passed", SeleniumHelper.getScreenshot(driver));
    }


}
