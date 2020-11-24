package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumOrderPage extends AbstractPage {
    private  WebDriver driver;
    private static String promoCode="CP-4MDYA-4QEKDOC";

    @FindBy(xpath = "//div[@class='b-input-with-btn__content']//input[@class='b-input-with-btn__input']")
    private WebElement promoCodeInput;


    public SeleniumOrderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SeleniumOrderPage openPage()
    {
        driver.get("https://vans.ru/checkout/order/");
        return this;
    }

    public SeleniumOrderPage inputSalePromocode()
    {
        WebElement promoCodeInput = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@class='b-input-with-btn__content']//input[@class='b-input-with-btn__input']")));

        promoCodeInput.sendKeys(promoCode);
        return this;
    }

    public SeleniumOrderPage confirmSalePromocode()
    {
        WebElement promoCodeButton = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@class='b-input-with-btn__content']//button[@class='b-input-with-btn__btn']")));

        promoCodeButton.click();
    }

    public


    WebElement orderPrice = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
            .until(ExpectedConditions.presenceOfElementLocated(By
                    .xpath("//div[@class='b-make-order__price']//span[@class='b-make-order__price-value']")));

    WebElement orderSale = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
            .until(ExpectedConditions.presenceOfElementLocated(By
                    .xpath("//div[contains(@class,'b-make-order__price-sale')]//span[@class='b-make-order__price-value']")));

    WebElement checkPromoCode = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
            .until(ExpectedConditions.presenceOfElementLocated(By
                    .xpath("//div[@class='b-make-order']//span[@class='b-input-with-btn__error' and text()='применен']")));


}
