package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By signupLoginButton = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By homeSlider = By.id("slider");
    private By productsButton = By.xpath("//a[contains(text(),'Products')]");
    private By subscribeText = By.xpath("//h2[contains(text(), 'Subscription')]");
    private By emailSubscriptionInput = By.id("susbscribe_email");
    private By subscribeButton = By.id("subscribe");
    private By subscribeAlert = By.className("alert-success");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isHomePageVisible(){
        return driver.findElement(homeSlider).isDisplayed();
    }

    public void clickSignupLogin(){
        driver.findElement(signupLoginButton).click();
    }

    public void acceptConsentIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Așteaptă să apară dialogul GDPR
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("div.fc-consent-root")
            ));

            // Găsește butonul "Consent"
            WebElement consentBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button.fc-cta-consent")
            ));

            // Click pe el
            consentBtn.click();
            System.out.println("✅ Consent clicked");
        } catch (TimeoutException e) {
            System.out.println("ℹ No consent banner found, continuing...");
        }
    }

    public void clickProducts(){
        driver.findElement(productsButton).click();
    }
    public boolean isSubscriptionVisible(){
        return driver.findElement(subscribeText).isDisplayed();
    }
    public void subscribe(){
        driver.findElement(emailSubscriptionInput).sendKeys("ceva@test.com");
        driver.findElement(subscribeButton).click();
    }
    public boolean isSubscriptionAlertVisible(){
        return driver.findElement(subscribeAlert).isDisplayed();
    }


}
