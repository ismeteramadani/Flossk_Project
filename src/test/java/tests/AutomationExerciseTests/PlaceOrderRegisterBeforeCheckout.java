package tests.AutomationExerciseTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AutomationExercisePages.*;
import utilities.BaseClass;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;

public class PlaceOrderRegisterBeforeCheckout extends BaseClass{

    private DashboardPage dashboardPage = new DashboardPage();
    private SignupLoginPage signupLoginPage = new SignupLoginPage();
    private CreateAccountPage createAccountPage = new CreateAccountPage();
    private AccountCreatedPage accountCreatedPage =new AccountCreatedPage();
    private LoggedHomePage loggedHomePage = new LoggedHomePage();
    private ProductsPage productsPage = new ProductsPage();
    private CartPage cartPage = new CartPage();
    private CheckoutPage checkoutPage = new CheckoutPage();
    private PaymentPage paymentPage = new PaymentPage();
    private AccountDeleted accountDeleted = new AccountDeleted();

    @BeforeMethod
    public void setUpMethod(){
        driver.get(ConfigurationReader.getProperty("automationexercise.url"));
        BrowserUtils.pageVerification("Automation Exercise",driver.getTitle());
    }
    @Test
    public void placeOrderRegisterBeforeCheckout(){
        dashboardPage.clickOnSignupLoginButton();
        signupLoginPage.newUserSignUp();
        signupLoginPage.clickSignUpButton();
        createAccountPage.createAccount();
        createAccountPage.clickOnCreateAccountButton();
        Assert.assertTrue(accountCreatedPage.isAccountCreated());
        accountCreatedPage.clickOnContinueButton();
        Assert.assertTrue(loggedHomePage.isLoggedInAsUsernameVisible());
        productsPage.hoverOverFirstProductAndClickAddToCart();
        productsPage.clicOnContinueShopingButton();
        productsPage.hoverOverSecondProductAndClickAddToCart();
        productsPage.clickOnViewCartButton();
        BrowserUtils.pageVerification("Automation Exercise - Checkout",driver.getTitle());
        cartPage.clickProceedToCheckout();
        checkoutPage.verifyAddressDetailsAndReviewYourOrder();
        checkoutPage.enterDescriptionInCommentTextAreaAndClickPlaceOrder();
        paymentPage.enterPaymentDetails();
        paymentPage.clickPayAndConfirmOrderButton();
        paymentPage.verifySuccessMessage();
        paymentPage.clickDeleteAccount();
        accountDeleted.verifyAccountDeletedAndClickContinueButton();

    }

}
