package pl.swaglab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
    @FindBy(css = "[class='inventory_item'] button")
    private List<WebElement> addProductButton;
    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartButton;
    @FindBy(css = "select")
    private WebElement sortList;

    @FindBy(xpath = "//span[text()='Products']")
    private WebElement titleProducts;
    @FindBy(css = ".error-message-container.error")
    private WebElement errorLoginMess;
    @FindBy(css = ".shopping_cart_badge")
    private WebElement shoppingCartBadge;

    private final WebDriver driver;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void login(String username, String password) {
        userInput.sendKeys(username);
        passInput.sendKeys(password);
        logButton.click();
    }

    public void addProduct(int index) {
        addProductButton.get(index).click();
    }

    public void goToShoppingCart() {
        shoppingCartButton.click();
    }

    public void selectLowToHighsort() {
        Select select = new Select(sortList);
        select.selectByValue("lohi");
    }

    public void selectHighToLowsort() {
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
