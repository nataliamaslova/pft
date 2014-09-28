package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by nataliamaslova on 9/28/2014.
 */
public class HelperWithWebDriverBase {

    protected ApplicationManager manager;
    protected WebDriver driver;
    private WebDriverWait wait;

    public HelperWithWebDriverBase(ApplicationManager manager) {
        this.manager = manager;
        String browser = manager.getProperty("browser");
        if ("firefox".equals(browser)) {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            driver = new FirefoxDriver(capabilities);
        } else if ("chrome".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", "src/resources/browserdrivers/chromedriver");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            driver = new ChromeDriver(capabilities);
        } else if ("ie".equals(browser)) {
            System.setProperty("webdriver.ie.driver", "src/resources/browserdrivers/IEDriverServer");
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            driver = new InternetExplorerDriver(capabilities);
        } else {
            throw new Error("Unsupported browser: " + browser);
        }
        String baseUrl = manager.getProperty("baseUrl");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
        wait = new WebDriverWait(driver, 10);
    }

    protected void openUrl(String string) {
        driver.get(manager.getProperty("baseUrl") + string);
    }

    protected void openAbsoluteUrl(String string) {
        driver.get(string);
    }

    protected void type(By locator, String text) {
        if (text != null) {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void selectByText(By locator, String text) {
        if (text != null) {
            new Select(driver.findElement(locator)).selectByVisibleText(text);
        }
    }

    protected WebElement findElement(By by) {
        return driver.findElement(by);
    }

    protected List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    protected void delayInMs(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        driver.close();
    }

    protected void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
