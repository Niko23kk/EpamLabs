package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class CommonConditions {
    protected WebDriver driver;
    protected String partUrlPageWithProduct = "42048-kedy-japanese-type-era.html";
    protected String promoCode = "CP-4MDYA-4QEKDOC";
    protected String phoneNumber = "173";
    protected String email = "ага@mail.ru";

    @BeforeTest
    public void browserStart() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.deleteAllCookies();
    }

    @AfterTest
    public void quiteBrowserAfterTest() {
        DriverSingleton.closeDriver();
    }

}
