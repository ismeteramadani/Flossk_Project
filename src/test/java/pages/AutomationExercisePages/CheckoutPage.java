package pages.AutomationExercisePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.BasePage;
import utilities.BrowserUtils;

import java.util.List;

public class CheckoutPage extends BasePage{

    @FindBy(xpath = "//h2[text()='Address Details']")
    private WebElement adressDetails;
    @FindBy(xpath = "//li[@class='address_firstname address_lastname']")
    private List<WebElement> firstLastName;
    @FindBy(xpath = "//li[@class='address_address1 address_address2']")
    private List<WebElement> addresses;
    @FindBy(xpath = "//li[@class='address_city address_state_name address_postcode']")
    private List<WebElement> cityStateNamePostcode;
    @FindBy(xpath = "//li[@class='address_country_name']")
    private List<WebElement> country;
    @FindBy(xpath = "//h2[text()='Review Your Order']")
    private WebElement reviewYourOrder;
    @FindBy(xpath = "//*[@class='form-control']")
    private WebElement commentTextArea;
    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    private WebElement placeOrder;

    public void verifyAddressDetailsAndReviewYourOrder(){
        Assert.assertEquals("Address Details",adressDetails.getText());
        Assert.assertEquals(firstLastName.get(0).getText(),firstLastName.get(1).getText());
        Assert.assertEquals(addresses.get(0).getText(),addresses.get(3).getText());
        Assert.assertEquals(addresses.get(1).getText(),addresses.get(4).getText());
        Assert.assertEquals(addresses.get(2).getText(),addresses.get(5).getText());
        Assert.assertEquals(cityStateNamePostcode.get(0).getText(),cityStateNamePostcode.get(1).getText());
        Assert.assertEquals(country.get(0).getText(),country.get(1).getText());

        Assert.assertEquals("Review Your Order",reviewYourOrder.getText());
    }
    public void enterDescriptionInCommentTextAreaAndClickPlaceOrder(){
        commentTextArea.sendKeys(faker.lorem().sentence());
        BrowserUtils.moveToElement(placeOrder);
        placeOrder.click();
    }

}
