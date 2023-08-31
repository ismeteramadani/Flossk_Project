package pages.AutomationExercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.BasePage;
import utilities.BrowserUtils;
import utilities.WaitUtils;

public class PaymentPage extends BasePage {

    @FindBy(css = "input[data-qa='name-on-card']")
    private WebElement nameOnCard;
    @FindBy(css = "input[data-qa='card-number']")
    private WebElement cardNumber;
    @FindBy(css = "input[data-qa='cvc']")
    private WebElement cvcInput;
    @FindBy(css = "input[data-qa='expiry-month']")
    private WebElement expiryMonth;
    @FindBy(css = "input[data-qa='expiry-year']")
    private WebElement expiryYear;
    @FindBy(css = "button[data-qa='pay-button']")
    private WebElement payAndConfirmButton;
    @FindBy(xpath = "//*[@class='alert-success alert']")
    private WebElement alertSuccessAlert;
    @FindBy(css = "a[href='/delete_account']")
    private WebElement deleteAccount;

    public void enterPaymentDetails(){
        nameOnCard.sendKeys(faker.name().fullName());
        cardNumber.sendKeys(faker.number().digits(16));
        cvcInput.sendKeys(faker.number().digits(3));
        expiryMonth.sendKeys(faker.number().digits(2));
        expiryYear.sendKeys(faker.number().digits(4));
    }
    public void  clickPayAndConfirmOrderButton(){
        BrowserUtils.moveToElement(payAndConfirmButton);
        payAndConfirmButton.click();
    }
    public boolean verifySuccessMessage(){
        return alertSuccessAlert.isDisplayed();
        //WaitUtils.waitUntilElmIsDisplayed(By.xpath("//*[@class='alert-success alert']"));
        //Assert.assertEquals("Your order has been placed successfully!",alertSuccessAlert.getText());
    }
    public void clickDeleteAccount(){
        BrowserUtils.moveToElement(deleteAccount);
        deleteAccount.click();
    }
}
