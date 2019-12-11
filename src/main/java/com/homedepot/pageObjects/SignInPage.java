package com.homedepot.pageObjects;

import com.homedepot.base.Base;
import com.homedepot.common.Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    private Library library;

    @FindBy(css = "#email") WebElement email_textBox;
    @FindBy(css = "#password-input-field") WebElement password_textBox;
    @FindBy(css = "button.bttn--primary") WebElement signIn_button;
    @FindBy(css = "[data-automation-id='signInCreateAnAccountButton']") WebElement createAccount_button;

    public SignInPage() {
        library = new Library();
        PageFactory.initElements(Base.getDriver(), this);
    }

    public void signIn(String username, String password) {
        email_textBox.sendKeys(username);
        password_textBox.sendKeys(password);
        signIn_button.click();
    }

    public void clickOnCreateAccount() {
        createAccount_button.click();
    }


}
