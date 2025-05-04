package pages;

import control.Button;
import control.TextBox;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSectionTodoIst {

    private WebDriver driver;

    public LoginSectionTodoIst(WebDriver driver) {
        this.driver = driver;
    }

    // Selectors with descriptions
    public Button loginLink = new Button(By.xpath("(//a[contains(@href, '/auth/login') and .//span[contains(text(),'Iniciar')]])[1]"), "[Login Link] button in TodoIst");
    public Button registerLink = new Button(By.xpath("(//a[contains(@href, '/auth/signup')])[1]"), "[Register Link] button in TodoIst");

    public void registerEmailTextBox(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@type='email' and contains(@placeholder, 'email')]")));
        emailField.sendKeys(email);
    }

    public void registerPasswordTextBox(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@type='password' and contains(@placeholder, 'contr')]")));
        passwordField.sendKeys(password);
    }

    public void setButtonRegisterLink() {
        WebElement button = driver.findElement(By.xpath("//button[span[contains(text(), 'Registrarme con mi email')]]"));
        button.click();
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public void clickRegisterLink() {
        registerLink.click();
    }

    public boolean setVerifyRegister() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[contains(text(), 'Esta direcci')]")));
            return errorMessage != null && errorMessage.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickbuttondirecional() {
        WebElement button = driver.findElement(By.xpath("//a[contains(text(), 'Inicia sesi')]"));
        button.click();
    }

    public void registerEmailTextBoxValidado(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@type='email' and contains(@placeholder, 'email')]")));
        emailField.sendKeys(email);
    }

    public void registerPasswordValidadoTextBox(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@type='password']")));
        if (passwordField.isEnabled()) {
            passwordField.sendKeys(password);
        } else {
            System.out.println("El campo de contraseña no está habilitado.");
        }
    }

    public void Finish() {
        WebElement button = driver.findElement(By.xpath("//button[@class='fb8d74bb _8c75067a F9gvIPl rWfXb_e _3930afa0 _7ea1378e _2d084671']"));
        button.click();
    }
}