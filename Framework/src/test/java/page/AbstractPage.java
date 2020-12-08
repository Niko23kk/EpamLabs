package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver=driver;
    }
}
