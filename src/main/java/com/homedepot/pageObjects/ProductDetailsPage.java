package com.homedepot.pageObjects;

import com.homedepot.common.Library;
import org.openqa.selenium.By;

public class ProductDetailsPage {

    private Library library;

    public ProductDetailsPage() {
        library = new Library();
    }

    public void addToCart() {
        library.click("Add to cart button", By.xpath("//span[text()='Add to Cart']"));
    }

}
