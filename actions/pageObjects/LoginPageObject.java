package pageObjects;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUI.LoginPageUI;

public class LoginPageObject extends AbstractPage {
    WebDriver driver;

    public LoginPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public boolean isLoginFromDisplay(String dynamicValue) {
        return isElementDisplay(driver, LoginPageUI.DYNAMIC_LOCATOR, dynamicValue);
    }

    public String getLoginPageURL() {
        return getCurrentUrl(driver);
    }

    public RegisterPageObject clickToHereLink() {
        waitForElementVisible(driver,LoginPageUI.HERE_LINK);
        clickToElement(driver, LoginPageUI.HERE_LINK);
        return PageGeneratorManager.getRegisterPage(driver);
    }

    public HomePageObject clickToLoginButton(String dynamicValue) {
        waitForElementVisible(driver,LoginPageUI.DYNAMIC_LOCATOR, dynamicValue);
        clickToElement(driver,LoginPageUI.DYNAMIC_LOCATOR, dynamicValue);
        return PageGeneratorManager.getHomePage(driver);
    }

    public void inputToUserIDTextbox(String userID, String dynamicValue) {
        sendTextToElement(driver, LoginPageUI.DYNAMIC_LOCATOR, userID, dynamicValue);
    }

    public void inputToPasswordTextbox(String password, String dynamicValue) {
        sendTextToElement(driver, LoginPageUI.DYNAMIC_LOCATOR, password, dynamicValue);
    }

    public void isLogoutSuccessAlertDisplay() {
        acceptAlert(driver);
    }
}
