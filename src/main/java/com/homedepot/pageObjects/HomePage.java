package com.homedepot.pageObjects;

import com.homedepot.base.Base;
import com.homedepot.common.Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private Library library;

    @FindBy(css = "#headerMyAccount") WebElement myAccount_header;
    @FindBy(css = "p>[title='Sign in to your account']") WebElement signIn_button;
    @FindBy(css = "a>#headerMyAccountTitle>span") public WebElement login_header;

    public HomePage() {
        library = new Library();
        PageFactory.initElements(Base.getDriver(), this);
    }

    public void goToSignInPage() {
        myAccount_header.click();
        signIn_button.click();
    }

    public void searchForItem(String itemName) {
        library.enter("Search Box", itemName, By.cssSelector("#headerSearch"));
        library.click("Search button", By.cssSelector("#headerSearchButton"));
    }

}
