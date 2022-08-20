package com.seleniumdemo.tests;

import com.seleniumdemo.models.CustomerDetails;
import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.pages.OrdersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyProductTest extends BaseTest {
    @Test
    public void BuyTest(){
        CustomerDetails customer = new CustomerDetails();
        String productTitle = "GIT basics";
        OrdersPage order = new HomePage(driver).OpenShopPage().OpenProductPage(productTitle)
                            .addToCart().openCheckoutPage().openBillingsPage()
                            .fillInCustomerData(customer);
        Assert.assertEquals(order.getThanksStatement().getText(),"Thank you. Your order has been received.");
        Assert.assertEquals(order.getProductStatement().getText(),productTitle + " × 1");
    }
}
