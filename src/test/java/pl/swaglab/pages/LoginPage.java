package pl.swaglab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement userInput;

    @FindBy(id = "password")
    private WebElement passInput;

    @FindBy(id = "login-button")
    private WebElement logButton;
    @FindBy(css = ".title")
    private WebElement titleProducts;

    @FindBy(css = ".error-message-container.error")
    private WebElement errorLoginMess;



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String username, String password) {
        userInput.sendKeys(username);
        passInput.sendKeys(password);
        logButton.click();
        wait.until(ExpectedConditions.visibilityOf(titleProducts));
        return new HomePage(driver);
    }
    public LoginPage badLogin(String username, String password) {
        userInput.sendKeys(username);
        passInput.sendKeys(password);
        logButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorLoginMess));
        return this;
    }

    public boolean errorLoginMessage() {
        errorLoginMess.isDisplayed();
        return true;
    }
}

