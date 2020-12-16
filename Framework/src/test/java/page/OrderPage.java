package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class OrderPage extends AbstractPageWithStaticUrl {

    @FindBy(xpath = "//div[@class='b-input-with-btn__content']//input[@class='b-input-with-btn__input']")
    private WebElement promoCodeInput;

    @FindBy(xpath = "//div[@class='b-input-with-btn__content']//button[@class='b-input-with-btn__btn']")
    private WebElement promoCodeButton;

    @FindBy(xpath = "//span[@class='b-input-field__label' and text()='Ваше имя']/..//input")
    private WebElement nameInput;

    @FindBy(xpath = "//span[@class='b-input-field__label' and text()='Ваша фамилия']/..//input")
    private WebElement surnameInput;

    @FindBy(xpath = "//div[@class='b-user-info__fields']//input[contains(@class,'b-input-tel')]")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//span[@class='b-input-field__label' and text()='Email']/..//input")
    private WebElement emailInput;

    @FindBy(xpath = "//span[@class='b-input-field__label' and text()='Город']/..//input")
    private WebElement cityInput;

    @FindBy(xpath = "//span[@class='b-input-field__label' and text()='Почтовый индекс']/..//input")
    private WebElement postcodeInput;

    @FindBy(xpath = "//div[@class='b-make-order__price']//span[@class='b-make-order__price-value']")
    private WebElement orderPriceValue;

    @FindBy(xpath = "//div[contains(@class,'b-make-order__price-sale')]//span[@class='b-make-order__price-value']")
    private WebElement orderSaleValue;

    @FindBy(xpath = "//div[@class='b-make-order__price b-make-order__price-delivery']//span[@class='b-make-order__price-value']")
    private WebElement orderDeliveryValue;

    @FindBy(xpath = "//span[@class='b-input-field__label']/..//span[@class='b-input-field__error']")
    private WebElement phoneNumberErrorSpan;

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
        waitWebElementInvisibilityOf(loadingPlaceholder);
        return this;
    }

    public int getOrderPriceValue() {
        return getIntByWebElementText(orderPriceValue);
    }

    public int getOrderSaleValue() {
        return getIntByWebElementText(orderSaleValue);
    }

    public int getOrderDeliveryValue() {
        return getIntByWebElementText(orderDeliveryValue);
    }

    public boolean checkCorrectSale() {
        return !driver.findElements(By.xpath("//div[@class='b-make-order']//span[@class='b-input-with-btn__error'" +
                " and text()='применен']")).isEmpty();
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
        for (int i = 0; i < 3; i++) {
            cityInput.sendKeys(city.charAt(i) + "");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 3; i < city.length(); i++) {
            cityInput.sendKeys(city.charAt(i) + "");
            waitWebElementLocatedBy(By.xpath("//ul[contains(@class,'b-input-select__list')]//li"));
        }
        return this;
    }

    public OrderPage selectCityFromList(String city){
        waitWebElementLocatedBy(By.xpath("//ul[contains(@class,'b-input-select__list')][1]//li[text()='"+city+"']")).click();
        waitWebElementInvisibilityOf(loadingPlaceholder);
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
        waitWebElementInvisibilityOf(loadingPlaceholder);
        return this;
    }

    public OrderPage clickPostOfRussianButton(){
        postOfRussianButton.click();
        waitWebElementInvisibilityOf(loadingPlaceholder);
        return this;
    }

    public OrderPage changeCountOfProduct(String productUrl,int countProduct){
        driver.findElement(By.xpath(String.format("//a[contains(@href,'%s')]/../..//select" +
                "//option[@class='b-input-select__option'][%d]",productUrl,countProduct))).click();
        waitWebElementInvisibilityOf(loadingPlaceholder);
        return this;
    }

    public int getSumAllProductPrice(){
        List<WebElement> allPrice=driver.findElements(By.xpath("//span[@class='b-order-product__price-current']//span[1]"));
        return allPrice.stream().mapToInt(element -> getIntByWebElementText(element)).sum();
    }

    public String getPhoneNumberErrorSpan() {
         return phoneNumberErrorSpan.getText();
    }

    private int getIntByWebElementText(WebElement webElement){
        return Integer.parseInt(webElement.getText().replaceAll("[^\\d.]", ""));
    }
}
