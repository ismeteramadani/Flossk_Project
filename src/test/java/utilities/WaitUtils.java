package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class WaitUtils extends BaseClass{

    public static void waitUntilElmIsDisplayed(By elm){
        wait.until(ExpectedConditions.presenceOfElementLocated(elm));
    }
    public static void waitUntilElmIsClickable(WebElement elm){
        wait.until(ExpectedConditions.elementToBeClickable(elm)).click();
    }
    public static void waitUntilElmIsVisible(By elm){

        wait.until(ExpectedConditions.visibilityOfElementLocated(elm));
    }
    public static void sleep(int sec){
        try {
            Thread.sleep(sec * 1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
