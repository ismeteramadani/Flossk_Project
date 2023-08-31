package tests.AutomationExerciseTests;

import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AutomationExercisePages.*;
import utilities.BaseClass;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;

public class PlaceOrderLoginBeforeCheckout extends BaseClass {

    DashboardPage dashboardPage = new DashboardPage();
    SignupLoginPage signupLoginPage = new SignupLoginPage();
    LoggedHomePage loggedHomePage = new LoggedHomePage();
    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    PaymentPage paymentPage = new PaymentPage();
    AccountDeleted accountDeleted = new AccountDeleted();

    @BeforeMethod
    public void setUpMethod(){
        driver.get(ConfigurationReader.getProperty("automationexercise.url"));
        BrowserUtils.pageVerification("Automation Exercise",driver.getTitle());
    }

    @Test
    public void placeOrderLoginBeforeCheckout(){
        dashboardPage.clickOnSignupLoginButton();
        signupLoginPage.enterCorrectEmailAddressAndPassword();
        signupLoginPage.clickLoginButton();
        loggedHomePage.isLoggedInAsUsernameVisible();
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
