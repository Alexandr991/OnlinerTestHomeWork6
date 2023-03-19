package onliner.pageObjects;

import onliner.utils.WebDriverRun;
import org.openqa.selenium.By;

public class ComputersAndNetworksPage {
    private static final String ITEM_PATTERN = "//div[@class='catalog-navigation-list__aside-title'] [text() = '%s')]";

    //   всплывающее окно (компьютеры и сети)
    private static final String COMPUTERS_AND_NETWORKS = "//li[@data-id=\"2\"]";

    // элемент в комплектующих
    private static final String ELEMENTS_IN_ACCESSORIES = "//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']//a[@class='catalog-navigation-list__dropdown-item']";


    public boolean isItemExists(String name) {
        return WebDriverRun.getDriver().findElement(By.xpath(String.format(ITEM_PATTERN, name))).isDisplayed();
    }

    public void clickOnItem(ComputersAndNetworksItems item) {
        WebDriverRun.getDriver().findElement(By.xpath(String.format(ITEM_PATTERN, item.getComputerItems()))).click();
    }

    public String getPathComputersAndNetworks() {
        return COMPUTERS_AND_NETWORKS;
    }
    public String getPathToElementsInAccessories() {
        return ELEMENTS_IN_ACCESSORIES;
    }

}

