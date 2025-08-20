package tests.UserManagement;

import io.qameta.allure.*;
import models.Credentials;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoggedInPage;
import pages.SignupLoginPage;
import tests.BaseTest;
import utils.JsonDataReader;

import static org.testng.Assert.assertTrue;
@Epic("User Management")
@Feature("Login")
public class LoginWithCorrectEmailAndPasswordTest extends BaseTest {

    @Test(description = "Login with correct credentials", groups = {"user-management"})
    @Severity(SeverityLevel.NORMAL)
    @Story("User should be able to login with correct email and password")
    @Description("This test verify that after the user login with correct email and password, on the homepage is displayed 'Logged in as username'")
    public void loginWithCorrectCredentials(){
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

        Allure.step("Enter correct email and password");
        login.enterLoginEmail(creds.getEmail());
        login.enterLoginPassword(creds.getPassword());

        Allure.step("Click 'Login' button");
        login.clickLogin();

        LoggedInPage loggedIn = new LoggedInPage(driver);

        Allure.step("Verify 'Logged in as username' is displayed on the homepage");
        assertTrue(loggedIn.isLoggedInAsVisible(), "Logged in as username not visible");
    }
}
