package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {

    @FindBy (xpath = "//div[@class='woocommerce-order']//p")
    private WebElement thanksStatement;
    @FindBy(xpath = "//td[contains(@class, 'product-name')]")
    private WebElement productStatement;
    private WebDriver driver;
    public OrdersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getThanksStatement(){
        return thanksStatement;
    }
    public WebElement getProductStatement(){
        return  productStatement;
    }
}
