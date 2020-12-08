package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wait.WaitWebElement;

public class OrderPage extends AbstractPageWithStaticUrl {

    @FindBy(xpath = "//div[@class='b-input-with-btn__content']//input[@class='b-input-with-btn__input']")
    private WebElement promoCodeInput;

    @FindBy(xpath = "//div[@class='b-input-with-btn__content']//button[@class='b-input-with-btn__btn']")
    private WebElement promoCodeButton;

    @FindBy(xpath = "//input[@class='b-input b-input-tel']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@class='b-input b-input-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//div[@class='b-make-order__price']//span[@class='b-make-order__price-value']")
    private WebElement orderPriceValue;

    @FindBy(xpath = "//div[contains(@class,'b-make-order__price-sale')]//span[@class='b-make-order__price-value']")
    private WebElement orderSaleValue;

    @FindBy(xpath = "//span[@class='b-input-field__error']")
    private WebElement emailErrorSpan;

    public OrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public OrderPage openPage() {
        driver.get("https://vans.ru/checkout/order/");
        return this;
    }

    public OrderPage inputSalePromocode(String promoCode) {
        promoCodeInput.sendKeys(promoCode);
        return this;
    }

    public OrderPage confirmSalePromocode() {
        promoCodeButton.click();
        return this;
    }

    public int getOrderPriceValue() {
        return Integer.parseInt(orderPriceValue.getText().replaceAll("[^\\d.]", ""));
    }

    public int getOrderSaleValue() {
        return Integer.parseInt(orderSaleValue.getText().replaceAll("[^\\d.]", ""));
    }

    public boolean checkCorrectSale() {
        try {
            WaitWebElement.waitWebElementLocatedBy(driver, By
                    .xpath("//div[@class='b-make-order']//span[@class='b-input-with-btn__error' and text()='применен']"));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public OrderPage inputPhoneNumber(String phoneNumber) {
        phoneNumberInput.sendKeys(phoneNumber);
        return this;
    }

    public OrderPage clickEmail() {
        emailInput.click();
        return this;
    }

    public String getEmailErrorSpan() {
         return emailErrorSpan.getText();
    }
}
