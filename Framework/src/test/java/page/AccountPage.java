package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends AbstractPageWithStaticUrl {

    @FindBy(xpath = "//div[@class='box-content vcard my-info']//p[1]")
    private WebElement userNameField;

    @FindBy(xpath = "//div[@class='box-content vcard my-info']//span[@class='email']")
    private WebElement userNameEmail;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public AccountPage openPage() {
        driver.get("https://www.vans.ru/customer/account/");
        return this;
    }

    public String getUserName(){
        return userNameField.getText();
    }

    public String getUserNameEmail(){
        return userNameEmail.getText();
    }
}
