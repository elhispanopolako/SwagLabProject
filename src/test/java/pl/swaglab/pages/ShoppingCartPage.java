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



    //asercja
    @FindBy(xpath = "//div[@class='removed_cart_item']")
    private WebElement removedItem;



    private final WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void removeProduct(int index) {
        removeButton.get(index).click();
    }

    public void clickCheckoutBtn() {
        checkoutBtn.click();
    }
    public boolean removedItemAssert(){
        removedItem.isEnabled();
        return true;
    }


}
