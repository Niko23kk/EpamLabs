package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FavoritePage extends AbstractPageWithStaticUrl{

    @FindBy(xpath = "//a[@class='main-nav__head-link js-nav-item-link mod-user-link']//span[@class='js-wishlist-count']")
    public WebElement numberOfFavoriteProduct;

    public FavoritePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public FavoritePage openPage(){
        driver.get("https://vans.ru/customer/wishlist/");
        return this;
    }

    public int getSizeFavoriteProductPanel(){
        return driver.findElements(By.xpath("//div[@class='wishlist__item js-wishlist-item']")).size();
    }

    public int getNumberOfFavoriteProduct(){
        return Integer.parseInt(numberOfFavoriteProduct.getText());
    }
}
