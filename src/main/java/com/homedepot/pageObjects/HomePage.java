package com.homedepot.pageObjects;

import com.homedepot.base.Base;
import com.homedepot.common.Library;
import org.openqa.selenium.By;

public class HomePage extends Base {

    private Library library;

    public HomePage() {
        library = new Library();
    }

    public void goToSignInPage() {
        library.click("My Account header", By.cssSelector("#headerMyAccount"));
        library.click("Sign in button", By.cssSelector("p>[title='Sign in to your account']"));

    }

    public void searchForItem(String itemName) {
        library.enter("Search Box", itemName, By.cssSelector("#headerSearch"));
        library.click("Search button", By.cssSelector("#headerSearchButton"));
    }

}
