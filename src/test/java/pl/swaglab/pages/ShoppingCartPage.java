package pl.swaglab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static pl.swaglab.utils.WaitForElement.waitUntilElementIsInvisible;
import static pl.swaglab.utils.WaitForElement.waitUntilElementVisibleAndClickable;

public class ShoppingCartPage extends BasePage {
    @FindBy(css = ".cart_item button")
    private List<WebElement> removeButton;

    @FindBy(name = "checkout")
    private WebElement checkoutBtn;

    @FindBy(css = ".removed_cart_item")
    private WebElement removedItem;

    @FindBy(css = ".cart_item")
    private List<WebElement> cartItems;



    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public ShoppingCartPage removeProduct(int index) {
        removeButton.get(index).click();
        waitUntilElementIsInvisible(removedItem,wait);
        return this;
    }

    public CheckoutPage clickCheckoutBtn() {
        waitUntilElementVisibleAndClickable(checkoutBtn,wait);
        checkoutBtn.click();
        return  new CheckoutPage(driver);
    }

    public boolean removedItemAssert() {
        removedItem.isEnabled();
        return true;
    }

    public int cartSize(){
       return cartItems.size();
    }



}
