package pl.swaglab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {
@FindBy(id = "user-name")
private WebElement userInput;
@FindBy(id = "password")
private WebElement passInput;
@FindBy(id = "login-button")
private WebElement logButton;
@FindBy(xpath = "//div[@class='inventory_item']//button")
private List<WebElement> addProductButton;
@FindBy(className = "shopping_cart_link")
private WebElement shoppingCartButton;
@FindBy(css = "select")
private WebElement sortList;

//asercje
@FindBy(xpath = "//span[text()='Products']")
public WebElement titleProducts;
@FindBy(xpath = "//div[@class='error-message-container error']")
public WebElement errorLoginMessage;
@FindBy(xpath = "//span[@class='shopping_cart_badge']")
public WebElement shoppingCartBadge;

private WebDriver driver;
public HomePage(WebDriver driver){
    PageFactory.initElements(driver,this);
    this.driver=driver;
}
public void setLogin(String username,String password){
    userInput.sendKeys(username);
    passInput.sendKeys(password);
    logButton.click();
}
public void addProduct(int index){
    addProductButton.get(index).click();
}
public void goToShoppingCart(){
    shoppingCartButton.click();
}
public void selectLowToHighsort(){
    Select select=new Select(sortList);
    select.selectByValue("lohi");


}

}
