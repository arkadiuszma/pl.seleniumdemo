package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    @FindBy (id = "reg_email")
    private WebElement emailInput;

    @FindBy (id = "reg_password")
    private WebElement passwordInput;

    @FindBy (xpath = "//button[contains(text(),'Register')]")
    private WebElement registerButton;

    @FindBy (xpath = "//ul[@role='alert']//li")
    private WebElement userAlert;

    @FindBy (id = "username")
    private WebElement username;

    @FindBy (id = "password")
    private WebElement userPassword;

    @FindBy (xpath = "//button[@value='Log in']")
    private WebElement logInButton;

    private WebDriver driver;
    public MyAccountPage (WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public LoggedUserPage RegisterdUser (String email, String password){
        userRegistration(email, password);
        return new LoggedUserPage(driver);
    }
    public MyAccountPage NotRegisterdUser (String email, String password) {
        userRegistration(email, password);
        return this;
    }
    private void userRegistration(String email, String password){
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        registerButton.click();
    }
    public WebElement getUserAlert() {
        return userAlert;
    }
    public LoggedUserPage CorrectLogIn (String username, String password){
        LogIn(username, password);
        return new LoggedUserPage(driver);
    }
    public MyAccountPage WrongLogIn (String username, String password) {
        LogIn(username, password);
        return this;
    }
    private void LogIn(String email, String password) {
        username.clear();
        username.sendKeys(email);
        userPassword.clear();
        userPassword.sendKeys(password);
        logInButton.click();
    }
}
