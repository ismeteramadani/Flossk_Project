package pages.AutomationExercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BasePage;
import utilities.BrowserUtils;
import utilities.WaitUtils;

import java.util.Random;

public class CreateAccountPage extends BasePage{

    @FindBy(id = "id_gender1")
    private WebElement titleMrCheckBox;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "days")
    private WebElement daysSelect;
    @FindBy(id = "months")
    private WebElement monthsSelect;
    @FindBy(id = "years")
    private WebElement yearsSelect;
    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;
    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;
    @FindBy(id = "first_name")
    private WebElement firstNameInput;
    @FindBy(id = "last_name")
    private WebElement lastNameInput;
    @FindBy(id = "company")
    private WebElement companyInput;
    @FindBy(id = "address1")
    private WebElement address1Input;
    @FindBy(id = "address2")
    private WebElement address2Input;
    @FindBy(id = "country")
    private WebElement countrySelect;
    @FindBy(id = "state")
    private WebElement stateInput;
    @FindBy(id = "city")
    private WebElement cityInput;
    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;
    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;
    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountButton;

    public void createAccount(){
        titleMrCheckBox.click();
        passwordField.sendKeys(faker.internet().password());
        BrowserUtils.selectByVisibleText("Day",daysSelect);
        BrowserUtils.selectByVisibleText("Month",monthsSelect);
        BrowserUtils.selectByVisibleText("Year",yearsSelect);
        WaitUtils.waitUntilElmIsClickable(newsletterCheckbox);
        WaitUtils.waitUntilElmIsClickable(specialOffersCheckbox);
        firstNameInput.sendKeys(faker.name().firstName());
        lastNameInput.sendKeys(faker.name().lastName());
        companyInput.sendKeys(faker.name().name());
        address1Input.sendKeys(faker.address().streetAddress());
        address2Input.sendKeys(faker.address().secondaryAddress());
        BrowserUtils.selectByValue("India",countrySelect);
        stateInput.sendKeys(faker.address().state());
        cityInput.sendKeys(faker.address().city());
        zipcodeInput.sendKeys(faker.address().zipCode());
        mobileNumberInput.sendKeys(faker.phoneNumber().phoneNumber());
    }

    public void clickOnCreateAccountButton(){
        BrowserUtils.moveToElement(createAccountButton);
        createAccountButton.click();
    }
}
