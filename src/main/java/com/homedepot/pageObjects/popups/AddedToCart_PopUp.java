package com.homedepot.pageObjects.popups;

import com.homedepot.base.Base;
import com.homedepot.common.Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddedToCart_PopUp {

    private Library library;

    @FindBy(css = "header.thd-overlay__header span:nth-child(2)")
    public WebElement shoppingCartView_headerMessage;

    @FindBy(css = "a[data-automation-id='viewCartButton']")
    WebElement viewCart_button;

    public AddedToCart_PopUp() {
        library = new Library();
        PageFactory.initElements(Base.getDriver(), this);
    }

    public void viewCart() {
        viewCart_button.click();
    }

    public void checkOut() {
        library.switchToIframe(By.cssSelector(".thd-overlay-frame"));
        library.click("Check out button", By.xpath("//span[text()='Checkout']"));
        library.click("Check out as a guest button", By.xpath("//span[text()='Checkout as a Guest']"));
    }

}
