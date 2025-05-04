package session;

import factoryBrowser.FactoryBrowser;
import org.openqa.selenium.WebDriver;

public class Session {
    private static Session session = null;
    private WebDriver browser;
    private Session(){
        browser = FactoryBrowser.make("proxy").create();
    }

    public static Session getSession(){
        if (session == null)
            session = new Session();
        return session;
    }

    public WebDriver getBrowser() {
        return browser;
    }

    public void closeSession(){
        browser.quit();
        session = null;
    }
}
