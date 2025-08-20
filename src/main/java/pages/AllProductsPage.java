package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllProductsPage {
    private WebDriver driver;
    private By viewProductButton = By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[2]/ul/li/a");
    private By productList = By.className("features_items");
    private By searchBar = By.id("search_product");
    private By submitSearch = By.id("submit_search");

    public AllProductsPage(WebDriver driver){
        this.driver=driver;
    }

    public void clickViewProduct(){
        driver.findElement(viewProductButton).click();
    }
    public boolean isProductListVisble(){
        return driver.findElement(productList).isDisplayed();
    }
    public void searchProduct(){
        driver.findElement(searchBar).sendKeys("Winter Top");
    }
    public void submitSearch(){
        driver.findElement(submitSearch).click();
    }

}
