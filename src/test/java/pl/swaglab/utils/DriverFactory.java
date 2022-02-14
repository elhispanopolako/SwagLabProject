package pl.swaglab.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverFactory {
    public static WebDriver getDriver(String name) {
        if (name.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        } else if (name.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (name.equals("opera")) {
            WebDriverManager.operadriver().setup();
            return new OperaDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }
    }
}


