package pl.swaglab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement userInput;

    @FindBy(id = "password")
    private WebElement passInput;

    @FindBy(id = "login-button")
    private WebElement logButton;

    @FindBy(css = ".inventory_item button")
    private List<WebElement> addProductsButton;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartButton;

    @FindBy(css = "select")
    private WebElement sortList;

    @FindBy(css = ".title")
    private WebElement titleProducts;

    @FindBy(css = ".error-message-container.error")
    private WebElement errorLoginMess;

    @FindBy(css = ".shopping_cart_badge")
    private WebElement shoppingCartBadge;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        userInput.sendKeys(username);
        passInput.sendKeys(password);
        logButton.click();
        wait.until(ExpectedConditions.visibilityOf(titleProducts));
    }
    public void badLogin(String username, String password) {
        userInput.sendKeys(username);
        passInput.sendKeys(password);
        logButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorLoginMess));
    }

    public void addProduct(int index) {
        addProductsButton.get(index).click();
    }

    public void goToShoppingCart() {
        shoppingCartButton.click();
    }

    public void selectLowToHighSort() {
        Select select = new Select(sortList);
        select.selectByValue("lohi");
    }

    public void selectHighToLowSort() {
        Select select = new Select(sortList);
        select.selectByValue("hilo");

    }

    public String titleProductText() {
        return titleProducts.getText();
    }

    public boolean errorLoginMessage() {
        errorLoginMess.isDisplayed();
        return true;
    }

    public boolean shoppingBadge() {
        shoppingCartBadge.isDisplayed();
        return true;
    }

}
