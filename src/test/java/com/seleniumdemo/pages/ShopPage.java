package com.seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {
    private WebDriver driver;
    public ShopPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public ProductPage OpenProductPage(String productTitle) {
        driver.findElement(By.xpath("//h2[text()='" + productTitle + "']")).click();
        return new ProductPage(driver);
    }
}
