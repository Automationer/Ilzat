package com.homedepot.pageObjects;

import com.homedepot.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyFavouritesPage {

    @FindBy(css = ".grid>list-item-details")
    public List<WebElement> saved_items;

    public MyFavouritesPage() {
        PageFactory.initElements(Base.getDriver(), this);
    }

    public boolean isFavListEmpty() {
        return saved_items.size() <= 0;
    }

}
