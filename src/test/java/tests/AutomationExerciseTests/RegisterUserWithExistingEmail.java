package tests.AutomationExerciseTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AutomationExercisePages.DashboardPage;
import pages.AutomationExercisePages.SignupLoginPage;
import utilities.BaseClass;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;

public class RegisterUserWithExistingEmail extends BaseClass {
    private SignupLoginPage signupLoginPage = new SignupLoginPage();
    private DashboardPage dashboardPage = new DashboardPage();

    @BeforeMethod
    public void setUpMethod(){
        driver.get(ConfigurationReader.getProperty("automationexercise.url"));
        BrowserUtils.pageVerification("Automation Exercise",driver.getTitle());
    }

    @Test
    public void registerUserWithExistingEmail(){
        dashboardPage.clickOnSignupLoginButton();
        Assert.assertTrue(signupLoginPage.isNewUserSignUpVisible());
        signupLoginPage.existingUserSignUp();
        signupLoginPage.clickSignUpButton();
        Assert.assertTrue(signupLoginPage.isEmailAddressAlreadyExistMessageVisible());
    }
}
