package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.OrderPage;
import page.ProductPage;

public class Tests {
    private WebDriver driver;
    private final String partUrlPageWithProduct = "42048-kedy-japanese-type-era.html";
    private final String promoCode="CP-4MDYA-4QEKDOC";
    private final String phoneNumber ="173";

    @BeforeTest
    public void browserStart() {
        driver = new ChromeDriver();
    }

    @Test
    public void checkCorrectSaleWithPromocode() {
        int procentSale=10;
        OrderPage orderPage = new ProductPage(driver)
                .openPage(partUrlPageWithProduct)
                .addProductToOrder()
                .goToOrderPage()
                .openPage()
                .inputSalePromocode(promoCode)
                .confirmSalePromocode();

        Assert.assertTrue(orderPage.checkCorrectSale());
        Assert.assertEquals(orderPage.getOrderPriceValue()*procentSale, orderPage.getOrderSaleValue() * 100);
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

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    public void quiteBrowserAfterTest() {
        driver.quit();
    }
}