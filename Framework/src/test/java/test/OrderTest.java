package test;

import static org.assertj.core.api.Assertions.*;
import model.Product;
import model.User;
import org.testng.annotations.Test;
import page.OrderPage;
import page.ProductPage;
import service.ProductCreator;
import service.TestDataReader;
import service.UserCreator;

public class OrderTest extends CommonConditions {
    @Test
    public void checkValidationUncorrectEmailInFastOrder() {
        Product product= ProductCreator.withEmptyProductSize("first");
        String email= TestDataReader.getTestData("test.data.failemail");
        ProductPage productPage = new ProductPage(driver)
                .openPage(product.getProductUrl())
                .clickButtonToMakeFastOrder()
                .inputEmailToMakeFastOrder(email)
                .clickToMakeOrderButton();

        String currentUrl=productPage.getCurrentUrl();
        assertThat(productPage.getErrorInInputEmail()).isEqualTo("Не корректный адрес email");
        assertThat(productPage.fastOrderIsCorrect()).isFalse();
        assertThat(currentUrl).isEqualTo(productPage.getCurrentUrl());
    }

    @Test
    public void checkValidationPhoneNumber() {
        Product product= ProductCreator.withEmptyProductSize("first");
        User user= UserCreator.withAllProperty();
        OrderPage orderPage = new ProductPage(driver)
                .openPage(product.getProductUrl())
                .addProductToOrder()
                .goToOrderPage()
                .openPage()
                .inputPhoneNumber(user.getPhoneNumber());

        String currentUrl=orderPage.getCurrentUrl();

        orderPage.clickEmail();

        assertThat(orderPage.getPhoneNumberErrorSpan()).isEqualTo("Введите телефон");
        assertThat(currentUrl).isEqualTo(orderPage.getCurrentUrl());
    }

    @Test
    public void checkCorrectChangeCountProduct(){
        Product product=ProductCreator.withAllProperty("second");
        OrderPage orderPage=new ProductPage(driver)
                .openPage(product.getProductUrl())
                .addProductToOrder()
                .goToOrderPage()
                .openPage();

        int startPrice=orderPage.getOrderPriceValue();

        orderPage.changeCountOfProduct(product.getProductUrl(),product.getCount());

        assertThat(startPrice*product.getCount()).isEqualTo(orderPage.getOrderPriceValue());
    }

    @Test
    public void checkCorrectSumPriceProduct() {
        Product productFirst = ProductCreator.withAllProperty("first");
        Product productSecond = ProductCreator.withAllProperty("second");

        OrderPage orderPage = new ProductPage(driver)
                .openPage(productFirst.getProductUrl())
                .addProductToOrder()
                .openPage(productSecond.getProductUrl())
                .addProductToOrder()
                .goToOrderPage()
                .openPage();

        assertThat(orderPage.getSumAllProductPrice()).isEqualTo(orderPage.getOrderPriceValue());
    }
}
