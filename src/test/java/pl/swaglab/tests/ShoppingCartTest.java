package pl.swaglab.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.swaglab.pages.HomePage;
import pl.swaglab.pages.ShoppingCartPage;

public class ShoppingCartTest extends BaseTest {
    @Test
    public void removeProductTest(){
        HomePage homePage=new HomePage(driver);
        homePage.setLogin("standard_user","secret_sauce");
        Assert.assertEquals(homePage.titleProducts.getText(),"PRODUCTS");
        homePage.addProduct(0);
        homePage.goToShoppingCart();

        ShoppingCartPage cartPage=new ShoppingCartPage(driver);
        cartPage.removeProduct(0);
        Assert.assertTrue(cartPage.removedItem.isEnabled());
    }
    @Test
    public void orderProductTest(){
        HomePage homePage=new HomePage(driver);
        homePage.setLogin("standard_user","secret_sauce");
        Assert.assertEquals(homePage.titleProducts.getText(),"PRODUCTS");
        homePage.addProduct(0);
        homePage.goToShoppingCart();

        ShoppingCartPage cartPage=new ShoppingCartPage(driver);
        cartPage.setCompleteOrder("Alex","Testowy","39340");
        Assert.assertEquals(cartPage.completeOrder.getText(),"THANK YOU FOR YOUR ORDER");
    }
    @Test
    public void add3CheaperProductsOrder2Test(){
        HomePage homePage=new HomePage(driver);
        homePage.setLogin("standard_user","secret_sauce");
        Assert.assertEquals(homePage.titleProducts.getText(),"PRODUCTS");
        homePage.selectLowToHighsort();
        homePage.addProduct(0);
        homePage.addProduct(1);
        homePage.addProduct(2);
        homePage.goToShoppingCart();

        ShoppingCartPage cartPage=new ShoppingCartPage(driver);
        cartPage.removeProduct(2);
        Assert.assertTrue(cartPage.removedItem.isEnabled());
        cartPage.setCompleteOrder("Alex","Testowy","39340");
        Assert.assertEquals(cartPage.completeOrder.getText(),"THANK YOU FOR YOUR ORDER");

    }
}
