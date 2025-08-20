package tests.UserManagement;
import io.qameta.allure.*;
import models.AccountDetails;
import org.testng.annotations.Test;
import pages.*;
import tests.BaseTest;
import utils.JsonDataReader;

import static org.testng.Assert.assertTrue;

@Epic("User Management")
@Feature("Register")
public class SignupAndDeleteTest extends BaseTest {

    @Test(description = "Complete register and delete account", groups = {"user-management"})
    @Severity(SeverityLevel.NORMAL)
    @Story("User should be able to register and delete his account")
    @Description("This test verify that the user can register and delete his account after complete registration")
    public void testSignupAndDeleteAccount(){

        AccountDetails details = JsonDataReader.readJson("src/test/resources/accountDetails.json", AccountDetails.class);

        HomePage home = new HomePage(driver);
        home.acceptConsentIfPresent();

        Allure.step("Verify homepage is visible");
        assertTrue(home.isHomePageVisible(), "Homepage is not visible!");

        Allure.step("Navigate to Signup/Login page");
        home.clickSignupLogin();

        SignupLoginPage signupLogin = new SignupLoginPage(driver);

        Allure.step("Verify 'New User Signup!' is visible");
        assertTrue(signupLogin.isNewUserSignupVisible(), "Message is not visible!");

        Allure.step("Enter name and email");
        signupLogin.enterName(details.getName());
        signupLogin.enterEmail(details.getEmail());

        Allure.step("Click 'Signup' button");
        signupLogin.clickSignup();

        AccountInformationPage accountInformation = new AccountInformationPage(driver);

        Allure.step("Verify 'Enter Account Information' is visible");
        assertTrue(accountInformation.isAccountInfoVisible(),"ENTER ACCOUNT INFORMATION not visible");

        Allure.step("Enter account information");
        accountInformation.selectTitle(details.getTitle());
        accountInformation.enterPassword(details.getPassword());
        accountInformation.selectDOB(details.getDay(), details.getMonth(), details.getYear());
        accountInformation.checkNews(details.isNews());
        accountInformation.checkOffers(details.isOffer());
        accountInformation.enterFirstName(details.getFirstName());
        accountInformation.enterLastName(details.getLastName());
        accountInformation.enterCompany(details.getCompany());
        accountInformation.enterAddress1(details.getAddress1());
        accountInformation.enterAddress2(details.getAddress2());
        accountInformation.selectCountry(details.getCountry());
        accountInformation.enterState(details.getState());
        accountInformation.enterCity(details.getCity());
        accountInformation.enterZipCode(details.getZipCode());
        accountInformation.enterMobileNumber(details.getMobileNumber());

        Allure.step("Click 'Create Account' button");
        accountInformation.clickCreateAccount();

        AccountCreatedPage accountCreated = new AccountCreatedPage(driver);

        Allure.step("Verify 'Account Created!' is visible");
        assertTrue(accountCreated.isAccountCreatedVisible(), "Account Created! is not visible!");

        Allure.step("Click 'Continue' button");
        accountCreated.clickContinue();

        LoggedInPage loggedIn = new LoggedInPage(driver);

        Allure.step("Verify 'Logged is as username' is visible");
        assertTrue(loggedIn.isLoggedInAsVisible(), "Logged in as username not visible");

        Allure.step("Click 'Delete Account' button");
        loggedIn.clickDeleteAccount();


        AccountDeletedPage accountDeteled = new AccountDeletedPage(driver);

        Allure.step("Verify 'Account Deleted!' is visible");
        assertTrue(accountDeteled.isAccountDeletedVisible(), "ACCOUNT DELETED!' not visible");

        Allure.step("Click 'Continue' button");
        accountDeteled.clickContinue();

    }
}
