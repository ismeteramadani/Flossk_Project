package utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected  WebDriver driver = Driver.getDriver();
    protected Faker faker = new Faker();
    public BasePage(){

        PageFactory.initElements(driver,this);
    }
}
