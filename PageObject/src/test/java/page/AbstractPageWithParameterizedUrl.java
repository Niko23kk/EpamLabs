package page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPageWithParameterizedUrl extends AbstractPage {
    public AbstractPageWithParameterizedUrl(WebDriver driver) {
        super(driver);
    }

    protected abstract AbstractPage openPage(String urlPart);
}
