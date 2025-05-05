package testSuite;



import pages.LoginSectionTodoIst;
import session.Session;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;


public class LoginTestTodois {

    private LoginSectionTodoIst loginSection; // Instance of the class handling login

    @BeforeEach
    public void openBrowser() {
        // Initialize the LoginSection instance with the active session
        loginSection = new LoginSectionTodoIst(Session.getSession().getBrowser());

        // Navigate to the Todoist page
        Session.getSession().getBrowser().get("https://www.todoist.com/es");
    }

    @AfterEach
    public void closeBrowser() {
        // Close the browser session after each test
        Session.getSession().closeSession();
    }

    @Test
    @Order(3)
    @Owner("JBGroup")
    @Epic("Login")
    @Feature("Authentication")
    @Story("Complete Flow")
    @DisplayName("Verify complete flow for registration and login")
    @Description("This test case verifies the complete flow of registration and login on Todoist")
    @Severity(SeverityLevel.BLOCKER)
    public void logintesttodosisTest() {
        // Step 1: Click on "Iniciar sesión"
        loginSection.clickLoginLink();

        // Step 2: Click on "Regístrate"
        loginSection.clickRegisterLink();

        // Step 3: Enter email for registration
        loginSection.registerEmailTextBox("operadornotificaciones.karen@gmail.com");

        // Step 4: Enter password for registration
        loginSection.registerPasswordTextBox("12345678!!!BBa");

        // Step 5: Click on button "Regístrate"
        loginSection.setButtonRegisterLink();

        // Step 6: Verify the error message
        Assertions.assertTrue(
                loginSection.setVerifyRegister(),
                "Expected error message 'Esta direcci'"
        );

        // Step 7: Click on button "Iniciar sesión" after verifying the error message
        loginSection.clickbuttondirecional();

        // Step 8: Enter email for login
        loginSection.registerEmailTextBoxValidado("operadornotificaciones.karen@gmail.com");

        // Step 9: Enter password for login
        loginSection.registerPasswordValidadoTextBox("12345678!!!BBa");

        // Step 10: Click on button "Iniciar sesión Final"
        loginSection.Finish();
    }
}