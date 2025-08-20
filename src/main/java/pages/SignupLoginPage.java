package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupLoginPage {
    private WebDriver driver;

    private By newUserSignupText = By.xpath("//h2[contains(text(), 'New User Signup!')]");
    private By existingUserLogIn = By.xpath("//h2[contains(text(), 'New User Signup!')]");
    private By nameInput = By.xpath("//input[@data-qa='signup-name']");
    private By emailInput = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");
    private By loginEmail = By.xpath("//input[@data-qa='login-email']");
    private By loginPassword = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");
    private By errorMessage = By.xpath("//p[contains(text(), 'Your email or password is incorrect!')]");
    private By alreadyUsedErrorMessage = By.xpath("//p[contains(text(), 'Email Address already exist!')]");



    public SignupLoginPage(WebDriver driver){
        this.driver=driver;
    }

    public boolean isNewUserSignupVisible(){
        return driver.findElement(newUserSignupText).isDisplayed();
    }

    public boolean isLogintoYourAccountVisible(){
        return driver.findElement(existingUserLogIn).isDisplayed();
    }

    public void enterName(String name){
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickSignup(){
        driver.findElement(signupButton).click();
    }

    public void enterLoginEmail(String email){
        driver.findElement(loginEmail).sendKeys(email);
    }

    public void enterLoginPassword(String password){
        driver.findElement(loginPassword).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public boolean errorMessage(){
        return driver.findElement(errorMessage).isDisplayed();
    }

    public boolean alreadyUsed(){
        return driver.findElement(alreadyUsedErrorMessage).isDisplayed();
    }

}
