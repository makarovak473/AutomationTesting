package tests.ProductManagement;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.AllProductsPage;
import pages.HomePage;
import pages.SearchProductPage;
import tests.BaseTest;
import static org.testng.Assert.assertTrue;

@Epic("Product Management")
@Feature("Search Product")
public class SearchProductTest extends BaseTest {

    @Test(description = "Search a product")
    @Severity(SeverityLevel.NORMAL)
    @Story("User should be able to search a prodcut")
    @Description("This test verify that you can search for a product and check if the product you searched is the correct one")
    public void searchProductTest(){
        HomePage home = new HomePage(driver);
        home.acceptConsentIfPresent();

        Allure.step("Click on 'Products' Button");
        home.clickProducts();

        AllProductsPage products = new AllProductsPage(driver);

        Allure.step("Verify product list is visible");
        products.isProductListVisble();

        Allure.step("Search for a product");
        products.searchProduct();
        products.submitSearch();

        SearchProductPage searched = new SearchProductPage(driver);

        Allure.step("Verify 'Searched Products' is visible");
        searched.isSearchedProductsVisble();

        Allure.step("Verify that the product you search is the one displayed");
        assertTrue(searched.productName().contains(searched.getSearchBarValue()));
    }
}
