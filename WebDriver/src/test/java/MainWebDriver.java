import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainWebDriver {

    private String promoCode="CP-4MDYA-4QEKDOC";

    @Test
    public void сheckWorkSaleOfPromoCodes() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://vans.ru/catalog/item/42048-kedy-japanese-type-era.html");

        WebElement addProductToOrderButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@class='product__content']//button[contains(@class,'mod-5')]")));

        addProductToOrderButton.click();

        driver.get("https://vans.ru/checkout/order/");

        WebElement promoCodeInput = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@class='b-input-with-btn__content']//input[@class='b-input-with-btn__input']")));

        WebElement promoCodeButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@class='b-input-with-btn__content']//button[@class='b-input-with-btn__btn']")));

        promoCodeInput.sendKeys(promoCode);

        promoCodeButton.click();

        WebElement orderPrice = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@class='b-make-order__price']//span[@class='b-make-order__price-value']")));

        WebElement orderSale = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(@class,'b-make-order__price-sale')]//span[@class='b-make-order__price-value']")));

        WebElement checkPromoCode = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@class='b-make-order']//span[@class='b-input-with-btn__error' and text()='применен']")));

        Assert.assertTrue(orderPrice.getText().replaceAll("[^\\d.]", "").equals(
                Integer.toString(Integer.parseInt(orderSale.getText().replaceAll("[^\\d.]","")) * 10)));
    }
}
