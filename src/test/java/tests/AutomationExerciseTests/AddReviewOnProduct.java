package tests.AutomationExerciseTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AutomationExercisePages.DashboardPage;
import pages.AutomationExercisePages.ProductsPage;
import utilities.BaseClass;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;

public class AddReviewOnProduct extends BaseClass{
    DashboardPage dashboardPage = new DashboardPage();
    ProductsPage productsPage = new ProductsPage();

    @BeforeMethod
    public void setUpMethod(){
        driver.get(ConfigurationReader.getProperty("automationexercise.url"));
        BrowserUtils.pageVerification("Automation Exercise",driver.getTitle());
    }
    @Test
    public void addReviewOnProduct(){
        dashboardPage.clickOnProductsButton();
        BrowserUtils.pageVerification("Automation Exercise - All Products",driver.getTitle());
        productsPage.clickOnViewProduct1();
        Assert.assertTrue(productsPage.isWriteYourReviewVisible());
        productsPage.enterNameEmailAndReview();
        productsPage.clickSubmitButton();
        Assert.assertTrue(productsPage.verifySuccessMessage());

    }
}
