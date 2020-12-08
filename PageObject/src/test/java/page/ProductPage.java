package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AbstractPageWithParameterizedUrl {

    @FindBy(xpath = "//div[@class='product__content']//button[contains(@class,'mod-5')]")
    private WebElement addProductToOrderButton;

    @FindBy(xpath = "//li[@class='top-nav__item mod-basket']")
    private WebElement goToOrderPageButton;

    public ProductPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public ProductPage openPage(String urlPart) {
        driver.get("https://vans.ru/catalog/item/"+urlPart);
        return this;
    }

    public ProductPage addProductToOrder()
    {
        addProductToOrderButton.click();
        return this;
    }

    public OrderPage goToOrderPage(){
        goToOrderPageButton.click();
        return new OrderPage(driver);
    }
}
