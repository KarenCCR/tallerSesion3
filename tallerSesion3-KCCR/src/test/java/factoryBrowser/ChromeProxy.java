package factoryBrowser;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ChromeProxy implements IBrowser{
    @Override
    public WebDriver create() {

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("localhost:9199"); //<-------- HOST: PORT  Owasp ZAP
        proxy.setSslProxy("localhost:9199");

        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.setProxy(proxy);
        chromeOptions.addArguments("--ignore-certificate-errors");

        ChromeDriver chrome = new ChromeDriver(chromeOptions);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        chrome.manage().window().maximize();
        return chrome;
    }
}
