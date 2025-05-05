package control;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

public class Control {

    protected By locator;
    protected WebElement control;
    protected String controlName;

    public Control(By locator, String controlName){
        this.locator = locator;
        this.controlName = controlName;
    }

    public void findControl(){
        control = Session.getSession().getBrowser().findElement(locator);
    }

    @Step("{0}")
    public void allureStep(String action){}


    public void click(){
        findControl();
        control.click();
        this.allureStep("Click on " + controlName);
    }

    public boolean isControlDisplayed(){
        boolean isDisplayed =Session.getSession().getBrowser().findElements(locator).size() > 0;
        this.allureStep("Is this control: " + controlName+" displayed? [" + isDisplayed + "]");
        return isDisplayed;
    }
}
