package com.example.fw;

import java.util.Properties;

/**
 * Created by nataliamaslova on 8/2/2014.
 */
public class ApplicationManager {

    private static ApplicationManager singleton;

    private Properties properties;
    private HibernateHelper hibernateHelper;
    private WebDriverHelper webDriverHelper;
    private AccountHelper accountHelper;

    public static ApplicationManager getInstance() {
        if (singleton == null) {
            singleton = new ApplicationManager();
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

    public void stop() {
        if (webDriverHelper != null) {
            webDriverHelper.stop();
        }
    }

    public WebDriverHelper getWebDriverHelper() {
        if (webDriverHelper == null) {
            webDriverHelper = new WebDriverHelper(this);
        }
        return webDriverHelper;
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

}
