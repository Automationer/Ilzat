package com.homedepot.pageObjects;

import com.homedepot.base.Base;
import com.homedepot.common.Library;
import com.homedepot.pageObjects.popups.SaveToFavourites_Popup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    private Library library;
    private SaveToFavourites_Popup saveToFavourites_popup = new SaveToFavourites_Popup();

    @FindBy(css = "a[data-automation-id='removeItem']") WebElement remove_button;
    @FindBy(css = "[data-automation-id='appEmptyShoppingCartText']") public WebElement cartEmpty_message;
    @FindBy(css = "[type='tel']") public WebElement itemQnty_box;
    @FindBy(xpath = "//a[text()='Save to Favorites']") public WebElement saveToFav_hyperLink;

    public ShoppingCartPage() {
        library = new Library();
        PageFactory.initElements(Base.getDriver(), this);
    }

    public void checkOut() {
        library.click("Check Out button", By.xpath("(//button[@class='bttn bttn--primary'])[3]"));
    }

    public void increaseItemQuantity(String quantity) {
        itemQnty_box.click();
        itemQnty_box.clear();
        itemQnty_box.sendKeys(quantity);
    }

    public void removeItem() {
        remove_button.click();
    }

    public void saveToFavourites() {
        library.click(saveToFav_hyperLink);
        saveToFavourites_popup.save();
    }


}
