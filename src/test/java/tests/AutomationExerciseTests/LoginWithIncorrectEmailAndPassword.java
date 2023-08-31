package tests.AutomationExerciseTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AutomationExercisePages.DashboardPage;
import pages.AutomationExercisePages.SignupLoginPage;
import utilities.BaseClass;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;

public class LoginWithIncorrectEmailAndPassword extends BaseClass {

    private SignupLoginPage signupLoginPage = new SignupLoginPage();
    private DashboardPage dashboardPage = new DashboardPage();

    @BeforeMethod
    public void setUpMethod(){
        driver.get(ConfigurationReader.getProperty("automationexercise.url"));
        BrowserUtils.pageVerification("Automation Exercise",driver.getTitle());
    }
    @Test
    public void loginUserWithIncorrectEmailAndPassword(){
        dashboardPage.clickOnSignupLoginButton();
        Assert.assertTrue(signupLoginPage.isLoginToYourAccountVisible());
        signupLoginPage.enterIncorrectEmailAddressAndPassword();
        signupLoginPage.clickLoginButton();
        Assert.assertTrue(signupLoginPage.isYourEmailOrPasswordIsIncorrectMessageVisible());
    }
}
