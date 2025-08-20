package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedInPage {
    private WebDriver driver;
    private By loggedInAs = By.xpath("//a[contains(text(),'Logged in as')]");
    private By deleteAccountButton = By.xpath("//a[contains(text(),'Delete Account')]");
    private By logoutButton = By.xpath("//a[contains(text(),'Logout')]");

    public LoggedInPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoggedInAsVisible() {
        return driver.findElement(loggedInAs).isDisplayed();
    }

    public void clickDeleteAccount() {
        driver.findElement(deleteAccountButton).click();
    }

    public void clickLogout(){
        driver.findElement(logoutButton).click();
    }
}
