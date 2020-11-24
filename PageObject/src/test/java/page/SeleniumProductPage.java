package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumProductPage extends AbstractPage {

    @Override
    public AbstractPage openPage()
    {
        driver.get("https://vans.ru/catalog/item/42048-kedy-japanese-type-era.html");
        return  this;
    }

    public SeleniumProductPage(WebDriver driver)
    {
        super(driver);
    }

    public SeleniumProductPage addProductToOrder()
    {
        WebElement addProductToOrderButton = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@class='product__content']//button[contains(@class,'mod-5')]")));

        addProductToOrderButton.click();
        return this;
    }
}
