package onliner.tests;

import onliner.pageObjects.ComputersAndNetworksItems;
import onliner.pageObjects.ComputersAndNetworksPage;
import onliner.pageObjects.MainPage;
import onliner.utils.WebDriverRun;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ComputersAndNetworksPageTest {
    private WebDriver driver;
    private MainPage mainPage;
    private static final Logger log = Logger.getLogger(ComputersAndNetworksPageTest.class);

    @BeforeEach
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium_java\\ChromeDriver\\chromedriver.exe");
        driver = WebDriverRun.getDriver();
        mainPage = new MainPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(mainPage.openMainPage());
        log.info("Onliner.by main page opened ");

    }

    @Test
    public void testComputersAndNetworks() {
        ComputersAndNetworksPage computersAndNetworksPage = new ComputersAndNetworksPage();
        driver.findElement(mainPage.openCatalog()).click();
        log.info("Catalog opened");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath(computersAndNetworksPage.getPathComputersAndNetworks())).click();
        log.info("Computers and networks opened");
        Assertions.assertAll(

                () -> Assertions.assertTrue(computersAndNetworksPage.isItemExists(ComputersAndNetworksItems.COMPUTERS_LAPTOPS_MONITORS.getComputerItems())),
                () -> Assertions.assertTrue(computersAndNetworksPage.isItemExists(ComputersAndNetworksItems.ACCESSORIES.getComputerItems())),
                () -> Assertions.assertTrue(computersAndNetworksPage.isItemExists(ComputersAndNetworksItems.NETWORK_HARDWARE.getComputerItems())),
                () -> Assertions.assertTrue(computersAndNetworksPage.isItemExists(ComputersAndNetworksItems.DATA_STORAGE.getComputerItems()))
        );
        log.info("Assertion passed");
    }

    @Test
    public void testAccessories() {

        ComputersAndNetworksPage computersAndNetworksPage = new ComputersAndNetworksPage();
        driver.findElement(mainPage.openCatalog()).click();
        log.info("Catalog opened");
        driver.findElement(By.xpath(computersAndNetworksPage.getPathComputersAndNetworks())).click();
        computersAndNetworksPage.clickOnItem(ComputersAndNetworksItems.ACCESSORIES);
        log.info("Accessories opened");
        List<WebElement> accessoriesList = driver.findElements(By.xpath(computersAndNetworksPage.getPathToElementsInAccessories()));
        System.out.println("Number of elements:" + accessoriesList.size());
        for (WebElement e : accessoriesList) {
            Assertions.assertTrue(e.isDisplayed());
        }
        log.info("Assertion passed");

    }


    @Test
    public void testAccessoriesName() {

        ComputersAndNetworksPage computersAndNetworksPage = new ComputersAndNetworksPage();
        driver.findElement(mainPage.openCatalog()).click();
        log.info("Catalog opened");
        driver.findElement(By.xpath(computersAndNetworksPage.getPathComputersAndNetworks())).click();
        computersAndNetworksPage.clickOnItem(ComputersAndNetworksItems.ACCESSORIES);
        log.info("Accessories opened");
        //название
        List<WebElement> accessoriesListNames = driver.findElements(By.xpath("//div[text()=' Комплектующие ']/..//span[contains(@class, 'title')]"));
        for (WebElement e : accessoriesListNames) {
            Assertions.assertTrue(e.isDisplayed());
        }
        log.info("Assertion passed");
    }

    @Test
    public void testAccessoriesQuantity() {

        ComputersAndNetworksPage computersAndNetworksPage = new ComputersAndNetworksPage();
        driver.findElement(mainPage.openCatalog()).click();
        log.info("Catalog opened");
        driver.findElement(By.xpath(computersAndNetworksPage.getPathComputersAndNetworks())).click();
        computersAndNetworksPage.clickOnItem(ComputersAndNetworksItems.ACCESSORIES);
        log.info("Accessories opened");
        // количество
        List<WebElement> accessoriesListQuantity = driver.findElements(By.xpath("//div[text()=' Комплектующие ']/..//span[3]/text()[1]/.."));
        for (WebElement e : accessoriesListQuantity) {
            Assertions.assertTrue(e.isDisplayed());
        }
        log.info("Assertion passed");
    }

    @Test
    public void testAccessoriesPrice() {

        ComputersAndNetworksPage computersAndNetworksPage = new ComputersAndNetworksPage();
        driver.findElement(mainPage.openCatalog()).click();
        log.info("Catalog opened");
        driver.findElement(By.xpath(computersAndNetworksPage.getPathComputersAndNetworks())).click();
        computersAndNetworksPage.clickOnItem(ComputersAndNetworksItems.ACCESSORIES);
        log.info("Accessories opened");
        // цена
        List<WebElement> accessoriesListPrice = driver.findElements(By.xpath("//div[text()=' Комплектующие ']/..//span//following-sibling::text()[1]/.."));
        for (WebElement e : accessoriesListPrice) {

            Assertions.assertTrue(e.isDisplayed());
        }
        log.info("Assertion passed");
    }

    @AfterEach
    public void cleanUp() {
        WebDriverRun.closeDriver();
        log.info("Browser closed");
    }

}
