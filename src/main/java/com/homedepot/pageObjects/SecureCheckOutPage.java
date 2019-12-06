package com.homedepot.pageObjects;

import com.homedepot.common.Library;
import org.openqa.selenium.By;

public class SecureCheckOutPage {

    private Library library;

    public SecureCheckOutPage() {
        library = new Library();
    }

    public void placeOrder() {
        fillOutShippingInfo();
        fillOutPaymentInfo();
        library.click("Place Order", By.cssSelector("[name='placeOrderButton']"));
    }

    private void fillOutShippingInfo() {
        library.enter("First name textbox", "Cyram", By.cssSelector("[name='firstName']"));
        library.enter("Last name textbox", "Solutions", By.cssSelector("[name='lastName']"));
        library.enter("Email textbox", "fhjshdf@gakd.com", By.cssSelector("[name='email']"));
        library.enter("Phone textbox", "61217678776", By.cssSelector("[name='phone']"));
        library.enter("Address textbox", "3301 main st", By.cssSelector("[name='line1']"));
        library.enter("Zipcode textbox", "22031", By.cssSelector("[name='zipCodeField']"));
        library.click("Confirm Zipcode Continue button", By.xpath("//span[text()='Continue']"));
        library.wait.waitUntilDisappears(By.cssSelector(".ReactModal__Content.ReactModal__Content--after-open"));
    }

    private void fillOutPaymentInfo() {
        library.enter("Card number textbox", "5105 1051 0510 5100", By.cssSelector("[name='cardNumber']"));
        library.selectDropdownByValue(By.cssSelector("[name='cardExpiryMonth']"), "12");
        library.selectDropdownByValue(By.cssSelector("[name='cardExpiryYear']"), "2026");
        library.enter("CVV field", "121", By.cssSelector("[name='cvvField']"));
    }

}
