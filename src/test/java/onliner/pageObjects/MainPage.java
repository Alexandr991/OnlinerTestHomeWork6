package onliner.pageObjects;

import onliner.utils.WebDriverRun;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private static final String mainPageURL = "https://www.onliner.by";
    private static final By MAIN_PAGE_ELEMENT_CATALOG = By.xpath("//span[@class ='b-main-navigation__text'][text()='Каталог']");


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
