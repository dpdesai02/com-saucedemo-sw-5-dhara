package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(id = "user-name")
    WebElement usernameField;
    @CacheLookup
    @FindBy(id ="password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(id ="login-button")
    WebElement loginButton;


    public void sendTextToUsernameField(String username) {

        sendTextToElement(usernameField,username);
        CustomListeners.test.log(Status.PASS,"sendTextToUsernameField " + username);
        }


    public void sendTextToPasswordField(String password) {

        sendTextToElement(passwordField,password);
    }
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS,"Click on loginButton");
    }
}