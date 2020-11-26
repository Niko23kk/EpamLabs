package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumOrderPage extends AbstractPage {
    private static String promoCode = "CP-4MDYA-4QEKDOC";
    private static String phoneNumber = "173";

    @FindBy(xpath = "//div[@class='b-input-with-btn__content']//input[@class='b-input-with-btn__input']")
    private WebElement promoCodeInput;


    public SeleniumOrderPage(WebDriver driver) {
        super(driver);
    }

    public SeleniumOrderPage openPage() {
        driver.get("https://vans.ru/checkout/order/");
        return this;
    }

    public SeleniumOrderPage inputSalePromocode() {
        WebElement promoCodeInput = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@class='b-input-with-btn__content']//input[@class='b-input-with-btn__input']")));

        promoCodeInput.sendKeys(promoCode);
        return this;
    }

    public SeleniumOrderPage confirmSalePromocode() {
        WebElement promoCodeButton = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@class='b-input-with-btn__content']//button[@class='b-input-with-btn__btn']")));

        promoCodeButton.click();
        return this;
    }

    public int getOrderPriceValue()
    {
        return Integer.parseInt((new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@class='b-make-order__price']//span[@class='b-make-order__price-value']")))
                .getText().replaceAll("[^\\d.]", ""));
    }

    public int getOrderSaleValue()
    {
        return Integer.parseInt((new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(@class,'b-make-order__price-sale')]//span[@class='b-make-order__price-value']")))
                .getText().replaceAll("[^\\d.]", ""));
    }

    public SeleniumOrderPage checkCorrectSale() {
        WebElement checkPromoCode = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@class='b-make-order']//span[@class='b-input-with-btn__error' and text()='применен']")));
        return this;
    }

    public SeleniumOrderPage inputPhoneNumber()
    {
        WebElement phoneNumberInput = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//input[@class='b-input b-input-tel']")));

        phoneNumberInput.sendKeys(phoneNumber);

        return this;
    }

    public SeleniumOrderPage clickEmail()
    {
        (new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//input[@class='b-input b-input-email']"))).click();

        return this;
    }

    public String getEmailErrorSpan()
    {
        return (new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//span[@class='b-input-field__error']"))).getText();
    }
}
