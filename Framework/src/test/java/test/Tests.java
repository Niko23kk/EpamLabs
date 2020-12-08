package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.FavoritePage;
import page.OrderPage;
import page.ProductPage;

public class Tests extends CommonConditions {

    @Test
    public void checkValidationUncorrectEmailInFastOrder() {
        String error = new ProductPage(driver)
                .openPage(partUrlPageWithProduct)
                .makeFastOrder()
                .inputEmailToMakeFastOrder(email)
                .makeOrder()
                .getErrorInInputEmail();

        System.out.println(error);
        Assert.assertEquals(error, "Не корректный адрес email");
    }

    @Test
    public void checkCorrectAddToFavorite() {
        FavoritePage favoritePage = new ProductPage(driver)
                .openPage(partUrlPageWithProduct)
                .addToFavorite()
                .goToFavoritePage()
                .openPage();

        Assert.assertEquals(favoritePage.getNumberOfFavoriteProduct(), 1);
        Assert.assertEquals(favoritePage.getSizeFavoriteProductPanel(), 1);
    }

    @Test
    public void checkCorrectFilterByCategory() {
        boolean result = new CatalogPage(driver)
                .openPage("men/")
                .chooseCategoryProduct("Бумажники")
                .checkThatCurrentCatalogItemsCategoryIs("Бумажники");

        Assert.assertTrue(result);
    }

    @Test
    public void checkCorrectFilterCatalogByColor(){
        Boolean result = new CatalogPage(driver)
                .openPage("men/")
                .chooseFilterColor("Бежевый")
                .checkThatCurrentCatalogItemsColorIs("Бежевый");

        Assert.assertTrue(result);
    }

    @Test
    public void checkChangeWhenChooseSimilarProduct(){
        ProductPage productPage=new ProductPage(driver)
                .openPage(partUrlPageWithProduct);

        String startArticle=productPage.getArticleProduct();
        String startColor=productPage.getColorProduct();

        productPage.chooseSimilarProduct(2);

        Assert.assertNotEquals(startArticle,productPage.getArticleProduct());
        Assert.assertNotEquals(startColor,productPage.getColorProduct());
    }

    @Test
    public void checkSaleWithOrderByCard(){
        OrderPage orderPage= new ProductPage(driver)
                .openPage(partUrlPageWithProduct)
                .addProductToOrder()
                .goToOrderPage()
                .openPage()
                .clickPaymentByCard();

        Assert.assertEquals( Math.floor(orderPage.getOrderPriceValue()*0.05), orderPage.getOrderSaleValue());
    }

    @Test
    public void checkFreeDelivery() {
        OrderPage orderPage = new ProductPage(driver)
                .openPage("691-shapka-milford.html")
                .addProductToOrder()
                .goToOrderPage()
                .openPage()
                .inputCity("Минск")
                .selectCityFromList(2)
                .clickPostOfRussianButton();


        Assert.assertTrue((orderPage.getOrderPriceValue()>=3000 && orderPage.getOrderDeliveryValue()==0)
                ||(orderPage.getOrderDeliveryValue()<3000 && orderPage.getOrderDeliveryValue()>0));
    }

    @Test
    public void checkValidationNumbderPhone() {
        OrderPage orderPage = new ProductPage(driver)
                .openPage(partUrlPageWithProduct)
                .addProductToOrder()
                .goToOrderPage()
                .openPage()
                .inputPhoneNumber(phoneNumber)
                .clickEmail();

        Assert.assertEquals(orderPage.getEmailErrorSpan(), "Введите телефон");
    }

    @Test
    public void checkCorrectChangeCountProduct(){
        OrderPage productPage=new ProductPage(driver)
                .openPage(partUrlPageWithProduct)
                .addProductToOrder()
                .goToOrderPage()
                .openPage();

        int startPrice=productPage.getOrderPriceValue();

        productPage.changeCountOfProduct(1,2);

        Assert.assertEquals(startPrice*2,productPage.getOrderPriceValue());
    }

    @Test
    public void checkCorrectSaleWithPromocode() {
        OrderPage orderPage = new ProductPage(driver)
                .openPage(partUrlPageWithProduct)
                .addProductToOrder()
                .goToOrderPage()
                .openPage()
                .inputSalePromocode(promoCode)
                .confirmSalePromocode();

        Assert.assertTrue(orderPage.checkCorrectSale());
        Assert.assertEquals(Math.floor(orderPage.getOrderPriceValue()*0.1), orderPage.getOrderSaleValue());
    }
}
