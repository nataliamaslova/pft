/**
 * Created by nataliamaslova on 7/26/2014.
 */
package com.example.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class AlsoGroupCreationTests extends TestBase {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        openMainPage();
        gotoGroupsPage();
        initGroupCreation();
        GroupData groupData = new GroupData();
        groupData.name = "group 1";
        groupData.footer = "footer 1";
        groupData.header = "header 1";
        fillGroupForm(groupData);
        submitGroupCreation();
        gotoGroupsPage();
    }

    @Test
    public void testEmptyGroupCreation() throws Exception {
        openMainPage();
        gotoGroupsPage();
        initGroupCreation();
        fillGroupForm(new GroupData("", "", ""));
        submitGroupCreation();
        gotoGroupsPage();
    }

}

