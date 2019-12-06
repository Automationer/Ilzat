package com.homedepot.pageObjects;

import com.homedepot.common.Library;
import com.homedepot.pageObjects.sections.HeaderSection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeDecorAndFurnitureTab {

    private HeaderSection headerSection = new HeaderSection();
    private ProductListPage productListPage = new ProductListPage();
    private Library library;

    public HomeDecorAndFurnitureTab() {
        library = new Library();
    }

    public List<WebElement> getFragrancesAndCandlesLinks() {
        List<WebElement> all = library.findAll("Fragrance & Candles links", By.xpath("(//div[@class='homeDecorFurnitureFlyout__bay  '])[6]/div/a"));
        return all;
    }

    public void selectItem_AddToCart_HomeDecorAndFurniture(int optionIndex) {
        List<WebElement> headerTabs = headerSection.getHeaderTabs();
        library.hoverOver("Home Decor & Furniture tab", headerTabs.get(1));
        WebElement candle = getFragrancesAndCandlesLinks().get(optionIndex);
        candle.click();
        productListPage.hoverOverItemThenAddToCart(0);
        library.switchToIframe(By.cssSelector(".thd-overlay-frame"));
    }

}
