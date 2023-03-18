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


public class CatalogPageTest {
    private WebDriver driver;
    private MainPage mainPage;


    @BeforeEach
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium_java\\ChromeDriver\\chromedriver.exe");
        driver = WebDriverRun.getDriver();
        mainPage = new MainPage();
        driver.get(mainPage.openMainPage());

    }

    @Test
    public void testMainPage() {

        driver.findElement(mainPage.openCatalog()).click();
        CatalogPage catalogPage = new CatalogPage();
        Assertions.assertAll(
                () -> Assertions.assertTrue(catalogPage.isItemExists(CatalogItems.ELECTRONICS.getCatalogItem())),
                () -> Assertions.assertTrue(catalogPage.isItemExists(CatalogItems.APPLIANCES.getCatalogItem())),
                () -> Assertions.assertTrue(catalogPage.isItemExists(CatalogItems.AUTO_AND_MOTO.getCatalogItem())),
                () -> Assertions.assertTrue(catalogPage.isItemExists(CatalogItems.BEAUTY_AND_SPORTS.getCatalogItem())),
                () -> Assertions.assertTrue(catalogPage.isItemExists(CatalogItems.CHILDREN_AND_MOTHERS.getCatalogItem())),
                () -> Assertions.assertTrue(catalogPage.isItemExists(CatalogItems.COMPUTERS_AND_NETWORKS.getCatalogItem())),
                () -> Assertions.assertTrue(catalogPage.isItemExists(CatalogItems.FOOD.getCatalogItem())),
                () -> Assertions.assertTrue(catalogPage.isItemExists(CatalogItems.HOUSE_AND_GARDEN.getCatalogItem())),
                () -> Assertions.assertTrue(catalogPage.isItemExists(CatalogItems.WORK_AND_OFFICE.getCatalogItem())),
                () -> Assertions.assertTrue(catalogPage.isItemExists(CatalogItems.CONSTRUCTION_AND_REPAIR.getCatalogItem()))
        );

    }

    @AfterEach
    public void cleanUp() {
        WebDriverRun.closeDriver();
    }


}
