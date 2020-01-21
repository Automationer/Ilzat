package com.homedepot.steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AppLoading_stepDef {

    @Given("^User goes to AUT$")
    public void user_goes_to_AUT() {
        System.out.println("went to AUT");
    }

    @Then("^AUT should open$")
    public void aut_should_open() {
        System.out.println("AUT launched successfully");
    }

}
