package pageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.NewAccountPageUI;

public class NewAccountPageObject extends AbstractPage {
    WebDriver driver;

    public NewAccountPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public boolean isNewAccountHeaderPageDisplay() {
        return isElementDisplay(driver, NewAccountPageUI.NEW_ACCOUNT_PAGE_HEADER);
    }

    public WithdrawalPageObject clickToWithdrawalTextArea() {
        return openWithdrawalPage(driver);
    }
}
