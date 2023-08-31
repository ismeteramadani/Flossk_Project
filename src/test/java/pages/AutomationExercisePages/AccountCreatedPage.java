package pages.AutomationExercisePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.BasePage;
import utilities.BrowserUtils;

public class AccountCreatedPage extends BasePage {

    @FindBy(css = "h2[data-qa='account-created']")
    private WebElement accountCreated;
    @FindBy(css = "a[data-qa='continue-button']")
    private WebElement continueButton;

    public boolean isAccountCreated(){

        return accountCreated.isDisplayed();
    }
    public void clickOnContinueButton(){
        BrowserUtils.moveToElement(continueButton);
        continueButton.click();
    }

}
