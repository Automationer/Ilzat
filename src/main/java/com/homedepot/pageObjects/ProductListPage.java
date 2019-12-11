package com.homedepot.pageObjects;

import com.homedepot.base.Base;
import com.homedepot.common.Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductListPage {

    private Library library;

    @FindBy(xpath = "(//*[@class='product-result__wrapped-results']/div/div/div)[1]/div[2]/div[6]/div/div[2]/div/button/span")
    WebElement addToCart_button;

    @FindBy(css = ".thd-overlay-frame") WebElement iframe;

    public ProductListPage() {
        library = new Library();
        PageFactory.initElements(Base.getDriver(), this);
    }

    private By productList = By.cssSelector(".product-result__wrapped-results>div>div");

    public void selectAProduct(int index) {
        List<WebElement> items = library.findAll("Items", productList);
        library.scrollToElement(items.get(index));
        items.get(index).click();
        library.switchTab();
    }

    public void hoverOverItem(int elementIndex) {
        List<WebElement> items = library.findAll("Items", productList);
        library.scrollToElement(items.get(elementIndex));
        library.hoverOver("Add To Cart button", items.get(elementIndex));
    }

    public void addToCart() {
        addToCart_button.click();
        library.switchToIframe(iframe);
    }

}
