package page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPageWithStaticUrl extends AbstractPage {
    public AbstractPageWithStaticUrl(WebDriver driver) {
        super(driver);
    }

    protected abstract AbstractPage openPage();
}
