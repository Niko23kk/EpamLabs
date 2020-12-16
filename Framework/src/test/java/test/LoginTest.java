package test;

import static org.assertj.core.api.Assertions.*;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import model.User;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;
import page.AccountPage;
import page.LoginPage;
import service.UserCreator;

//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/test/features",
//        glue = "ru.savkk.test",
//        tags = "@all",
//        dryRun = false,
//        strict = false,
//        snippets = SnippetType.UNDERSCORE
//)
public class LoginTest extends CommonConditions{
    @Test
    public void userAccessTest(){
        User testUser= UserCreator.withAllProperty();
        LoginPage loginPage= new LoginPage(driver)
                .openPage()
                .inputUserLogin(testUser.getEmail())
                .inputUserPassword(testUser.getPassword());

        String currentUrl=loginPage.getCurrentUrl();
        loginPage.clickSubmitButton();

        assertThat(loginPage.getCurrentUrl()).isNotEqualTo(currentUrl);

        AccountPage accountPage= loginPage.clickGoToAccountPageButton();

        assertThat(accountPage.getUserName()).contains(testUser.getUsername());
        assertThat(accountPage.getUserNameEmail()).isEqualTo(testUser.getEmail());
    }
}
