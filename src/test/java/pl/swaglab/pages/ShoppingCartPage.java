package pl.swaglab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartPage {
@FindBy(xpath = "//div[@class='cart_item']//button")
private List<WebElement> removeButton;
@FindBy(name = "checkout")
private WebElement checkoutBtn;
@FindBy(id="first-name")
private WebElement chekoutName;
@FindBy(id="last-name")
private WebElement chekoutLastName;
@FindBy(id="postal-code")
private WebElement chekoutPostalCode;
@FindBy(id="continue")
private WebElement continueBtn;
@FindBy(id="finish")
private WebElement finishBtn;


//asercja
@FindBy(xpath = "//div[@class='removed_cart_item']")
public  WebElement removedItem;
@FindBy(css =".complete-header")
public WebElement completeOrder;



private WebDriver driver;
public ShoppingCartPage(WebDriver driver){
    PageFactory.initElements(driver,this);
    this.driver=driver;
}
public void removeProduct(int index){
    removeButton.get(index).click();
}
public void setCompleteOrder(String name,String lastname,String postCode){
    checkoutBtn.click();
    chekoutName.sendKeys(name);
    chekoutLastName.sendKeys(lastname);
    chekoutPostalCode.sendKeys(postCode);
    continueBtn.click();
    finishBtn.click();
}

}
