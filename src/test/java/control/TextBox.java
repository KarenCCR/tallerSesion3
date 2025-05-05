package control;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TextBox extends Control{

    public TextBox(By locator, String controlName) {
        super(locator, controlName);
    }

    public void setText(String value){
        findControl();
        control.clear();
        control.sendKeys(value);
        this.allureStep("Set text in " + controlName + " to [" + value + "]");
    }

    public void setTextEnter(String value){
        findControl();
        control.clear();
        control.sendKeys(value + Keys.ENTER);
        this.allureStep("Set text in " + controlName + " to [" + value + "]");
    }
}
