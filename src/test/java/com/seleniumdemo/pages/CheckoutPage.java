package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    @FindBy (xpath = "//a[contains(text(),'Proceed to checkout')]")
    private WebElement proceedCheckoutButton;
    private WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public BillingPage openBillingsPage(){
        proceedCheckoutButton.click();
        return new BillingPage(driver);
    }
}
