package pages;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class LoginSection {

    public TextBox emailTextBox = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail"),"[Email] textbox in Login section");
    public TextBox passwordTextBox = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword"),"[Password] textbox in Login section");
    public Button loginButton = new Button(By.id("ctl00_MainContent_LoginControl1_ButtonLogin"),"[Login] button in Login section");
}
