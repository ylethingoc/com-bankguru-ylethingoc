package com.bankguru.login;

import commons.PageGeneratorManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ValidateLoginIntoSystem {
    WebDriver driver;
    LoginPageObject loginPage;
    RegisterPageObject registerPage;
    HomePageObject homePage;
    String loginPageURL, email;
    String userIDInfo, passwordInfo;


    @BeforeClass
    public void beforeClass() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = PageGeneratorManager.getLoginPage(driver);
        driver.get("http://demo.guru99.com/V4/");
        email = "selenium_demo" + randomNumber() + "@gmail.com";
    }

    @Test
    public void TC01_RegisterIntoSystem() {
        Assert.assertTrue(loginPage.isLoginFromDisplay("btnLogin"));
        loginPageURL = loginPage.getLoginPageURL();
        registerPage = loginPage.clickToHereLink();
        Assert.assertTrue(registerPage.isRegisterPageDisplay("emailid"));
        registerPage.inputToEmailTextbox(email, "emailid");
        registerPage.clickToSubmitButton("btnLogin");
        userIDInfo = registerPage.getUserIDInfo();
        passwordInfo = registerPage.getPasswordInfo();
    }

    @Test (enabled = false)
    public void TC02_LoginIntoSystem() {
        loginPage = registerPage.openLoginURL(loginPageURL);
        Assert.assertTrue(loginPage.isLoginFromDisplay("btnLogin"));
        loginPage.inputToUserIDTextbox(userIDInfo,"uid");
        loginPage.inputToPasswordTextbox(passwordInfo,"password");
        homePage = loginPage.clickToLoginButton("btnLogin");
        Assert.assertTrue(homePage.isWelcomeMessageDisplay());
        Assert.assertTrue(homePage.isUserIDDisplay(userIDInfo));
        homePage.clickToLogoutTextArea();
        homePage.waitForSuccessAlertPresence();
        loginPage = homePage.acceptLogoutSuccessAlert();
        Assert.assertTrue(loginPage.isLoginFromDisplay("btnLogin"));
    }

//    @AfterClass
//    public void afterClass() {
//        driver.quit();
//    }

    public int randomNumber() {
        Random rand  = new Random();
        return rand.nextInt(999999);
    }

}
