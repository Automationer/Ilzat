package com.homedepot.smoke_tests;

import com.homedepot.base.Base;
import com.homedepot.common.CustomWait;
import com.homedepot.pageObjects.HomeDecorAndFurnitureTab;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ItemAddedToCart_PopUp_Test extends Base {

    private HomeDecorAndFurnitureTab homeDecorAndFurnitureTab = new HomeDecorAndFurnitureTab();
    private CustomWait wait = new CustomWait();

    @Test
    public void suggestedItems_Right_Left_Arrow_Buttons_Test() {
        homeDecorAndFurnitureTab.selectItem_AddToCart_HomeDecorAndFurniture(1);
        WebElement nextArrow_RightButton = library.find("Next arrow button", By.cssSelector("div>svg.carousel__next-button"));
        WebElement prevArrow_LeftButton = library.find("Prev arrow button", By.cssSelector("div>svg.carousel__prev-button"));
        boolean next_clickable = wait.isClickable(nextArrow_RightButton);
        nextArrow_RightButton.click();
        boolean prev_clickable = wait.isClickable(prevArrow_LeftButton);
        Assert.assertTrue(next_clickable);
        Assert.assertTrue(prev_clickable);
    }

}
