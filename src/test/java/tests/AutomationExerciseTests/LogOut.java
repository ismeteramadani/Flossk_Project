package tests.AutomationExerciseTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AutomationExercisePages.DashboardPage;
import pages.AutomationExercisePages.LoggedHomePage;
import pages.AutomationExercisePages.SignupLoginPage;
import utilities.BaseClass;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;

public class LogOut extends BaseClass {
    private SignupLoginPage signupLoginPage = new SignupLoginPage();
    private DashboardPage dashboardPage = new DashboardPage();
    private LoggedHomePage loggedHomePage = new LoggedHomePage();

    @BeforeMethod
    public void setUpMethod(){
        driver.get(ConfigurationReader.getProperty("automationexercise.url"));
        BrowserUtils.pageVerification("Automation Exercise",driver.getTitle());
    }

    @Test
    public void logOutUser(){
        dashboardPage.clickOnSignupLoginButton();
        Assert.assertTrue(signupLoginPage.isLoginToYourAccountVisible());
        signupLoginPage.enterCorrectEmailAddressAndPassword();
        signupLoginPage.clickLoginButton();
        Assert.assertTrue(loggedHomePage.isLoggedInAsUsernameVisible());
        loggedHomePage.clickLogOutButton();
        BrowserUtils.pageVerification("Automation Exercise - Signup / Login",driver.getTitle());

    }
}
