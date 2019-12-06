package com.homedepot.smoke_tests;

import com.homedepot.base.Base;
import com.homedepot.pageObjects.HomeDecorAndFurnitureTab;
import com.homedepot.pageObjects.ShoppingCartPage;
import com.homedepot.pageObjects.popups.AddedToCart_PopUp;
import com.homedepot.pageObjects.popups.SaveToFavourites_Popup;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCart_Test extends Base {

    private AddedToCart_PopUp addedToCart_popUp = new AddedToCart_PopUp();
    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    private HomeDecorAndFurnitureTab homeDecorAndFurnitureTab = new HomeDecorAndFurnitureTab();
    private SaveToFavourites_Popup saveToFavourites_popup = new SaveToFavourites_Popup();

    @Test
    public void addItemToShoppingCart_Test() {
        homeDecorAndFurnitureTab.selectItem_AddToCart_HomeDecorAndFurniture(1);
        String actualText = library.find("Shopping Cart view header", By.cssSelector("header.thd-overlay__header span:nth-child(2)")).getText();
        System.out.println(actualText);
        Assert.assertEquals("1 Item Added to Cart", actualText);
    }

    @Test
    public void increaseItemQuantity_Test() {
        homeDecorAndFurnitureTab.selectItem_AddToCart_HomeDecorAndFurniture(2);
        addedToCart_popUp.viewCart();
        By itemQuantity_boxLocator = shoppingCartPage.increaseItemQuantity("3");
        String value = library.find("Quantity box", itemQuantity_boxLocator).getAttribute("value");
        Assert.assertEquals("3", value);
    }

    @Test
    public void removeItemFromShoppingCart_Test() {
        homeDecorAndFurnitureTab.selectItem_AddToCart_HomeDecorAndFurniture(1);
        addedToCart_popUp.viewCart();
        shoppingCartPage.removeItem();
        String actual = library.find("Shopping Cart Empty message", By.cssSelector("[data-automation-id='appEmptyShoppingCartText']")).getText();
        System.out.println(actual);
        Assert.assertEquals("Your shopping cart is empty.", actual);
    }

    @Test
    public void saveToFavourites_Test() {
        homeDecorAndFurnitureTab.selectItem_AddToCart_HomeDecorAndFurniture(1);
        addedToCart_popUp.viewCart();
        shoppingCartPage.saveToFavourites();
        saveToFavourites_popup.ViewFavourites();
        List<WebElement> saved_favourite_items = library.findAll("Saved Favourite items", By.cssSelector(".grid>list-item-details"));
        Assert.assertTrue(saved_favourite_items.size() > 0);
    }

}
