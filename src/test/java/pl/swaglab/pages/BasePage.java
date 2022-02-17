package pl.swaglab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5L);
        PageFactory.initElements(driver, this);
    }
}