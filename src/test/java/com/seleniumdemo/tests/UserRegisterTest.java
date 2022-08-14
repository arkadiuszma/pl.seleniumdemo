package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegisterTest extends BaseTest{
    @Test
    public void Register(){
        int randomNumber = (int) (Math.random()*10000);
        String name = "test" +  randomNumber;
        String email = name + "@wp.pl";
        WebElement userLogin = new HomePage(driver).OpenMyAccountPage().RegisterdUser(email, "Test@!1234").getUserAssertion();
        Assert.assertEquals(userLogin.getText(), "Hello " + name + " (not " + name + "? Log out)");
    }
    @Test
    public void ExistingEmailRegister(){
        String email = "test@wp.pl";
        WebElement userLogin = new HomePage(driver).OpenMyAccountPage().NotRegisterdUser(email, "Test@!1234").getUserAlert();
        Assert.assertEquals(userLogin.getText(), "Error: An account is already registered with your email address. Please log in.");
    }

}
