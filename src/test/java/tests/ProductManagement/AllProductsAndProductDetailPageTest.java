package tests.ProductManagement;

import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.AllProductsPage;
import pages.HomePage;
import pages.ProductPage;
import tests.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
@Epic("Product Management")
@Feature("View Product")
public class AllProductsAndProductDetailPageTest extends BaseTest {

    @Test(description = "Navigate to all products then click on the first product")
    @Severity(SeverityLevel.MINOR)
    @Story("User should be able to click on products and then select the first product and see all the details")
    @Description("this test verify that the product details are visible on the product page")
    public void productDetailsTest(){
        HomePage home = new HomePage(driver);
        home.acceptConsentIfPresent();

        Allure.step("Verify homepage is visble");
        assertTrue(home.isHomePageVisible());

        Allure.step("Click 'Products' button");
        home.clickProducts();

        AllProductsPage products = new AllProductsPage(driver);

        Allure.step("Verify product list is visible");
        assertTrue(products.isProductListVisble());

        Allure.step("Scroll down to find the viewProduct button");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

        Allure.step("Click 'View Product' button");
        products.clickViewProduct();

        ProductPage product = new ProductPage(driver);

        Allure.step("Verify page title");
        assertEquals(product.produtPageTitle(), "Automation Exercise - Product Details");

        Allure.step("Verify product details");
        assertTrue(product.isProductNameVisible());
        assertTrue(product.isCategoryVisible());
        assertTrue(product.isAvailabilityVisible());
        assertTrue(product.isConditionVisible());
        assertTrue(product.isBrandVisible());
    }
}
