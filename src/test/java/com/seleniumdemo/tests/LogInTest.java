package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {
    @Test
    public void LogIn(){
        String username = "test";
        WebElement userLogin = new HomePage(driver).OpenMyAccountPage().CorrectLogIn(username, "Test@!1234").getUserAssertion();
        Assert.assertEquals(userLogin.getText(), "Hello " + username + " (not " + username + "? Log out)");
    }
    @Test
    public void WrongLogin(){
        String username = "wronginput";
        WebElement userLogin = new HomePage(driver).OpenMyAccountPage().WrongLogIn(username, "Test@!1234").getUserAlert();
        Assert.assertTrue(userLogin.getText().contains("ERROR: Incorrect username or password."));
    }
}
