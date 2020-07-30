package pageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.WithdrawalPageUI;

public class WithdrawalPageObject extends AbstractPage {
    WebDriver driver;

    public WithdrawalPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public boolean isWithdrawalHeaderPageDisplay() {
        return isElementDisplay(driver, WithdrawalPageUI.WITHDRAWAL_PAGE_HEADER);
    }
    
    public DepositPageObject clickToDepositTextArea() {
        return openDepositPage(driver);
    }
}
