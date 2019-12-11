@shopping_cart

Feature: Shopping Cart

  Background:
    Given User selects an item
    And User adds it to shopping cart

  @addItem
  Scenario: Add an item to shopping cart
    Then Verify that item is successfully added to the shopping cart

  @removeItem
  Scenario: Remove an item from shopping cart
    And User removes item from the shopping cart
    Then verify that item is removed successfully

  @itemQnty
  Scenario: Increase item quantity
    And User increase item quantity
    Then Verify that item quantity is increased

  @saveFav
  Scenario: Save to favourites
    When User saves item to favourites
    Then Item should be saved in default favourites list