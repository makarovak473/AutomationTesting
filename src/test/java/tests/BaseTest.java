package tests;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.DriverFactory;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = DriverFactory.getDriver();
        Allure.step("Open Automation Exercise website");
        driver.get("https://automationexercise.com");
    }

    @AfterClass
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
