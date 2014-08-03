package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by nataliamaslova on 7/27/2014.
 */
public class TestBase {

    protected ApplicationManager app;

    @BeforeClass
    public void setUp() throws Exception {
        app = new ApplicationManager();
    }

    @AfterClass
    public void tearDown() throws Exception {
        app.stop();
    }

}
