package com.homedepot.smoke_tests;

import com.homedepot.base.Base;
import com.homedepot.pageObjects.HomePage;
import com.homedepot.pageObjects.ProductDetailsPage;
import com.homedepot.pageObjects.ProductListPage;
import com.homedepot.pageObjects.SecureCheckOutPage;
import com.homedepot.pageObjects.popups.AddedToCart_PopUp;
import org.junit.Test;

public class CheckOut_Test extends Base {

    private HomePage homePage = new HomePage();
    private ProductListPage productListPage = new ProductListPage();
    private AddedToCart_PopUp addedToCart_popUp = new AddedToCart_PopUp();
    private SecureCheckOutPage secureCheckOutPage = new SecureCheckOutPage();
    private ProductDetailsPage productDetailsPage = new ProductDetailsPage();

    @Test
    public void checkOutItem_Test() {
        homePage.searchForItem("Couch");
        productListPage.selectAProduct(17);
        productDetailsPage.addToCart();
        addedToCart_popUp.checkOut();
        secureCheckOutPage.placeOrder();
    }

}
