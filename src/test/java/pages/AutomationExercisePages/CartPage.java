package pages.AutomationExercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.BasePage;
import utilities.BrowserUtils;
import utilities.WaitUtils;

import java.util.List;


public class CartPage extends BasePage {

    @FindBy(xpath = "//footer")
    private WebElement footer;
    @FindBy(xpath = "//*[text()='Subscription']")
    private WebElement subscription;
    @FindBy(xpath = "//*[@id='susbscribe_email']")
    private WebElement subscribeEmail;
    @FindBy(xpath = "//button[@id='subscribe']")
    private WebElement subscribeButton;
    @FindBy(xpath = "//div[contains(text(), 'You have been successfully subscribed!')]")
    private WebElement alertText;

    @FindBy(css = "a[class='btn btn-default check_out']")
    private WebElement checkOut;

    @FindBy(xpath = "//td[contains(@class, 'cart_description')]//a")
    private List<WebElement> productName;

    @FindBy(xpath = "//td[contains(@class, 'cart_price')]/p")
    private List<WebElement> price;

    @FindBy(xpath = "//td[contains(@class, 'cart_quantity')]/button")
    private List<WebElement> quantity;
    @FindBy(xpath = "//p[contains(@class, 'cart_total_price')]")
    private List<WebElement> totalPrice;


    public void scrollDownToFooter(){

        BrowserUtils.moveToElement(footer);
    }
    public boolean isSubscriptionVisible(){

        return subscription.isDisplayed();
    }
    public void enterEmailAndclickArrowButton(){
        subscribeEmail.sendKeys("filane@fisteku.com");
        subscribeButton.click();
    }
    public void alertMessage(){
        WaitUtils.waitUntilElmIsVisible(By.xpath("//div[contains(text(), 'You have been successfully subscribed!')]"));
        Assert.assertTrue(alertText.isDisplayed(),"You have been successfully subscribed!");
    }
    public void clickProceedToCheckout(){
        BrowserUtils.moveToElement(checkOut);
        checkOut.click();
    }
    public void verifyTheirPricesQuantityAndTotalPrice(){
        Assert.assertEquals(productName.size(),2);
        Assert.assertEquals(price.size(),2);
        Assert.assertEquals(quantity.size(),2);
        Assert.assertEquals(totalPrice.size(),2);

    }
}
