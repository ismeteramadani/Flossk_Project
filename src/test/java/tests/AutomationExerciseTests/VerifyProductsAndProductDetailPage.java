package tests.AutomationExerciseTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AutomationExercisePages.DashboardPage;
import pages.AutomationExercisePages.ProductsPage;
import utilities.BaseClass;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.WaitUtils;

public class VerifyProductsAndProductDetailPage extends BaseClass {

    private DashboardPage dashboardPage = new DashboardPage();
    private ProductsPage productsPage = new ProductsPage();


    @BeforeMethod
    public void setUpMethod(){
        driver.get(ConfigurationReader.getProperty("automationexercise.url"));
        BrowserUtils.pageVerification("Automation Exercise",driver.getTitle());
    }
    @Test
    public void verifyAllProductsAndProductDetailPage(){
        dashboardPage.clickOnProductsButton();
        BrowserUtils.pageVerification("Automation Exercise - All Products",driver.getTitle());
        Assert.assertTrue(productsPage.isAllProductsListVisible());
        productsPage.clickOnViewProduct1();
        BrowserUtils.pageVerification("Automation Exercise - Product Details", driver.getTitle());
        productsPage.productDetails();

    }
}
