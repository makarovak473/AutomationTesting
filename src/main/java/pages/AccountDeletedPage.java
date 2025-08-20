package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDeletedPage {
    private WebDriver driver;

    private By accountDeletedText = By.xpath("//h2[@data-qa='account-deleted']");
    private By continueButton = By.xpath("//a[@data-qa='continue-button']");

    public AccountDeletedPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAccountDeletedVisible() {
        return driver.findElement(accountDeletedText).isDisplayed();
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }
}
