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
@Feature("Register")
public class RegisterUserWithExistingEmailTest extends BaseTest {

    @Test(description = "Register with an already existing email", groups = {"user-management"})
    @Severity(SeverityLevel.NORMAL)
    @Story("User should not be able to register with an email that already exist")
    @Description("This test verifies that trying to register with an existing email shows the appropriate error message.")
    public void registerWithExistingEmail(){
        Credentials creds = JsonDataReader.readJson("src/test/resources/credentials.json", Credentials.class);

        HomePage homePage=new HomePage(driver);
        homePage.acceptConsentIfPresent();

        Allure.step("Verify homepage is visible");
        assertTrue(homePage.isHomePageVisible(),"Homepage is not visible!");

        Allure.step("Navigate to Signup/Login page");
        homePage.clickSignupLogin();

        SignupLoginPage signup = new SignupLoginPage(driver);

        Allure.step("Verify 'New User Signup!' is visible");
        assertTrue(signup.isNewUserSignupVisible(),"Message is not visible!");

        Allure.step("Enter name and existing email");
        signup.enterName("Radu");
        signup.enterEmail(creds.getEmail());

        Allure.step("Click 'Signup' button");
        signup.clickSignup();

        Allure.step("Verify error message for already used email is displayed");
        signup.alreadyUsed();


    }
}
