package page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wait.WaitJQueryAJAXCompleted;
import wait.WaitWebElement;

import javax.swing.*;

public class OrderPage extends AbstractPageWithStaticUrl {

    @FindBy(xpath = "//div[@class='b-input-with-btn__content']//input[@class='b-input-with-btn__input']")
    private WebElement promoCodeInput;

    @FindBy(xpath = "//div[@class='b-input-with-btn__content']//button[@class='b-input-with-btn__btn']")
    private WebElement promoCodeButton;

    @FindBy(xpath = "//div[@class='b-user-info__fields']//div[contains(@class,'b-input-field')][1]//input")
    private WebElement nameInput;

    @FindBy(xpath = "//div[@class='b-user-info__fields']//div[contains(@class,'b-input-field')][2]//input")
    private WebElement surnameInput;

    @FindBy(xpath = "//div[@class='b-user-info__fields']//div[contains(@class,'b-input-field')][3]//input")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//div[@class='b-user-info__fields']//div[contains(@class,'b-input-field')][4]//input")
    private WebElement emailInput;

    @FindBy(xpath = "//div[@class='b-user-info__fields']//div[contains(@class,'b-input-field')][5]//input")
    private WebElement cityInput;

    @FindBy(xpath = "//div[@class='b-user-info__fields']//div[contains(@class,'b-input-field')][6]//input")
    private WebElement postcodeInput;

    @FindBy(xpath = "//div[@class='b-make-order__price']//span[@class='b-make-order__price-value']")
    private WebElement orderPriceValue;

    @FindBy(xpath = "//div[contains(@class,'b-make-order__price-sale')]//span[@class='b-make-order__price-value']")
    private WebElement orderSaleValue;

    @FindBy(xpath = "//div[@class='b-make-order__price b-make-order__price-delivery']//span[@class='b-make-order__price-value']")
    private WebElement orderDeliveryValue;

    @FindBy(xpath = "//span[@class='b-input-field__error']")
    private WebElement emailErrorSpan;

    @FindBy(xpath = "//div[@class='b-card-payment'][2]")
    private WebElement paymentByCardButton;

    @FindBy(xpath = "//div[@class='b-preloader js-preloader mod-checkout']")
    private WebElement loadingPlaceholder;

    @FindBy(xpath = "//span[@class='b-card-delivery__type' and text()='Почта России']")
    private WebElement postOfRussianButton;

    public OrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
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

    public int getOrderDeliveryValue() {
        return Integer.parseInt(orderDeliveryValue.getText().replaceAll("[^\\d.]", ""));
    }

    public boolean checkCorrectSale() {
        try {
            WebElement checkPromoCode = WaitWebElement.waitWebElementLocatedBy(driver, By
                    .xpath("//div[@class='b-make-order']//span[@class='b-input-with-btn__error' and text()='применен']"));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public OrderPage inputName(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    public OrderPage inputSurname(String surname) {
        surnameInput.sendKeys(surname);
        return this;
    }

    public OrderPage inputPhoneNumber(String phoneNumber) {
        phoneNumberInput.sendKeys(phoneNumber);
        return this;
    }

    public OrderPage inputEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public OrderPage inputCity(String city) {
        //cityInput.sendKeys(city);
        for (char t:city.toCharArray()){
            cityInput.sendKeys(new String(""+t));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public OrderPage selectCityFromList(int select){
        driver.findElement(By.xpath("//ul[contains(@class,'b-input-select__list')][1]//li["+select+"]")).click();
        WaitWebElement.waitWebElementInvisibilityOf(driver,loadingPlaceholder);
        return this;
    }

    public OrderPage inputPostcode(String postcode) {
        postcodeInput.sendKeys(postcode);
        return this;
    }

    public OrderPage clickEmail() {
        emailInput.click();
        return this;
    }

    public OrderPage clickPaymentByCard(){
        paymentByCardButton.click();
        WaitWebElement.waitWebElementInvisibilityOf(driver,loadingPlaceholder);
        return this;
    }

    public OrderPage clickPostOfRussianButton(){
        postOfRussianButton.click();
        WaitWebElement.waitWebElementInvisibilityOf(driver,loadingPlaceholder);
        return this;
    }

    public OrderPage selectCountForProduct(int numberOfProduct,int count){
        driver.findElement(By.xpath("//select[@class='b-input b-input-select'][%numberOfProduct - 1%]" +
                "//option[@class='b-input-select__option'][%count%]"));
        return this;
    }

    public OrderPage changeCountOfProduct(int orderProduct,int countProduct){
        driver.findElement(By.xpath(String.format("//div[@class='b-order-product'][%d]" +
                "//option[@class='b-input-select__option'][%d]",orderProduct,countProduct))).click();
        WaitWebElement.waitWebElementInvisibilityOf(driver,loadingPlaceholder);
        return this;
    }

    public String getEmailErrorSpan() {
         return emailErrorSpan.getText();
    }
}
