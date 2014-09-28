package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by nataliamaslova on 7/27/2014.
 */
public class TestBase {
     protected Logger log = Logger.getLogger("TEST");

    protected ApplicationManager app;

    @BeforeTest
    public void setUp() throws Exception {
        String configFile = System.getProperty("configFile", "application.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(new File(configFile)));
        log.info("setUp start");
        app = ApplicationManager.getInstance(properties);
        app.setProperties(properties);
        log.info("setUp end");
    }

    @AfterTest
    public void tearDown() throws Exception {
        log.info("tearDown start");
        app.getHelperWithWebDriverBase().stop();
        log.info("tearDown end");
    }

}
