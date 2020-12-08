package wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitWebElement {
    public static WebElement waitWebElementLocatedBy(WebDriver driver, By by)
    {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement waitWebElementInvisibilityOf(WebDriver driver, WebElement element)
    {
        while (!new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOf(element))){}
        return element;
    }
}
