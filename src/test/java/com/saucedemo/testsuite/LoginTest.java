package com.saucedemo.testsuite;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductPage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
    }

    //method to login with successful credentials
    @Test(groups = {"sanity", "regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //enter username
        loginPage.sendTextToUsernameField("standard_user");
        //enter password
        loginPage.sendTextToPasswordField("secret_sauce");
        //login
        loginPage.clickOnLoginButton();
        String expectedProductsText = "Products";
        String actualProductsText = String.valueOf(productPage.getProductText());
        //verify whether products text is displayed
        Assert.assertEquals(actualProductsText, expectedProductsText, "Products text not displayed");
    }

}

