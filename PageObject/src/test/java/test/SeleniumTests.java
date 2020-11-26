package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import page.SeleniumOrderPage;
import page.SeleniumProductPage;

public class SeleniumTests {
    private WebDriver driver;

    @Test
    public void checkCorrectSaleWithPromocode() {
        driver = new ChromeDriver();
        new SeleniumProductPage(driver).openPage().addProductToOrder();
        SeleniumOrderPage orderPage= new SeleniumOrderPage(driver).openPage().inputSalePromocode().confirmSalePromocode().checkCorrectSale();

        Assert.assertEquals(orderPage.getOrderPriceValue(),orderPage.getOrderSaleValue()*10);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDownAfterCheckCorrectSaleWithPromocode() {
        driver.quit();
    }

    @Test
    public void checkValidationNumbderPhone() {
        driver = new ChromeDriver();
        new SeleniumProductPage(driver).openPage().addProductToOrder();
        Assert.assertEquals(new SeleniumOrderPage(driver).openPage().inputPhoneNumber().clickEmail().getEmailErrorSpan(),"Введите телефон");

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDownAfterCheckValidationNumbderPhone() {
        driver.quit();
    }
}
