package com.saucedemo.testsuite;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductPage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    //method to verify six products are displayed per page

    LoginPage loginPage;
    ProductPage productPage;

    @BeforeMethod
    public void inIt(){
     loginPage   = new LoginPage();
     productPage = new ProductPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatSixProductsAreDisplayedOnPage() {

            loginPage.sendTextToUsernameField("standard_user");
            //enter password
            loginPage.sendTextToPasswordField("secret_sauce");
            //login
            loginPage.clickOnLoginButton();
            String productPerPage = "6";
            Assert.assertEquals(productPage.getProductsPerPage(), productPerPage);
        }
    }


