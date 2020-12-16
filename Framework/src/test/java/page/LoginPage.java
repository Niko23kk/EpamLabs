package page;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPageWithStaticUrl{

    @FindBy(xpath = "//input[@id='login']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@id='system_auth_form_submit']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//li[contains(@class,'top-nav__item')][2]")
    private WebElement accountPageButton;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public LoginPage openPage()
    {
        driver.navigate().to("https://vans.ru/customer/account/login/");
        return this;
    }

    public LoginPage inputUserLogin(String login){
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage inputUserPassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmitButton(){
        buttonSubmit.click();
        return this;
    }

    public AccountPage clickGoToAccountPageButton(){
        accountPageButton.click();
        return new AccountPage(driver);
    }
}
