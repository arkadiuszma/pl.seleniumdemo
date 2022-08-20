package com.seleniumdemo.pages;

import com.seleniumdemo.models.CustomerDetails;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BillingPage {
    @FindBy(id = "billing_first_name")
    private WebElement firstName;

    @FindBy(id = "billing_last_name")
    private WebElement lastName;

    @FindBy(id = "billing_company")
    private WebElement companyName;

    @FindBy(id = "billing_country")
    private WebElement country;

    @FindBy(id = "billing_address_1")
    private WebElement address;

    @FindBy(id = "billing_postcode")
    private WebElement postCode;

    @FindBy(id = "billing_city")
    private WebElement city;

    @FindBy(id = "billing_phone")
    private WebElement phone;

    @FindBy(id = "billing_email")
    private WebElement email;

    @FindBy(name = "woocommerce_checkout_place_order")
    private WebElement placeOrderButton;
    private WebDriver driver;

    public BillingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrdersPage fillInCustomerData(CustomerDetails customer) {
        firstName.sendKeys(customer.getFirstName());
        lastName.sendKeys(customer.getLastName());
        companyName.sendKeys(customer.getCompany());
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText(customer.getCountry());
        address.sendKeys(customer.getAddress());
        postCode.sendKeys(customer.getPostCode());
        city.sendKeys(customer.getCity());
        phone.sendKeys(customer.getPhone());
        email.sendKeys(customer.getEmail());
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", placeOrderButton);
        return new OrdersPage(driver);
    }
}