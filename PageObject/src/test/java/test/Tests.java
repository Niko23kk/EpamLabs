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
        OrderPage orderPage = new ProductPage(driver)
                .openPage(partUrlPageWithProduct)
                .addProductToOrder()
                .goToOrderPage()
                .openPage()
                .inputSalePromocode(promoCode)
                .confirmSalePromocode();

        Assert.assertEquals(Math.floor(orderPage.getOrderPriceValue()*0.1), orderPage.getOrderSaleValue());
    }

    @Test
    public void checkValidationNumberPhone() {
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

    @AfterTest(alwaysRun = true)
    public void quiteBrowserAfterTest() {
        driver.quit();
    }
}
