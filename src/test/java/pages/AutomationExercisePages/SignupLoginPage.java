package pages.AutomationExercisePages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BasePage;

public class SignupLoginPage extends BasePage {

    @FindBy(xpath = "//*[text()='Login to your account']")
    private WebElement loginToYourAccount;
    @FindBy(xpath = "//*[text()='New User Signup!']")
    private WebElement newUserSignUp;
    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement emailAddress;
    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement password;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement clickLoginbtn;
    @FindBy(xpath = "//*[text()='Your email or password is incorrect!']")
    private WebElement incorrectEmailOrPasswordMessage;
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement signUpName;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement signUpEmail;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signUpButton;
    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    private WebElement emailAddressAlreadyExist;




    public boolean isLoginToYourAccountVisible(){
        return loginToYourAccount.isDisplayed();
    }
    public boolean isNewUserSignUpVisible(){
        return newUserSignUp.isDisplayed();
    }
    public void enterIncorrectEmailAddressAndPassword(){
        emailAddress.sendKeys(faker.internet().emailAddress());
        password.sendKeys(faker.internet().password());
    }

    String email = "testeer@test.com";
    String pass = "123456";
    public void enterCorrectEmailAddressAndPassword(){
        emailAddress.sendKeys(email);
        password.sendKeys(pass);

    }
    public void clickLoginButton(){

        clickLoginbtn.click();
    }
    public boolean isYourEmailOrPasswordIsIncorrectMessageVisible(){
       return incorrectEmailOrPasswordMessage.isDisplayed();
    }
    public void existingUserSignUp(){
        signUpName.sendKeys("Tester");
        signUpEmail.sendKeys(email);
    }
    public void newUserSignUp(){
        signUpName.sendKeys(faker.name().name());
        signUpEmail.sendKeys(faker.internet().safeEmailAddress());
    }
    public void clickSignUpButton(){

        signUpButton.click();
    }
    public boolean isEmailAddressAlreadyExistMessageVisible(){

        return emailAddressAlreadyExist.isDisplayed();
    }

}
