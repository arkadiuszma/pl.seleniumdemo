package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy (xpath = "(//span[contains(text(),'My account')])[1]")
    private WebElement myAccountBtn;

    @FindBy (xpath = "(//span[contains(text(),'Shop')])[1]")
    private WebElement shopBtn;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public MyAccountPage OpenMyAccountPage(){
        myAccountBtn.click();
        return new MyAccountPage(driver);
    }
    public ShopPage OpenShopPage() {
        shopBtn.click();
        return new ShopPage(driver);
    }
}