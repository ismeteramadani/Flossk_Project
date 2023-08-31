package pages.AutomationExercisePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.BasePage;

public class AccountDeleted extends BasePage {

    @FindBy(css = "h2[data-qa='account-deleted']")
    private WebElement accountDeleted;
    @FindBy(css = "a[data-qa='continue-button']")
    private WebElement continueButton;

    public void verifyAccountDeletedAndClickContinueButton(){
        Assert.assertEquals("ACCOUNT DELETED!",accountDeleted.getText());
        continueButton.click();
    }
}
