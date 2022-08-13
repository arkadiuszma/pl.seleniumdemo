package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.pages.MyAccountPage;
import org.testng.annotations.Test;

public class UserRegisterTest extends BaseTest{
    @Test
    public void register(){
        new HomePage(driver).OpenMyAccountPage();

    }
}
