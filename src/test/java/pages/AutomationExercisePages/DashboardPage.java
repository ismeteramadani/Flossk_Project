package pages.AutomationExercisePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.BasePage;
import utilities.BrowserUtils;
import utilities.WaitUtils;


public class DashboardPage extends BasePage {

    @FindBy(xpath = "//*[@class='fa fa-lock']")
    private WebElement signupLoginButton;
    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productsButton;
    @FindBy(xpath = "//a[@href='/view_cart']")
    private WebElement cartButton;
    @FindBy(id = "accordian")
    private WebElement category;
    @FindBy(xpath = "//*[@id='accordian']/div[1]/div[1]/h4/a/span/i")
    private WebElement womenCategory;
    @FindBy(css = "a[href='/category_products/2']")
    private WebElement topsCategory;


    public void clickOnSignupLoginButton(){
        BrowserUtils.moveToElement(signupLoginButton);
        signupLoginButton.click();
    }
    public void clickOnProductsButton(){
        BrowserUtils.moveToElement(productsButton);
        productsButton.click();
    }
    public void clickOnCartButton(){
        BrowserUtils.moveToElement(cartButton);
        cartButton.click();
    }
    public boolean categoriesAreVisible() {
        return category.isDisplayed();
    }
    public void clickWomenCategory(){
        BrowserUtils.moveToElement(womenCategory);
        womenCategory.click();
    }
    public void clickTopsCategory(){
        BrowserUtils.moveToElement(topsCategory);
        topsCategory.click();
    }

}
