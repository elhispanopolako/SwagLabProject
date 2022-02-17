package pl.swaglab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    @FindBy(css = ".cart_item button")
    private List<WebElement> removeButton;

    @FindBy(name = "checkout")
    private WebElement checkoutBtn;

    @FindBy(css = ".removed_cart_item")
    private WebElement removedItem;



    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public ShoppingCartPage removeProduct(int index) {
        removeButton.get(index).click();
        wait.until(ExpectedConditions.invisibilityOf(removedItem));
        return this;
    }

    public CheckoutPage clickCheckoutBtn() {
        checkoutBtn.click();
        return  new CheckoutPage(driver);
    }

    public boolean removedItemAssert() {
        removedItem.isEnabled();
        return true;
    }


}
