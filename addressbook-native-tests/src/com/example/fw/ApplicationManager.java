package com.example.fw;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * Created by nataliamaslova on 8/2/2014.
 */
public class ApplicationManager {

    private static ApplicationManager singleton;

    private Properties properties;
    private ContactHelper contactHelper;
    private ProcessHelper processHelper;
    private AutoItHelper autoItHelper;

    public static ApplicationManager getInstance(Properties properties) throws IOException {
        if (singleton == null) {
            singleton = new ApplicationManager();
            singleton.setProperties(properties);
            singleton.start();
        }
        return singleton;
    }

    public void start() throws IOException {
        getProcessHelper().startAppUnderTest();
    }

    public void stop() {
        getProcessHelper().stopAppUnderTest();
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getProperty(String key, String defaultVakue) {
        return properties.getProperty(key, defaultVakue);
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public ProcessHelper getProcessHelper() {
        if (processHelper == null) {
            processHelper = new ProcessHelper(this);
        }
        return processHelper;
    }

    public ContactHelper getContactHelper() {
        if (contactHelper == null) {
            contactHelper = new ContactHelper(this);
        }
        return contactHelper;
    }

    public AutoItHelper getAutoItHelper() {
        if (autoItHelper == null) {
            autoItHelper = new AutoItHelper(this);
        }
        return autoItHelper;
    }

}
