package pageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.NewCustomerPageUI;

public class NewCustomerPageObject extends AbstractPage {
    WebDriver driver;

    public NewCustomerPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public NewAccountPageObject clickToNewAccountTextArea() {
        return openNewAccountPage(driver);
    }

    public boolean isNewCustomerHeaderDisplay() {
        return isElementDisplay(driver, NewCustomerPageUI.NEW_CUSTOMER_PAGE_HEADER);
    }
}
