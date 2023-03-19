package onliner.tests;

import onliner.pageObjects.ComputersAndNetworksItems;
import onliner.pageObjects.ComputersAndNetworksPage;
import onliner.pageObjects.MainPage;
import onliner.utils.WebDriverRun;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ComputersAndNetworksPageTest {
    private WebDriver driver;
    private MainPage mainPage;


    @BeforeEach
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium_java\\ChromeDriver\\chromedriver.exe");
        driver = WebDriverRun.getDriver();
        mainPage = new MainPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(mainPage.openMainPage());

    }

    @Test
    public void testComputersAndNetworks() {
        ComputersAndNetworksPage computersAndNetworksPage = new ComputersAndNetworksPage();

        driver.findElement(mainPage.openCatalog()).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath(computersAndNetworksPage.getPathComputersAndNetworks())).click();
                Assertions.assertAll(
                () -> Assertions.assertTrue(computersAndNetworksPage.isItemExists(ComputersAndNetworksItems.NETWORK_HARDWARE.getComputerItems())),
                () -> Assertions.assertTrue(computersAndNetworksPage.isItemExists(ComputersAndNetworksItems.COMPUTERS_LAPTOPS_MONITORS.getComputerItems())),
                () -> Assertions.assertTrue(computersAndNetworksPage.isItemExists(ComputersAndNetworksItems.ACCESSORIES.getComputerItems())),
                () -> Assertions.assertTrue(computersAndNetworksPage.isItemExists(ComputersAndNetworksItems.DATA_STORAGE.getComputerItems()))
        );
    }

    @Test
    public void testAccessories() {
        ComputersAndNetworksPage computersAndNetworksPage = new ComputersAndNetworksPage();
        driver.findElement(mainPage.openCatalog()).click();
        driver.findElement(By.xpath(computersAndNetworksPage.getPathComputersAndNetworks())).click();
        List<WebElement> accessoriesList = driver.findElements(By.xpath("//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']//a[@class='catalog-navigation-list__dropdown-item']"));
        for (WebElement e:accessoriesList) {
            Assertions.assertTrue(e.isDisplayed());
        }
    }

//    public final By COMPONENT_SUBDIRECTORY_ITEM_NAMES = By.xpath("//div[text()=' Комплектующие ']/..//span[contains(@class, 'title')]");
//    public final By COMPONENT_SUBDIRECTORY_ITEM_PRODUCTS = By.xpath("//div[text()=' Комплектующие ']/..//span[3]/text()[1]/..");
//    public final By COMPONENT_SUBDIRECTORY_ITEM_PRICE = By.xpath("//div[text()=' Комплектующие ']/..//span//following-sibling::text()[1]/..");

    @AfterEach
    public void cleanUp() {
        WebDriverRun.closeDriver();
    }

}
