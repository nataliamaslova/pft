package com.example.fw;

import java.util.Properties;

/**
 * Created by nataliamaslova on 8/2/2014.
 */
public class ApplicationManager {

    private static ApplicationManager singleton;

    private Properties properties;
    private HibernateHelper hibernateHelper;
    private HelperWithWebDriverBase helperWithWebDriverBase;
    private AccountHelper accountHelper;
    private MailHelper mailHelper;
    private JamesHelper jamesHelper;

    public static ApplicationManager getInstance(Properties properties) {
        if (singleton == null) {
            singleton = new ApplicationManager();
            singleton.setProperties(properties);
            singleton.helperWithWebDriverBase = new HelperWithWebDriverBase(singleton);
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

    public HelperWithWebDriverBase getHelperWithWebDriverBase() {
        if (helperWithWebDriverBase == null) {
            helperWithWebDriverBase = new HelperWithWebDriverBase(this);
        }
        return helperWithWebDriverBase;
    }
}
