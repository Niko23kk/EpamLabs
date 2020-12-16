package page;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    private static final int WAIT_TIMEOUT_SECONDS = 10;
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver=driver;
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public static ExpectedCondition<Boolean> jQueryAJAXCompleted(){
        return new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver){
                return (Boolean) ((JavascriptExecutor)
                        driver).executeScript("return (window.jQuery" + "!=null && (jQuery.active===0));");
            }
        };
    }

    public static WebElement waitWebElementLocatedBy(By by)
    {
        return (new WebDriverWait(DriverSingleton.getDriver(), WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement waitWebElementInvisibilityOf(WebElement element)
    {
        while (!new WebDriverWait(DriverSingleton.getDriver(),WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.invisibilityOf(element))){}
        return element;
    }
}
