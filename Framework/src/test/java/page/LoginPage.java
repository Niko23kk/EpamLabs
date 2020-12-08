package page;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;
import service.UserCreator;

public class LoginPage extends AbstractPageWithStaticUrl{

    private final String BASE_URL="https://vans.ru/customer/account/login/";

    @FindBy(xpath = "//input[@id='login']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@id='system_auth_form_submit']")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public LoginPage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public CustomerPage login(User user)
    {
        inputLogin.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        buttonSubmit.click();
        return new CustomerPage(driver);
    }

}
