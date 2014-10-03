package com.example.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by nataliamaslova on 8/2/2014.
 */
public class ApplicationManager {

    private WebDriver driver;
    public String baseUrl;

    private static ApplicationManager singleton;

    private Properties properties;
    private HibernateHelper hibernateHelper;
    private AccountHelper accountHelper;
    private MailHelper mailHelper;
    private JamesHelper jamesHelper;

    public static ApplicationManager getInstance(Properties properties) {
        if (singleton == null) {
            singleton = new ApplicationManager();
            singleton.setProperties(properties);
            singleton.accountHelper = new AccountHelper(singleton);
            singleton.mailHelper = new MailHelper(singleton);
            singleton.jamesHelper = new JamesHelper(singleton);
        }
        return singleton;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public HibernateHelper getHibernateHelper() {
        if (hibernateHelper == null) {
            hibernateHelper = new HibernateHelper(this);
        }
        return hibernateHelper;
    }

    public AccountHelper getAccountHelper() {
        if (accountHelper == null) {
            accountHelper = new AccountHelper(this);
        }
        return accountHelper;
    }

    public MailHelper getMailHelper() {
        if (mailHelper == null) {
            mailHelper = new MailHelper(this);
        }
        return mailHelper;
    }

    public JamesHelper getJamesHelper() {
        if (jamesHelper == null) {
            jamesHelper = new JamesHelper(this);
        }
        return jamesHelper;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            String browser = properties.getProperty("browser");
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
            baseUrl = properties.getProperty("baseUrl");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(baseUrl);
        }
        return driver;
    }

    public void stop() {
        driver.quit();
    }
}
