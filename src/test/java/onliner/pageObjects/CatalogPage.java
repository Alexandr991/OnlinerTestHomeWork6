package onliner.pageObjects;

import onliner.utils.WebDriverRun;
import org.openqa.selenium.By;

public class CatalogPage {
    private static final String ITEM_PATTERN = "//span[@class='catalog-navigation-classifier__item-title-wrapper'] and contains(text(), '%s')]";

    public boolean isItemExists(String name) {
        return WebDriverRun.getDriver().findElement(By.xpath(String.format(ITEM_PATTERN, name))).isDisplayed();
    }

    public void clickOnItem(CatalogItems item) {
        WebDriverRun.getDriver().findElement(By.xpath(String.format(ITEM_PATTERN, item.getCatalogItem()))).click();
    }
}
//
//
//
// "//span[contains(@class,'main-navigation') and contains(text(), '%s')]";
