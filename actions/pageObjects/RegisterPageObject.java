package pageObjects;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUI.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
    WebDriver driver;

    public RegisterPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }


    public boolean isRegisterPageDisplay(String dynamicValue) {
        return isElementDisplay(driver, RegisterPageUI.DYNAMIC_LOCATOR, dynamicValue);
    }

    public void inputToEmailTextbox(String email, String dynamicValue) {
        sendTextToElement(driver, RegisterPageUI.DYNAMIC_LOCATOR, email, dynamicValue);
    }

    public void clickToSubmitButton(String dynamicValue) {
        clickToElement(driver, RegisterPageUI.DYNAMIC_LOCATOR, dynamicValue);
    }

    public String getUserIDInfo() {
        return getElementText(driver, RegisterPageUI.USER_TEXTAREA);
    }

    public String getPasswordInfo() {
        return getElementText(driver, RegisterPageUI.PASSWORD_TEXTAREA);
    }

    public LoginPageObject openLoginURL(String loginURL) {
        openAnyUrl(driver, loginURL);
        return PageGeneratorManager.getLoginPage(driver);
    }

}
