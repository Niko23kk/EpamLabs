package test;

import static org.assertj.core.api.Assertions.*;

import model.Filter;
import model.Product;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.FavoritePage;
import page.ProductPage;
import service.FilterCreator;
import service.ProductCreator;
import service.TestDataReader;

import java.util.List;

public class ProductTest extends CommonConditions{
    @Test
    public void checkCorrectAddToFavorite() {
        Product product= ProductCreator.withEmptyProductSize("first");
        int expectedCount=1;
        ProductPage productPage = new ProductPage(driver)
                .openPage(product.getProductUrl())
                .addToFavorite();

        assertThat(productPage.isFavoriteProduct()).isTrue();

        FavoritePage favoritePage = productPage.goToFavoritePage()
                .openPage();

        assertThat(favoritePage.getNumberOfFavoriteProduct()).isEqualTo(expectedCount);
        assertThat(favoritePage.getSizeFavoriteProductPanel()).isEqualTo(expectedCount);
    }

    @Test
    public void checkChangeWhenChooseSimilarProduct(){
        Product product=ProductCreator.withEmptyProductSize("first");
        int orderSimilarProduct=2;
        ProductPage productPage=new ProductPage(driver)
                .openPage(product.getProductUrl());

        String startArticle=productPage.getArticleProduct();
        String startColor=productPage.getColorProduct();

        productPage.chooseSimilarProduct(orderSimilarProduct);

        assertThat(startArticle).isNotEqualTo(productPage.getArticleProduct());
        assertThat(startColor).isNotEqualTo(productPage.getColorProduct());
    }

    @Test
    public void checkCorrectFilterByCategory() {
        Filter filter= FilterCreator.withEmptyColor();
        List<String> arrayCategory = new CatalogPage(driver)
                .openPage(TestDataReader.getTestData("test.data.catalog"))
                .clickMoreFilterColor()
                .clickToChooseCategoryProduct(filter.getCategory())
                .getAllProductCategory();

        SoftAssertions softAssertions=generateSoftAssertionWithContains(arrayCategory,filter.getCategory());
        softAssertions.assertAll();
    }

    @Test
    public void checkCorrectFilterCatalogByColor(){
        Filter filter= FilterCreator.withEmptyCategory();
        List<String> arrayColor = new CatalogPage(driver)
                .openPage(TestDataReader.getTestData("test.data.catalog"))
                .clickMoreFilterColor()
                .clickToChooseFilterColor(filter.getColor())
                .getAllProductColor();

        SoftAssertions softAssertions= generateSoftAssertionWithContains(arrayColor,filter.getColor());
        softAssertions.assertAll();
    }

    @Test
    public void checkCorrectFilterCatalogByColorAndCategory(){
        Filter filter= FilterCreator.withAllProperty();
        CatalogPage catalogPage = new CatalogPage(driver)
                .openPage(TestDataReader.getTestData("test.data.catalog"))
                .clickToChooseCategoryProduct(filter.getCategory())
                .clickToChooseFilterColor(filter.getColor());

        SoftAssertions softAssertions= generateSoftAssertionWithContains(catalogPage.getAllProductColor(),filter.getColor());
        softAssertions.assertAll();

        softAssertions=generateSoftAssertionWithContains(catalogPage.getAllProductCategory(),filter.getCategory());
        softAssertions.assertAll();
    }
}
