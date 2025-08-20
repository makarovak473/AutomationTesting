package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountInformationPage {

    private WebDriver driver;
    private By accountInfoText = By.xpath("//b[contains(text(),'Enter Account Information')]");
    private By titleMrRadio = By.id("id_gender1");
    private By titleMrsRadio = By.id("id_gender2");
    private By passInput = By.id("password");
    private By daySelect = By.id("days");
    private By monthSelect = By.id("months");
    private By yearSelect = By.id("years");
    private By newsletterCheckBox = By.id("newsletter");
    private By offersCheckbox = By.id("optin");

    private By firstNameInput = By.id("first_name");
    private By lastNameInput = By.id("last_name");
    private By companyInput = By.id("company");
    private By address1Input = By.id("address1");
    private By address2Input = By.id("address2");
    private By countrySelect = By.id("country");
    private By stateInput = By.id("state");
    private By cityInput = By.id("city");
    private By zipcodeInput = By.id("zipcode");
    private By mobileNumberInput = By.id("mobile_number");

    private By createAccountButton = By.xpath("//button[contains(text(),'Create Account')]");

    public AccountInformationPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isAccountInfoVisible(){
        return driver.findElement(accountInfoText).isDisplayed();
    }

    public void selectTitle(String title){
        if(title.equalsIgnoreCase("Mr")){
            driver.findElement(titleMrRadio).click();
        }else{
            driver.findElement(titleMrsRadio).click();
        }
    }

    public void enterPassword(String password){
        driver.findElement(passInput).sendKeys(password);
    }

    public void selectDOB(String day, String month, String year){
        new Select(driver.findElement(daySelect)).selectByValue(day);
        new Select(driver.findElement(monthSelect)).selectByValue(month);
        new Select(driver.findElement(yearSelect)).selectByValue(year);
    }

    public void checkNews(boolean value){
        if(driver.findElement(newsletterCheckBox).isSelected() != value){
            driver.findElement(newsletterCheckBox).click();
        }
    }

    public void checkOffers(boolean value){
        if(driver.findElement(offersCheckbox).isSelected() != value){
            driver.findElement(offersCheckbox).click();
        }
    }

    public void enterFirstName(String firstName){
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void enterCompany(String company){
        driver.findElement(companyInput).sendKeys(company);
    }

    public void enterAddress1(String address1){
        driver.findElement(address1Input).sendKeys(address1);
    }

    public void enterAddress2(String address2){
        driver.findElement(address2Input).sendKeys(address2);
    }

    public void selectCountry(String country){
        new Select(driver.findElement(countrySelect)).selectByVisibleText(country);
    }

    public void enterState(String state){
        driver.findElement(stateInput).sendKeys(state);
    }

    public void enterCity(String city){
        driver.findElement(cityInput).sendKeys(city);
    }

    public void enterZipCode(String zipCode){
        driver.findElement(zipcodeInput).sendKeys(zipCode);
    }

    public void enterMobileNumber(String mobileNumber){
        driver.findElement(mobileNumberInput).sendKeys(mobileNumber);
    }

    public void clickCreateAccount(){
        driver.findElement(createAccountButton).click();
    }




}
