package tests.UserManagement;

import io.qameta.allure.*;
import models.Credentials;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupLoginPage;
import tests.BaseTest;
import utils.JsonDataReader;

import static org.testng.Assert.assertTrue;
@Epic("User Management")
@Feature("Login")
public class LoginWithWrongCredentialsTest extends BaseTest {

    @Test(description = "Login with wrong credentials", groups = {"user-management"})
    @Severity(SeverityLevel.NORMAL)
    @Story("User should not be able to login with wrong credentials")
    @Description("This test verifies that trying to login with wrong credentials shows the appropriate error message.")
    public void loginWithWrongCredentials() throws Exception {

        Credentials creds = JsonDataReader.readJson("src/test/resources/credentials.json", Credentials.class);

        HomePage home = new HomePage(driver);
        home.acceptConsentIfPresent();

        Allure.step("Verify homepage is visible");
        assertTrue(home.isHomePageVisible(), "Homepage is not visible!");

        Allure.step("Navigate to Signup/Login page");
        home.clickSignupLogin();

        SignupLoginPage login = new SignupLoginPage(driver);

        Allure.step("Verify 'Login to your account' is visible");
        assertTrue(login.isLogintoYourAccountVisible(), "Message is not visible!");

        Allure.step("Enter wrong credentials");
        login.enterLoginEmail(creds.getWrongEmail());
        login.enterLoginPassword(creds.getWrongPassword());

        Allure.step("Click 'Login' button");
        login.clickLogin();

        Allure.step("Verify error message for wrong credentials is displayed!");
        assertTrue(login.errorMessage(), "Error Message is not visible!");
    }
}
