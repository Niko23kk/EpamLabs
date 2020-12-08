package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static WebDriver driver;

//    private DriverSingleton(){}
//
//    public static WebDriver getDriver(){
//        if(driver==null)
//        {
//            System.out.println(System.getProperty("browser").toString());
//            switch (System.getProperty("browser").toString()) {
//                case "firefox": {
//                    WebDriverManager.firefoxdriver().setup();
//                    driver = new FirefoxDriver();
//                }
//                default: {
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
//                }
//            }
//        }
//        return driver;
//    }
//
//    public static void closeDriver(){
//        driver.quit();
//        driver=null;
//    }
}
