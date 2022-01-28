package pl.swaglab.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.swaglab.pages.HomePage;

public class LoginTest extends BaseTest {
@Test
public void correctLoginTest(){
    HomePage homePage=new HomePage(driver);
    homePage.setLogin("standard_user","secret_sauce");
    Assert.assertEquals(homePage.titleProducts.getText(),"PRODUCTS");
}
@Test
public void blockUserLoginTest(){
    HomePage homePage=new HomePage(driver);
    homePage.setLogin("standard_user1","secret");
    Assert.assertTrue(homePage.errorLoginMessage.isDisplayed());
}
@Test
public void addProductTest(){
    HomePage homePage=new HomePage(driver);
    homePage.setLogin("standard_user","secret_sauce");
    Assert.assertEquals(homePage.titleProducts.getText(),"PRODUCTS");
    homePage.addProduct(0);
    Assert.assertTrue(homePage.shoppingCartBadge.isDisplayed());
}


}
