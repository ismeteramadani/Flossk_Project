package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;

public abstract class BaseClass {

    protected static WebDriver driver;
    protected static Actions actions;
    protected static Alert alert;
    protected static WebDriverWait wait;
    protected static Select select;

    @BeforeSuite
    public void setUp (){
        driver = Driver.getDriver();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    @AfterSuite
    public void tearDown(){

        Driver.closeDriver();
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result){
        if (ITestResult.FAILURE == result.getStatus()){
            try {
                TakesScreenshot scrShot = ((TakesScreenshot) driver);
                File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
                File destFile = new File(System.getProperty("user.home")+
                        "/IdeaProjects/Flossk_Project/target/screenshots-for-failed-testcases/"+
                        result.getName()+ ".png");
                FileUtils.copyFile(srcFile, destFile);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
