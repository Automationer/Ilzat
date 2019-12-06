package com.homedepot.pageObjects;

import com.homedepot.common.Library;
import com.homedepot.pageObjects.popups.SaveToFavourites_Popup;
import org.openqa.selenium.By;

public class ShoppingCartPage {

    private Library library;
    private SaveToFavourites_Popup saveToFavourites_popup = new SaveToFavourites_Popup();

    public ShoppingCartPage() {
        library = new Library();
    }

    public void checkOut() {
        library.click("Check Out button", By.xpath("(//button[@class='bttn bttn--primary'])[3]"));
    }

    public By increaseItemQuantity(String quantity) {
        By by = By.cssSelector("[type='tel']");
        library.click("Quantity box", by);
        library.find("Quantity box", by).clear();
        library.enter("Quantity box", quantity, by);
        return by;
    }

    public void removeItem() {
        library.click("Remove button", By.cssSelector("[data-automation-id='removeItem']"));
    }

    public void saveToFavourites() {
        library.click("Save to Favourites hyperlink", By.xpath("//a[text()='Save to Favorites']"));
        saveToFavourites_popup.save();
    }


}
