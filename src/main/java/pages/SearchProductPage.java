package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchProductPage {

    private WebDriver driver;
    private By searchBar = By.id("search_product");
    private By prodcutName = By.className("productinfo");
    private By searchedProducts = By.cssSelector(".title.text-center");

    public SearchProductPage(WebDriver driver){
        this.driver=driver;
    }

    public String getSearchBarValue(){
        return driver.findElement(searchBar).getAttribute("value");
    }

    public String productName(){
        return driver.findElement(prodcutName).getText();
    }

    public boolean isSearchedProductsVisble(){
        return driver.findElement(searchedProducts).isDisplayed();
    }


}
