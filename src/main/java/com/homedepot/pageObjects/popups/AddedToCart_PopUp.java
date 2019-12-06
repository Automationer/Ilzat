package com.homedepot.pageObjects.popups;

import com.homedepot.common.Library;
import org.openqa.selenium.By;

public class AddedToCart_PopUp {

    private Library library;

    public AddedToCart_PopUp() {
        library = new Library();
    }

    public void viewCart() {
        library.click("View Cart button", By.cssSelector("a[data-automation-id='viewCartButton']"));
    }

    public void checkOut() {
        library.switchToIframe(By.cssSelector(".thd-overlay-frame"));
        library.click("Check out button", By.xpath("//span[text()='Checkout']"));
        library.click("Check out as a guest button", By.xpath("//span[text()='Checkout as a Guest']"));
    }

}
