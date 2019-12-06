package com.homedepot.smoke_tests;

import com.homedepot.base.Base;
import com.homedepot.common.Library;
import com.homedepot.pageObjects.HomePage;
import com.homedepot.pageObjects.SignInPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends Base {

    private HomePage homePage = new HomePage();
    private SignInPage signInPage = new SignInPage();
    private Library library = new Library();

    @Test
    public void validLogin_Test() {
        homePage.goToSignInPage();
        signInPage.signIn("mmejrih@codingliteracy.com", "cyramautomation123");
        String actualText = library.find("Logged In header", By.cssSelector("a>#headerMyAccountTitle>span")).getText();
        Assert.assertEquals("Welcome", actualText);
    }

    @Test
    public void invalidLogin_Test() {
        homePage.goToSignInPage();
        signInPage.signIn("mmejrih@codingliteracy.com", "invalidpassword");
        String actual = driver.getCurrentUrl();
        Assert.assertEquals("https://www.homedepot.com/", actual);
    }

    @Test
    public void createNewAccount_Test() {
        homePage.goToSignInPage();
        signInPage
                .clickOnCreateAccount()
                .fillOut();
        String actualText = library.find("Logged In header", By.cssSelector("a>#headerMyAccountTitle>span")).getText();
        Assert.assertEquals("Welcome", actualText);
    }

}




















