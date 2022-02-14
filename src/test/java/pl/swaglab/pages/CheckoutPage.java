package pl.swaglab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    @FindBy(id = "first-name")
    private WebElement chekoutName;
    @FindBy(id = "last-name")
    private WebElement chekoutLastName;
    @FindBy(id = "postal-code")
    private WebElement chekoutPostalCode;
    @FindBy(id = "continue")
    private WebElement continueBtn;
    @FindBy(id = "finish")
    private WebElement finishBtn;
    @FindBy(css = ".complete-header")
    private WebElement completeOrder;
    private final WebDriver driver;
    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void setCheckoutForm(String name, String lastname, String postCode) {
        chekoutName.sendKeys(name);
        chekoutLastName.sendKeys(lastname);
        chekoutPostalCode.sendKeys(postCode);
        continueBtn.click();
        finishBtn.click();
    }
    public String completeOrderText(){
        return  completeOrder.getText();
    }
}
