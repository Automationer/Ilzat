package com.homedepot.pageObjects;

import com.homedepot.common.Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListPage {

    private Library library;

    public ProductListPage() {
        library = new Library();
    }

    private By productList = By.cssSelector(".product-result__wrapped-results>div>div");

    public void selectAProduct(int index) {
        List<WebElement> items = library.findAll("Items", productList);
        library.scrollToElement(items.get(index));
        items.get(index).click();
        library.switchTab();
    }

    public void hoverOverItemThenAddToCart(int elementIndex) {
        List<WebElement> items = library.findAll("Items", productList);
        library.scrollToElement(items.get(elementIndex));
        library.hoverOver("Add To Cart button", items.get(elementIndex));
        library.click("Add To Cart button", By.xpath("(//*[@class='product-result__wrapped-results']/div/div/div[2]/div[6]/div/div[2]/div/button/span)[1]"));
    }

}
