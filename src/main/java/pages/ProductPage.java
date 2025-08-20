package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;
    private By productName = By.xpath("//h2[contains(text(), 'Blue Top')]");
    private By category = By.xpath("//p[contains(text(), 'Category:')]");
    private By availability = By.xpath("//p[b[contains(text(), 'Availability:')]]");
    private By condition =  By.xpath("//p[b[contains(text(), 'Condition:')]]");
    private By brand =  By.xpath("//p[b[contains(text(), 'Brand:')]]");

    public ProductPage(WebDriver driver){
        this.driver=driver;
    }
    public String produtPageTitle(){
        return driver.getTitle();
    }

    public boolean isProductNameVisible(){
        return driver.findElement(productName).isDisplayed();
    }

    public boolean isCategoryVisible(){
        return driver.findElement(category).isDisplayed();
    }

    public boolean isAvailabilityVisible(){
        return driver.findElement(availability).isDisplayed();
    }
    public boolean isConditionVisible(){
        return driver.findElement(condition).isDisplayed();
    }
    public boolean isBrandVisible(){
        return driver.findElement(brand).isDisplayed();
    }
}
