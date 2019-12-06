package com.homedepot.pageObjects;

import com.homedepot.common.Library;
import org.openqa.selenium.By;

public class SignInPage {

    private Library library;

    public SignInPage() {
        library = new Library();
    }

    public void signIn(String username, String password) {
        library.enter("Email textbox", username, By.cssSelector("#email"));
        library.enter("Password textbox", password, By.cssSelector("#password-input-field"));
        library.click("Sign in button", By.cssSelector("button.bttn--primary"));
    }

    public CreateAccountPage clickOnCreateAccount() {
        library.click("Create An Account button", By.cssSelector("[data-automation-id='signInCreateAnAccountButton']"));
        return new CreateAccountPage();
    }


}
