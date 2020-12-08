package page;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import wait.WaitJQueryAJAXCompleted;
import wait.WaitWebElement;

import java.util.concurrent.TransferQueue;

public class ProductPage extends AbstractPageWithParameterizedUrl {

    @FindBy(xpath = "//div[@class='product__content']//button[contains(@class,'mod-5')]")
    private WebElement addProductToOrderButton;

    @FindBy(xpath = "//div[@class='product__content']//button[contains(@class,'mod-6')]")
    private WebElement forFastOrderingButton;

    @FindBy(xpath = "//input[@id='fastorder-email']")
    private WebElement emailToDoFastOrdering;

    @FindBy(xpath = "//div[@class='fastorder-popup']//button[contains(@class,'buy')]")
    private WebElement toMakeOrderButton;

    @FindBy(xpath = "//div[@class='fastorder-popup']//div[@class='form__row form-input']//span[contains(@class,'form-error')]")
    private WebElement errorInInputEmail;

    @FindBy(xpath = "//a[@class='product__controls-link js-add-favorite']")
    private WebElement addToFavoriteButton;

    @FindBy(xpath = "//li[@class='top-nav__item mod-basket']")
    private WebElement goToOrderPageButton;

    @FindBy(xpath = "//li[@class='top-nav__item']//a[@class='main-nav__head-link js-nav-item-link mod-user-link']")
    private WebElement goToFavoritePageButton;

    @FindBy(xpath = "//ul[@class='product-colors__list']")
    private WebElement similarProductList;

    @FindBy(xpath = "//span[@class='js-article']")
    private WebElement articleSpan;

    @FindBy(xpath = "//span[@class='js-color-title']")
    private WebElement colorSpan;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public ProductPage openPage(String urlPart) {
        driver.get("https://vans.ru/catalog/item/" + urlPart);
        return this;
    }

    public ProductPage addProductToOrder() {
        addProductToOrderButton.click();
        return this;
    }

    public ProductPage chooseSimilarProduct(int order){
        similarProductList.findElements(By.xpath("//li[@class='product-colors__item']")).get(order-1).click();
        return this;
    }

    public ProductPage makeFastOrder() {
        forFastOrderingButton.click();
        return this;
    }

    public ProductPage inputEmailToMakeFastOrder(String email) {
        emailToDoFastOrdering.sendKeys(email);
        return this;
    }

    public ProductPage makeOrder() {
        toMakeOrderButton.click();
        return this;
    }

    public ProductPage addToFavorite() {
        addToFavoriteButton.click();
        return this;
    }

    public OrderPage goToOrderPage(){
        goToOrderPageButton.click();
        return new OrderPage(driver);
    }

    public FavoritePage goToFavoritePage(){
        goToFavoritePageButton.click();
        return new FavoritePage(driver);
    }

    public String getErrorInInputEmail() {
        return errorInInputEmail.getText();
    }

    public String getArticleProduct() {
        return articleSpan.getText();
    }

    public String getColorProduct() {
        return colorSpan.getText();
    }
}
