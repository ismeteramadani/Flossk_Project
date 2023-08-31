package pages.AutomationExercisePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BasePage;
import utilities.BrowserUtils;

public class CategoryPage extends BasePage{

    @FindBy(css = "h2[class='title text-center']")
    private WebElement womenTops;
    @FindBy(css = "a[href='#Men']")
    private WebElement menCategory;
    @FindBy(css = "a[href='/category_products/3']")
    private WebElement tShirtsMen;

    public String confirmText(){
        return womenTops.getText().toUpperCase();
    }
    public void clickMenCategory(){
        BrowserUtils.moveToElement(menCategory);
        menCategory.click();
    }
    public void clickOnTShirtsMen(){
        BrowserUtils.moveToElement(tShirtsMen);
        tShirtsMen.click();
    }

}
