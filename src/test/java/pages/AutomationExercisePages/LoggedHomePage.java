package pages.AutomationExercisePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BasePage;

public class LoggedHomePage extends BasePage{

    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b")
    private WebElement loggedInAsUsername;
    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logOutbutton;

    public boolean isLoggedInAsUsernameVisible(){

        return loggedInAsUsername.isDisplayed();
    }
    public void clickLogOutButton(){

        logOutbutton.click();
    }
}
