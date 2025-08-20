package tests.SubscriptionManagement;

import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

@Epic("Subscription Management")
@Feature("Subscribe From Homepage")
public class SubscriptionInHomepageTest extends BaseTest {

    @Test(description = "Subscribe from homepage")
    @Severity(SeverityLevel.MINOR)
    @Story("User should be able to subscribe from homepage")
    @Description("This test verify that you can subscribe from homepage and after that a specific message is displayed")
    public void subscribeFromHomepageTest(){

        HomePage homepage =new HomePage(driver);
        homepage.acceptConsentIfPresent();

        Allure.step("Scroll down to footer");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

        Allure.step("Verify 'Subscription' is visible");
        homepage.isSubscriptionVisible();

        Allure.step("Enter email and subscribe");
        homepage.subscribe();

        Allure.step("Verify the subscription alert is visible");
        homepage.isSubscriptionAlertVisible();
    }
}
