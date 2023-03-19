package onliner.pageObjects;

import onliner.utils.WebDriverRun;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private static final String mainPageURL = "https://www.onliner.by";
    private static final By MAIN_PAGE_ELEMENT_CATALOG = By.xpath("//a[@href='https://catalog.onliner.by'][@class = 'b-main-navigation__link']");

////a[contains(@href, 'catalog') and contains(text(), 'Каталог')]

    //a[@href='https://catalog.onliner.by' and contains(text(),'Каталог')]

    //a[@href="https://catalog.onliner.by"][@class = "b-main-navigation__link"]
    public String openMainPage() {
        return mainPageURL;


    }
    public By openCatalog (){
        return MAIN_PAGE_ELEMENT_CATALOG;
    }

    public void closeMainPage() {
        WebDriverRun.closeDriver();
    }
}
