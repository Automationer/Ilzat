package com.homedepot.pageObjects;

import com.homedepot.base.Base;
import com.homedepot.common.Library;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

    private Library library;

    @FindBy(css = "#email")
    WebElement emailAddress_textBox;
    @FindBy(css = "#password-input-field")
    WebElement password_textBox;
    @FindBy(css = "#zipCode")
    WebElement zipCode_textBox;
    @FindBy(css = "#phone")
    WebElement phone_textBox;
    @FindBy(css = "[type='submit']")
    WebElement createAccount_button;
    @FindBy(css = "[data-automation-id='subscriptionsSkipForNowContinueShoppingButton']")
    WebElement continueShopping_button;

    public CreateAccountPage() {
        library = new Library();
        PageFactory.initElements(Base.getDriver(), this);
    }

    public void fillOut() {
        emailAddress_textBox.sendKeys("uiiiuu@gmail.com");
        password_textBox.sendKeys("Cyram@123");
        zipCode_textBox.sendKeys("98832");
        phone_textBox.sendKeys("7667888298");
        createAccount_button.click();
        continueShopping_button.click();
    }

}
