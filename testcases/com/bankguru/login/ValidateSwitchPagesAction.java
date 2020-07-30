package com.bankguru.login;

import commons.GlobalConstants;
import commons.PageGeneratorManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;

import java.util.concurrent.TimeUnit;

public class ValidateSwitchPagesAction {
    WebDriver driver;
    LoginPageObject loginPage;
    HomePageObject homePage;
    NewCustomerPageObject newCustomerPage;
    NewAccountPageObject newAccountPage;
    WithdrawalPageObject withdrawalPage;
    DepositPageObject depositPage;


    @BeforeClass
    public void beforeClass() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginPage = PageGeneratorManager.getLoginPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(GlobalConstants.SITE_URL);
    }

    @Test (enabled = true)
    public void switchPagesAction() {
        loginPage.inputToUserIDTextbox(GlobalConstants.USER_LOGIN,"uid");
        loginPage.inputToPasswordTextbox(GlobalConstants.PASSWORD_LOGIN,"password");
        homePage = loginPage.clickToLoginButton("btnLogin");
        Assert.assertTrue(homePage.isWelcomeMessageDisplay());
        Assert.assertTrue(homePage.isUserIDDisplay(GlobalConstants.USER_LOGIN));
        newCustomerPage = homePage.clickToNewCustomerTextArea();
        Assert.assertTrue(newCustomerPage.isNewCustomerHeaderDisplay());
        newAccountPage = newCustomerPage.clickToNewAccountTextArea();
        Assert.assertTrue(newAccountPage.isNewAccountHeaderPageDisplay());
        withdrawalPage = newAccountPage.clickToWithdrawalTextArea();
        Assert.assertTrue(withdrawalPage.isWithdrawalHeaderPageDisplay());
        depositPage = withdrawalPage.clickToDepositTextArea();
        Assert.assertTrue(depositPage.isDepositHeaderPageDisplay());
        newCustomerPage = depositPage.clickToNewCustomerTextArea();
        newCustomerPage.isNewCustomerHeaderDisplay();
    }

    @Test
    public void switchByHandleDynamicPage() {
        loginPage.inputToUserIDTextbox(GlobalConstants.USER_LOGIN,"uid");
        loginPage.inputToPasswordTextbox(GlobalConstants.PASSWORD_LOGIN,"password");
        homePage = loginPage.clickToLoginButton("btnLogin");
        Assert.assertTrue(homePage.isWelcomeMessageDisplay());
        Assert.assertTrue(homePage.isUserIDDisplay(GlobalConstants.USER_LOGIN));

        newCustomerPage = (NewCustomerPageObject) homePage.clickToDynamicPageMenu(driver, "New Customer");
        Assert.assertTrue(newCustomerPage.isNewCustomerHeaderDisplay());

        newAccountPage = (NewAccountPageObject) newCustomerPage.clickToDynamicPageMenu(driver, "New Account");
        Assert.assertTrue(newAccountPage.isNewAccountHeaderPageDisplay());

        withdrawalPage = (WithdrawalPageObject) newAccountPage.clickToDynamicPageMenu(driver, "Withdrawal");
        Assert.assertTrue(withdrawalPage.isWithdrawalHeaderPageDisplay());

        depositPage = (DepositPageObject) withdrawalPage.clickToDynamicPageMenu(driver, "Deposit");
        Assert.assertTrue(depositPage.isDepositHeaderPageDisplay());

        newCustomerPage = (NewCustomerPageObject) depositPage.clickToDynamicPageMenu(driver, "New Customer");
        Assert.assertTrue(newCustomerPage.isNewCustomerHeaderDisplay());

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
