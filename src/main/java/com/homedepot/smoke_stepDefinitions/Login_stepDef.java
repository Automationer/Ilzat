package com.homedepot.smoke_stepDefinitions;

import com.homedepot.base.Base;
import com.homedepot.common.Library;
import com.homedepot.pageObjects.HomePage;
import com.homedepot.pageObjects.SignInPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class Login_stepDef {

    private HomePage homePage = new HomePage();
    private SignInPage signInPage = new SignInPage();
    private Library library = new Library();

    @Given("^User is on login page$")
    public void user_is_on_login_page() {
        homePage.goToSignInPage();
    }

    @And("^User enters valid username and password$")
    public void user_enters_valid_username_and_password() {
        signInPage.signIn("mmejrih@codingliteracy.com", "cyramautomation123");
    }

    @Then("^Verify that user successfully logged in$")
    public void verify_that_user_successfully_logged_in() {
        String actualText = homePage.login_header.getText();
        Assert.assertEquals("Welcome", actualText);
    }

    @And("^User enters invalid username or password$")
    public void user_enters_invalid_username_or_password() {
        signInPage.signIn("mmejrih@codingliteracy.com", "invalidpassword");
    }

    @Then("^Verify that user cannot successfully logged in$")
    public void verify_that_user_cannot_successfully_logged_in() {
        String actual = Base.getDriver().getCurrentUrl();
        Assert.assertEquals("https://www.homedepot.com/", actual);
    }

}
