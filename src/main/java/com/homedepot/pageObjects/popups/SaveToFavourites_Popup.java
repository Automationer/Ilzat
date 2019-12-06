package com.homedepot.pageObjects.popups;

import com.homedepot.common.Library;
import org.openqa.selenium.By;

public class SaveToFavourites_Popup {

    private Library library;

    public SaveToFavourites_Popup() {
        library = new Library();
    }

    public void save() {
        library.click("Save button", By.cssSelector(".list--save__holder button"));
    }

    public void ViewFavourites() {
        library.click("View Favourites hyperlink", By.xpath("//a[text()='View Favorites']"));
    }

}
