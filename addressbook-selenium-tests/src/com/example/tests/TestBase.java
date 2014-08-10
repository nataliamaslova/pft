package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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

    @DataProvider
    public Iterator<Object[]> randomValidGroupGenerator() {
        List<Object[]> list = new ArrayList<Object[]>();

        for (int i = 0; i < 5; i++) {
            GroupData group = new GroupData();
            group.name = generateRandomString();
            group.header = generateRandomString();
            group.footer = generateRandomString();
            list.add(new Object[]{group});
        }
        return list.iterator();
    }

    private String generateRandomString() {
        Random rnd = new Random();
        if (rnd.nextInt(3) == 0) {
            return "";
        } else {
            return "test" + rnd.nextInt();
        }

    }

}
