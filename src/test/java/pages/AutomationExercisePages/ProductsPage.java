package pages.AutomationExercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.BasePage;
import utilities.BrowserUtils;
import utilities.WaitUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsPage extends BasePage{

    @FindBy(xpath = "//div[@class='features_items']")
    private WebElement allProducts;
    @FindBy(xpath = "(//a[text()='View Product'])[1]")
    private WebElement viewFirstProduct;
    @FindBy(xpath = "//*[@class='product-information']/h2")
    private WebElement productName;
    @FindBy(xpath = "//*[@class='product-information']/p[1]")
    private WebElement productCategory;
    @FindBy(xpath = "//*[@class='product-information']/span/span")
    private WebElement productPrice;
    @FindBy(xpath = "//*[@class='product-information']/p[2]")
    private WebElement productAvailability;
    @FindBy(xpath = "//*[@class='product-information']/p[3]")
    private WebElement productCondition;
    @FindBy(xpath = "//*[@class='product-information']/p[4]")
    private WebElement productBrand;
    @FindBy (xpath = "//a[@data-product-id='1']")
    private WebElement hoverOverFirstProduct;
    @FindBy (xpath = "//button[text()='Continue Shopping']")
    private WebElement continueShoppingButton;
    @FindBy(xpath = "//a[@data-product-id='2']")
    private WebElement hoverOverSecondProduct;
    @FindBy(xpath = "//a//u[text()='View Cart']")
    private WebElement viewCartButton;
    @FindBy(xpath = "//tr[@id='product-1']")
    private WebElement product1;
    @FindBy(xpath = "//tr[@id='product-2']")
    private WebElement product2;
    @FindBy(xpath = "//*[text()='Write Your Review']")
    private WebElement writeReview;
    @FindBy(id = "name")
    private WebElement yourNameInput;

    @FindBy(id = "email")
    private WebElement emailAddress;

    @FindBy(id = "review")
    private WebElement addReviewHere;

    @FindBy(id = "button-review")
    private WebElement submitButton;
    @FindBy(css = "div[class='alert-success alert'] span")
    private WebElement successMessage;


    public boolean isAllProductsListVisible(){

        return allProducts.isDisplayed();
    }
    public void clickOnViewProduct1(){
        viewFirstProduct.click();

    }
    public void productDetails(){
        Assert.assertTrue(productName.isDisplayed());
        Assert.assertTrue(productCategory.isDisplayed());
        Assert.assertTrue(productPrice.isDisplayed());
        Assert.assertTrue(productAvailability.isDisplayed());
        Assert.assertTrue(productCondition.isDisplayed());
        Assert.assertTrue(productBrand.isDisplayed());
    }
    public void hoverOverFirstProductAndClickAddToCart(){
       BrowserUtils.moveToElement(hoverOverFirstProduct);
       hoverOverFirstProduct.click();

    }
    public void clicOnContinueShopingButton(){
        WaitUtils.waitUntilElmIsClickable(continueShoppingButton);
    }
    public void hoverOverSecondProductAndClickAddToCart(){
        BrowserUtils.moveToElement(hoverOverSecondProduct);
        hoverOverSecondProduct.click();
    }
    public void clickOnViewCartButton(){
        WaitUtils.waitUntilElmIsClickable(viewCartButton);
    }
    public void productsAddedToCart(){
       Assert.assertTrue(product1.isDisplayed());
       Assert.assertTrue(product2.isDisplayed());
    }


    public boolean isWriteYourReviewVisible(){
        return writeReview.isDisplayed();
    }
    public void enterNameEmailAndReview(){
        yourNameInput.sendKeys(faker.name().firstName());
        emailAddress.sendKeys(faker.internet().emailAddress());
        addReviewHere.sendKeys(faker.lorem().sentence());
    }
    public void clickSubmitButton(){
        BrowserUtils.moveToElement(submitButton);
        submitButton.click();
    }
    public boolean verifySuccessMessage(){
        return successMessage.isDisplayed();
    }


}
