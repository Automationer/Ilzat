package com.homedepot.steps;

import com.homedepot.pageObjects.CreateAccountPage;
import com.homedepot.pageObjects.HomePage;
import com.homedepot.pageObjects.SignInPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class CreateAccount_stepDef {

    private SignInPage signInPage = new SignInPage();
    private CreateAccountPage createAccountPage = new CreateAccountPage();
    private HomePage homePage = new HomePage();

    @Given("^User clicks on Create Account button$")
    public void user_clicks_on_Create_Account_button() {
        signInPage.clickOnCreateAccount();
    }

    @Given("^User fills out account creation form$")
    public void user_fills_out_account_creation_form() {
        createAccountPage.fillOut();
    }

    @Then("^System creates a new account$")
    public void system_creates_a_new_account() {
        String actualText = homePage.login_header.getText();
        Assert.assertEquals("Welcome", actualText);
    }


}
