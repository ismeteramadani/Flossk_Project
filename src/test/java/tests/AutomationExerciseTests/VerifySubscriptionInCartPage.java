package tests.AutomationExerciseTests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AutomationExercisePages.CartPage;
import pages.AutomationExercisePages.DashboardPage;
import utilities.BaseClass;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;

public class VerifySubscriptionInCartPage extends BaseClass{
    private DashboardPage dashboardPage = new DashboardPage();
    private CartPage cartPage = new CartPage();

    @BeforeMethod
    public void setUpMethod(){
        driver.get(ConfigurationReader.getProperty("automationexercise.url"));
        BrowserUtils.pageVerification("Automation Exercise",driver.getTitle());
    }
    @Test
    public void verifySubscriptionInCartPage(){
        dashboardPage.clickOnCartButton();
        cartPage.scrollDownToFooter();
        cartPage.isSubscriptionVisible();
        cartPage.enterEmailAndclickArrowButton();
        cartPage.alertMessage();
    }
}
