@CreateNewAccount
Feature: Create new account

  Scenario: User creates a new account
    Given User is on login page
    And User clicks on Create Account button
    And User fills out account creation form
    Then System creates a new account