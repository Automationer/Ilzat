package com.homedepot.steps;


import com.homedepot.pageObjects.HomeDecorAndFurnitureTab;
import com.homedepot.pageObjects.MyFavouritesPage;
import com.homedepot.pageObjects.ProductListPage;
import com.homedepot.pageObjects.ShoppingCartPage;
import com.homedepot.pageObjects.popups.AddedToCart_PopUp;
import com.homedepot.pageObjects.popups.SaveToFavourites_Popup;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ShoppingCart_stepDef {

    private ProductListPage productListPage = new ProductListPage();
    private HomeDecorAndFurnitureTab homeDecorAndFurnitureTab = new HomeDecorAndFurnitureTab();
    private AddedToCart_PopUp addedToCart_popUp = new AddedToCart_PopUp();
    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    private SaveToFavourites_Popup saveToFavourites_popup = new SaveToFavourites_Popup();
    private MyFavouritesPage myFavouritesPage = new MyFavouritesPage();

    @Given("^User selects an item$")
    public void user_selects_an_item() {
        homeDecorAndFurnitureTab.selectItem(1);
    }

    @And("^User adds it to shopping cart$")
    public void user_adds_it_to_shopping_cart() {
        productListPage.addToCart();
    }

    @Then("^Verify that item is successfully added to the shopping cart$")
    public void verify_that_item_is_successfully_added_to_the_shopping_cart() {
        String actualText = addedToCart_popUp.shoppingCartView_headerMessage.getText();
        System.out.println(actualText);
        Assert.assertEquals("1 Item Added to Cart", actualText);
    }

    @Given("^User removes item from the shopping cart$")
    public void user_removes_item_from_the_shopping_cart() {
        addedToCart_popUp.viewCart();
        shoppingCartPage.removeItem();
    }

    @Then("^verify that item is removed successfully$")
    public void verify_that_item_is_removed_successfully() {
        String actual = shoppingCartPage.cartEmpty_message.getText();
        System.out.println(actual);
        Assert.assertEquals("Your shopping cart is empty.", actual);
    }

    @And("^User increase item quantity$")
    public void user_increase_item_quantity() {
        addedToCart_popUp.viewCart();
        shoppingCartPage.increaseItemQuantity("3");
    }

    @Then("^Verify that item quantity is increased$")
    public void verify_that_item_quantity_is_increased() {
        String value = shoppingCartPage.itemQnty_box.getAttribute("value");
        Assert.assertEquals("3", value);
    }

    @When("^User saves item to favourites$")
    public void user_saves_item_to_favourites() {
        addedToCart_popUp.viewCart();
        shoppingCartPage.saveToFavourites();
    }

    @Then("^Item should be saved in default favourites list$")
    public void item_should_be_saved_in_default_favourites_list() {
        saveToFavourites_popup.ViewFavourites();
        Assert.assertFalse(myFavouritesPage.isFavListEmpty());
    }

}
