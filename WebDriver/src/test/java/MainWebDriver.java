import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class MainWebDriver {

    private WebDriver driver;
    private String promoCode = "CP-4MDYA-4QEKDOC";

    @Test
    public void сheckWorkSaleOfPromoCodes() {
        driver = new ChromeDriver();

        driver.get("https://vans.ru/catalog/item/42048-kedy-japanese-type-era.html");

        WebElement addProductToOrderButton = waitWebElementLocatedBy(driver,By
                        .xpath("//div[@class='product__content']//button[contains(@class,'mod-5')]"));

        addProductToOrderButton.click();

        WebElement goToOrderButton = driver.findElement(By.xpath("//li[@class='top-nav__item mod-basket']"));

        goToOrderButton.click();

        WebElement promoCodeInput = waitWebElementLocatedBy(driver,By
                        .xpath("//div[@class='b-input-with-btn__content']//input[@class='b-input-with-btn__input']"));

        WebElement promoCodeButton = driver.findElement(By
                        .xpath("//div[@class='b-input-with-btn__content']//button[@class='b-input-with-btn__btn']"));

        promoCodeInput.sendKeys(promoCode);

        promoCodeButton.click();

        WebElement orderPrice = driver.findElement(By
                        .xpath("//div[@class='b-make-order__price']//span[@class='b-make-order__price-value']"));

        WebElement orderSale = driver.findElement(By
                        .xpath("//div[contains(@class,'b-make-order__price-sale')]//span[@class='b-make-order__price-value']"));

        WebElement checkPromoCode = waitWebElementLocatedBy(driver, By
                        .xpath("//div[@class='b-make-order']//span[@class='b-input-with-btn__error' and text()='применен']"));

        Assert.assertEquals(orderPrice.getText().replaceAll("[^\\d.]", ""),
                Integer.toString(Integer.parseInt(orderSale.getText().replaceAll("[^\\d.]", "")) * 10));

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
    }

    public static WebElement waitWebElementLocatedBy(WebDriver driver, By by)
    {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
