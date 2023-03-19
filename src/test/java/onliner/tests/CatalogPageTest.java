package onliner.tests;

import onliner.pageObjects.CatalogItems;
import onliner.pageObjects.CatalogPage;
import onliner.pageObjects.MainPage;
import onliner.utils.WebDriverRun;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class CatalogPageTest {
    private WebDriver driver;
    private MainPage mainPage;


    @BeforeEach
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium_java\\ChromeDriver\\chromedriver.exe");
        driver = WebDriverRun.getDriver();
        mainPage = new MainPage();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(mainPage.openMainPage());


    }

    @Test
    public void testMainPage() {
        CatalogPage catalogPage = new CatalogPage();
        driver.findElement(mainPage.openCatalog()).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        Assertions.assertAll(
                () -> Assertions.assertTrue(catalogPage.isItemExists(CatalogItems.ELECTRONICS.getItemId())),
                () -> Assertions.assertTrue(catalogPage.isItemExists(CatalogItems.APPLIANCES.getItemId())),
                () -> Assertions.assertTrue(catalogPage.isItemExists(CatalogItems.AUTO_AND_MOTO.getItemId())),
                () -> Assertions.assertTrue(catalogPage.isItemExists(CatalogItems.BEAUTY_AND_SPORTS.getItemId())),
                () -> Assertions.assertTrue(catalogPage.isItemExists(CatalogItems.CHILDREN_AND_MOTHERS.getItemId())),
                () -> Assertions.assertTrue(catalogPage.isItemExists(CatalogItems.COMPUTERS_AND_NETWORKS.getItemId())),
                () -> Assertions.assertTrue(catalogPage.isItemExists(CatalogItems.HOUSE_AND_GARDEN.getItemId())),
                () -> Assertions.assertTrue(catalogPage.isItemExists(CatalogItems.CONSTRUCTION_AND_REPAIR.getItemId()))
        );

    }

    @AfterEach
    public void cleanUp() {
        WebDriverRun.closeDriver();
    }


}
