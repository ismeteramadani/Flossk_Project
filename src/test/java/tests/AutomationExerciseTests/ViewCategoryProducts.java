package tests.AutomationExerciseTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AutomationExercisePages.CategoryPage;
import pages.AutomationExercisePages.DashboardPage;
import utilities.BaseClass;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.WaitUtils;

public class ViewCategoryProducts extends BaseClass{

    DashboardPage dashboardPage = new DashboardPage();
    CategoryPage categoryPage = new CategoryPage();


    @BeforeMethod
    public void setUpMethod(){
        driver.get(ConfigurationReader.getProperty("automationexercise.url"));
        BrowserUtils.pageVerification("Automation Exercise",driver.getTitle());
    }
    @Test
    public void viewCategoryProducts(){
       Assert.assertTrue(dashboardPage.categoriesAreVisible());
       dashboardPage.clickWomenCategory();
       dashboardPage.clickTopsCategory();
       BrowserUtils.pageVerification("Automation Exercise - Tops Products",driver.getTitle());
       Assert.assertEquals("WOMEN - TOPS PRODUCTS",categoryPage.confirmText());
       categoryPage.clickMenCategory();
       categoryPage.clickOnTShirtsMen();
       BrowserUtils.pageVerification("Automation Exercise - Tshirts Products",driver.getTitle());

    }
}
