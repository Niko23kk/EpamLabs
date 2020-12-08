package page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver=driver;
    }
}
