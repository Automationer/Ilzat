package com.homedepot.pageObjects.popups;

import com.homedepot.base.Base;
import com.homedepot.common.Library;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaveToFavourites_Popup {

    @FindBy(css = ".list--save__holder button") public WebElement save_button;
    @FindBy(xpath = "//a[text()='View Favorites']") public WebElement viewFav_hyperLink;

    private Library library;

    public SaveToFavourites_Popup() {
        PageFactory.initElements(Base.getDriver(), this);
        library = new Library();
    }

    public void save() {
        library.click(save_button);
    }

    public void ViewFavourites() {
        viewFav_hyperLink.click();
    }

}
