package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wait.WaitWebElement;

public class CatalogPage extends AbstractPageWithParameterizedUrl {
    @FindBy(xpath = "//div[@class='preloader js-preloader']")
    private WebElement loadingPlaceholder;

    public CatalogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public CatalogPage openPage(String partUrl) {
        driver.get("https://vans.ru/catalog/"+partUrl);
        return this;
    }

    public CatalogPage chooseFilterColor(String color) {
        driver.findElement(By.xpath("//button[@class='catalog-filter__title']/span[text()='Цвет']/../..//" +
                "li//button[contains(text(),'"+color+"')]")).click();
        WaitWebElement.waitWebElementInvisibilityOf(driver,loadingPlaceholder);
        return this;
    }

    public boolean checkThatCurrentCatalogItemsColorIs(String color) {
        for (WebElement item:driver.findElements(By.xpath("//ul[@class='catalog-content__list js-catalog-list']" +
                "//article[@class='catalog-item']//a"))) {
            if(!item.getAttribute("data-impression-data-variant").contains(color)){
                return false;
            }
        }
        return true;
    }

    public CatalogPage chooseCategoryProduct(String category) {
        driver.findElement(By.xpath("//button[@class='catalog-filter__title']/span[text()='Категория']/../..//" +
                "li//button[contains(text(),'"+category+"')]")).click();
        WaitWebElement.waitWebElementInvisibilityOf(driver,loadingPlaceholder);
        return this;
    }

    public boolean checkThatCurrentCatalogItemsCategoryIs(String category) {
        for (WebElement item:driver.findElements(By.xpath("//ul[@class='catalog-content__list js-catalog-list']" +
                "//article[@class='catalog-item']//a"))) {
            if(!item.getAttribute("data-impression-data-category").contains(category)){
                return false;
            }
        }
        return true;
    }
}
