package com.homedepot.pageObjects;

import com.homedepot.base.Base;
import com.homedepot.common.Library;
import com.homedepot.pageObjects.sections.HeaderSection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomeDecorAndFurnitureTab {

    private HeaderSection headerSection = new HeaderSection();
    private ProductListPage productListPage = new ProductListPage();
    private Library library;

    @FindBy(xpath = "(//div[@class='homeDecorFurnitureFlyout__bay  '])[6]/div/a")
    List<WebElement> fragranceAndCandles_links;

    @FindBy(css = ".thd-overlay-frame") WebElement iframe;

    public HomeDecorAndFurnitureTab() {
        library = new Library();
        PageFactory.initElements(Base.getDriver(), this);
    }

    public List<WebElement> getFragrancesAndCandlesLinks() {
        return fragranceAndCandles_links;
    }

    public void addToCart_HomeDecorAndFurniture() {
        productListPage.hoverOverItem(0);
        library.switchToIframe(iframe);
    }

    public void selectItem(int optionIndex) {
        List<WebElement> headerTabs = headerSection.getHeaderTabs();
        library.hoverOver("Home Decor & Furniture tab", headerTabs.get(1));
        getFragrancesAndCandlesLinks().get(optionIndex).click();
        productListPage.hoverOverItem(0);
    }

}
