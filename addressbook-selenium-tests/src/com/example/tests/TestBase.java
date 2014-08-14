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

    public String generateRandomString() {
        Random rnd = new Random();
        if (rnd.nextInt(3) == 0) {
            return "";
        } else {
            return "test" + rnd.nextInt();
        }
    }

    @DataProvider
    public Iterator<Object[]> randomValidContactGenerator() {
        List<Object[]> list = new ArrayList<Object[]>();
        for (int i = 0; i < 5; i++) {
            ContactData contact = new ContactData();
            contact.setFirstName(generateRandomString());
            contact.setLastName(generateRandomString());
            contact.setAddress(generateRandomString());
            contact.setMobilePhone(generateRandomString());
            contact.setEmail(generateRandomString());
            contact.setDateBirth(generateRandomInt(31));
            contact.setMonthBirth(generateRandomMonth());
            contact.setYearBirth(generateRandomInt(2010));
            list.add(new Object[]{contact});
        }
        return list.iterator();
    }

    private String generateRandomInt(int i) {
        Random rnd = new Random();
        return String.valueOf(rnd.nextInt(i));
    }

    private String generateRandomMonth() {
        Random rnd = new Random();
        int i = rnd.nextInt(12);
        String month = "";
        switch (i) {
            case 0: {month = "January"; break;}
            case 1: {month = "February"; break;}
            case 2: {month = "March"; break;}
            case 3: {month = "April"; break;}
            case 4: {month = "May"; break;}
            case 5: {month = "June"; break;}
            case 6: {month = "July"; break;}
            case 7: {month = "August"; break;}
            case 8: {month = "September"; break;}
            case 9: {month = "October"; break;}
            case 10: {month = "November"; break;}
            case 11: {month = "December"; break;}
            default: month = "";
        }
        return month;
    }
}
