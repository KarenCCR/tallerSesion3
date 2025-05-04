package testSuite;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.LoginSection;
import pages.MainPage;
import pages.MenuSection;
import session.Session;

public class LoginTest {
    LoginSection loginSection = new LoginSection();
    MainPage mainPage = new MainPage();
    MenuSection menuSection = new MenuSection();


    @BeforeEach
    public void openBrowser(){
        Session.getSession().getBrowser().get("https://todo.ly/");
    }

    @AfterEach
    public void closeBrowser(){
        Session.getSession().closeSession();
    }


    @Test
    @Order(1)
    @Owner("JBGroup")
    @Epic("Login")
    @Feature("Authentication")
    @Story("Login")
    @DisplayName("Verify login is successful")
    @Description("This test case is to verify that the user can login successfully")
    @Link(name="test case manual", url="jira/123123")
    @Issue("DEF12312313")
    @Severity(SeverityLevel.BLOCKER)
    public void loginTestSuccessfully(){
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText("zap@20255.com");
        loginSection.passwordTextBox.setText("12345");
        loginSection.loginButton.click();
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "Logout button is not displayed");
    }

}
