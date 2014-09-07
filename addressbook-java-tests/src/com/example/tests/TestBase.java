package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * Created by nataliamaslova on 7/27/2014.
 */
public class TestBase {

    protected ApplicationManager app;

    @BeforeTest
    public void setUp() throws Exception {
        String configFile = System.getProperty("configFile", "application.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(new File(configFile)));
        app = ApplicationManager.getInstance();
    }

    @AfterTest
    public void tearDown() throws Exception {
        app.stop();
    }

/*
    @DataProvider
    public Iterator<Object[]> randomValidGroupGenerator() {
        return wrapGroupsForDataProvider(generateRandomGroups(5)).iterator();
    }
*/

    public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
        List<Object[]> list = new ArrayList<Object[]>();
        for (GroupData group: groups) {
            list.add(new Object[]{group});
        }
        return list;
    }

    public static List<Object[]> wrapContactsForDataProvider(List<ContactData> contacts) {
        List<Object[]> list = new ArrayList<Object[]>();
        for (ContactData contact: contacts) {
            list.add(new Object[]{contact});
        }
        return list;
    }

    public static String generateRandomString() {
        Random rnd = new Random();
        if (rnd.nextInt(3) == 0) {
            return "";
        } else {
            return "test" + rnd.nextInt();
        }
    }

    public static String generateRandomInt(int i) {
        Random rnd = new Random();
        return String.valueOf(rnd.nextInt(i));
    }

    public static String generateRandomMonth() {
        Random rnd = new Random();
        int i = rnd.nextInt(12);
        String month = "";
        switch (i) {
            case 0: {
                month = "January";
                break;
            }
            case 1: {
                month = "February";
                break;
            }
            case 2: {
                month = "March";
                break;
            }
            case 3: {
                month = "April";
                break;
            }
            case 4: {
                month = "May";
                break;
            }
            case 5: {
                month = "June";
                break;
            }
            case 6: {
                month = "July";
                break;
            }
            case 7: {
                month = "August";
                break;
            }
            case 8: {
                month = "September";
                break;
            }
            case 9: {
                month = "October";
                break;
            }
            case 10: {
                month = "November";
                break;
            }
            case 11: {
                month = "December";
                break;
            }
            default:
                month = "";
        }
        return month;
    }

    @DataProvider
    public Iterator<Object[]> randomValidContactGenerator() {
        List<Object[]> list = new ArrayList<Object[]>();
        for (int i = 0; i < 5; i++) {
            ContactData contact = new ContactData()
                    .withFirstName(generateRandomString())
                    .withLastName(generateRandomString())
                    .withAddress(generateRandomString())
                    .withMobilePhone(generateRandomString())
                    .withEmail(generateRandomString())
                    .withDateBirth(generateRandomInt(31))
                    .withMonthBirth(generateRandomMonth())
                    .withYearBirth(generateRandomInt(2010));
            list.add(new Object[]{contact});
        }
        return list.iterator();
    }

}
