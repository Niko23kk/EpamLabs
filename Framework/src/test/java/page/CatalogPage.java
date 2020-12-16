package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogPage extends AbstractPageWithParameterizedUrl {

    @FindBy(xpath = "//div[@class='preloader js-preloader']")
    private WebElement loadingPlaceholder;

    @FindBy(xpath = "//button[@class='catalog-filter__title']/span[text()='Цвет']/../..//button[@class='catalog-filter__category-more']")
    private WebElement moreColorButton;

    public CatalogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public CatalogPage openPage(String partUrl) {
        driver.get("https://vans.ru/catalog/"+partUrl);
        return this;
    }

    public CatalogPage clickToChooseFilterColor(String color) {
        driver.findElement(By.xpath("//button[@class='catalog-filter__title']/span[text()='Цвет']/../..//" +
                "li//button[contains(text(),'"+color+"')]")).click();
        waitWebElementInvisibilityOf(loadingPlaceholder);
        return this;
    }

    public CatalogPage clickMoreFilterColor(){
        moreColorButton.click();
        return this;
    }

    public List<String> getAllProductColor() {
        List<String> list =new ArrayList<>();
        driver.findElements(By.xpath("//ul[@class='catalog-content__list js-catalog-list']//article[@class='catalog-item']//a"))
                .stream().forEach(s->list.add(s.getAttribute("data-impression-data-variant")));
        return list;
    }

    public CatalogPage clickToChooseCategoryProduct(String category) {
        driver.findElement(By.xpath("//button[@class='catalog-filter__title']/span[text()='Категория']/../..//" +
                "li//button[contains(text(),'"+category+"')]")).click();
        waitWebElementInvisibilityOf(loadingPlaceholder);
        return this;
    }

    public List<String> getAllProductCategory() {
        List<String> list =new ArrayList<>();
        driver.findElements(By.xpath("//ul[@class='catalog-content__list js-catalog-list']//article[@class='catalog-item']//a"))
                .stream().forEach(s->list.add(s.getAttribute("data-impression-data-category")));
        return list;
    }
}
