package pl.swaglab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {
    @FindBy(id = "first-name")
    private WebElement checkoutName;

    @FindBy(id = "last-name")
    private WebElement checkoutLastName;

    @FindBy(id = "postal-code")
    private WebElement checkoutPostalCode;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    @FindBy(css = ".complete-header")
    private WebElement completeOrder;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void setCheckoutForm(String name, String lastname, String postCode) {
        checkoutName.sendKeys(name);
        checkoutLastName.sendKeys(lastname);
        checkoutPostalCode.sendKeys(postCode);
        continueBtn.click();
        finishBtn.click();
    }

    public String completeOrderText() {
        return completeOrder.getText();
    }
}
