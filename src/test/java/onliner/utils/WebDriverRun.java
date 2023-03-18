package onliner.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverRun {
    private static WebDriver driver;

    public static void initWebDriver() {
        driver = new ChromeDriver();
    }
    public static WebDriver getDriver() {
        if (driver == null) {
            initWebDriver();
        }
        return driver;
    }
    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

}
