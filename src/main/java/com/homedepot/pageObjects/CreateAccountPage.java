package com.homedepot.pageObjects;

import com.homedepot.common.Library;
import org.openqa.selenium.By;

public class CreateAccountPage {


    private Library library;

    public CreateAccountPage() {
        library = new Library();
    }

    public void fillOut() {
        library.enter("Email Address textbox", "shdfhsf@gmail.com", By.cssSelector("#email"));
        library.enter("Password textbox", "Cyram@123", By.cssSelector("#password-input-field"));
        library.enter("Zipcode textbox", "98832", By.cssSelector("#zipCode"));
        library.enter("Phone textbox", "7667888298", By.cssSelector("#phone"));
        library.click("Create an Account button", By.cssSelector("[type='submit']"));
        library.click("Skip for now & Continue Shopping buttin", By.cssSelector("[data-automation-id='subscriptionsSkipForNowContinueShoppingButton']"));
    }

}
