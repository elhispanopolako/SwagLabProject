package pl.swaglab.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement {
    public static void waitUntilElementVisibleAndClickable(WebElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.and
                (ExpectedConditions.visibilityOf(element),
                        ExpectedConditions.elementToBeClickable(element)));
    }

    public static void waitUntilElementIsVisible(WebElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementIsInvisible(WebElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }


}
