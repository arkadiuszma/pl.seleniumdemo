package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    @FindBy (name = "add-to-cart")
    private WebElement addButton;
    @FindBy (xpath = "//div[@role='alert']//a[text()='View cart']")
    private WebElement viewCart;
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public ProductPage addToCart(){
        addButton.click();
        return this;
    }

    public CheckoutPage openCheckoutPage(){
        viewCart.click();
        return new CheckoutPage (driver);
    }
}
