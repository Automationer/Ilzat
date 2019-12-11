@SmokeTest

Feature: Login


  Scenario: Successful login with valid credentials
    Given User is on login page
    And User enters valid username and password
    Then Verify that user successfully logged in

  @loginTest
  Scenario: UnSuccessful login with invalid credentials
    Given User is on login page
    And User enters invalid username or password
    Then Verify that user cannot successfully logged in
