package tests.AutomationExerciseTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AutomationExercisePages.CartPage;
import pages.AutomationExercisePages.DashboardPage;
import pages.AutomationExercisePages.ProductsPage;
import utilities.BaseClass;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;

public class AddProductInCart extends BaseClass {

    private DashboardPage dashboardPage = new DashboardPage();
    private ProductsPage productsPage = new ProductsPage();
    private CartPage cartPage = new CartPage();

    @BeforeMethod
    public void setUpMethod(){
        driver.get(ConfigurationReader.getProperty("automationexercise.url"));
        BrowserUtils.pageVerification("Automation Exercise",driver.getTitle());
        dashboardPage.clickOnProductsButton();
    }

    @Test
    public void addProductsInCart(){

        productsPage.hoverOverFirstProductAndClickAddToCart();
        productsPage.clicOnContinueShopingButton();
        productsPage.hoverOverSecondProductAndClickAddToCart();
        productsPage.clickOnViewCartButton();
        productsPage.productsAddedToCart();
        cartPage.verifyTheirPricesQuantityAndTotalPrice();
    }


}
