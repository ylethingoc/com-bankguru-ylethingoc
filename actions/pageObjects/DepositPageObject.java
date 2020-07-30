package pageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.DepositPageUI;

public class DepositPageObject extends AbstractPage {
    WebDriver driver;

    public DepositPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public boolean isDepositHeaderPageDisplay() {
        return isElementDisplay(driver, DepositPageUI.DEPOSIT_PAGE_HEADER);
    }

    public NewCustomerPageObject clickToNewCustomerTextArea() {
        return openNewCustomerPage(driver);
    }
}
