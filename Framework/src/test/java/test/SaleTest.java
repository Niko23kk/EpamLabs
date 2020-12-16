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

public class SaleTest extends CommonConditions{
    @Test
    public void checkCorrectSaleWithPromocode() {
        Product product=ProductCreator.withAllProperty("first");
        OrderPage orderPage = new ProductPage(driver)
                .openPage(product.getProductUrl())
                .addProductToOrder()
                .goToOrderPage()
                .openPage()
                .inputSalePromocode(promoCode)
                .confirmSalePromocode();

        assertThat(orderPage.checkCorrectSale()).isTrue();
        assertThat(Math.floor(orderPage.getOrderPriceValue()*percentPromocodeSale)).isEqualTo(orderPage.getOrderSaleValue());
    }

    @Test
    public void checkFreeDelivery() {
        Product product= ProductCreator.withEmptyProductSize("first");
        User user= UserCreator.withAllProperty();
        OrderPage orderPage = new ProductPage(driver)
                .openPage(product.getProductUrl())
                .addProductToOrder()
                .goToOrderPage()
                .openPage()
                .inputCity(user.getPlaceOfLife())
                .selectCityFromList(user.getTypePlaceOfLife())
                .clickPostOfRussianButton();


        assertThat(orderPage.getOrderPriceValue()-orderPage.getOrderSaleValue()).isGreaterThan(3000);
        assertThat(orderPage.getOrderDeliveryValue()).isZero();
    }

    @Test
    public void checkSaleWithOrderByCard(){
        Product product=ProductCreator.withEmptyProductSize("first");
        OrderPage orderPage= new ProductPage(driver)
                .openPage(product.getProductUrl())
                .addProductToOrder()
                .goToOrderPage()
                .openPage()
                .clickPaymentByCard();

        assertThat(Math.floor(orderPage.getOrderPriceValue()*percentBuyCartSale)).isEqualTo(orderPage.getOrderSaleValue());
    }
}
