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
@Feature("Logout")
public class LogoutUserTest extends BaseTest {

    @Test(description = "User can logout", groups = {"user-management"})
    @Severity(SeverityLevel.NORMAL)
    @Story("User should be able to logout from their account")
    public void logoutUserTest(){
        Credentials creds = JsonDataReader.readJson("src/test/resources/credentials.json", Credentials.class);

        HomePage homePage=new HomePage(driver);
        homePage.acceptConsentIfPresent();

        Allure.step("Verify homepage is visible");
        assertTrue(homePage.isHomePageVisible(),"Homepage is not visible!");

        Allure.step("Navigate to Signup/Login page");
        homePage.clickSignupLogin();

        SignupLoginPage login = new SignupLoginPage(driver);

        Allure.step("Verify 'Login to your account' is visible");
        assertTrue(login.isLogintoYourAccountVisible(),"Message is not visible!");

        Allure.step("Enter correct email and password");
        login.enterLoginEmail(creds.getEmail());
        login.enterLoginPassword(creds.getPassword());

        Allure.step("Click 'Login' button");
        login.clickLogin();

        LoggedInPage logged = new LoggedInPage(driver);

        Allure.step("Verify 'Logged in as username' is displayed on the homepage");
        assertTrue(logged.isLoggedInAsVisible(),"Message is not visible!");

        Allure.step("Click 'Logout' button");
        logged.clickLogout();

        Allure.step("Verify user is back on the login page");
        assertTrue(login.isLogintoYourAccountVisible(),"Message is not visible!");

    }
}
