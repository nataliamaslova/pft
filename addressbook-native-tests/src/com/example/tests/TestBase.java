package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.*;
import org.testng.annotations.Optional;

import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by nataliamaslova on 7/27/2014.
 */
public class TestBase {

    protected Logger log = Logger.getLogger("TEST");

    protected ApplicationManager app;

    @BeforeClass
    @Parameters({"configFile"})
    public void setUp(@Optional String configFile) throws Exception {
        if (configFile == null) {
            configFile = System.getProperty("configFIle");
        }
        if (configFile == null) {
            configFile = System.getenv("configFIle");
        }
        if (configFile == null) {
            configFile = "application.properties";
        }
        Properties properties = new Properties();
        properties.load(new FileReader((configFile)));
        log.info("setUp start");
        app = ApplicationManager.getInstance(properties);
        log.info("setUp end");
    }

    @AfterTest
    public void tearDown() throws Exception {
        log.info("tearDown start");
        ApplicationManager.getInstance(null).stop();
        log.info("tearDown end");
    }

}
