package pageObjects;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageUI.HomePageUI;

public class HomePageObject extends AbstractPage {
    WebDriver driver;

    public HomePageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public boolean isWelcomeMessageDisplay() {
        return isElementDisplay(driver, HomePageUI.WELCOME_MESSAGE);
    }

    public boolean isUserIDDisplay(String userID) {
        Assert.assertTrue(getElementText(driver, HomePageUI.USERID_TEXTAREA).contains(userID));
        return true;
    }

    public void clickToLogoutTextArea() {
        waitForElementVisible(driver, HomePageUI.LOGOUT_TEXTAREA);
        clickToElement(driver,HomePageUI.LOGOUT_TEXTAREA);
    }

    public void waitForSuccessAlertPresence() {
        waitAlertPresence(driver);
    }

    public LoginPageObject acceptLogoutSuccessAlert() {
        acceptAlert(driver);
        return PageGeneratorManager.getLoginPage(driver);
    }

    public NewCustomerPageObject clickToNewCustomerTextArea() {
        return openNewCustomerPage(driver);
    }
}
