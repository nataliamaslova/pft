/**
 * Created by nataliamaslova on 7/26/2014.
 */
package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        app.navigationHelper.openMainPage();
        app.navigationHelper.gotoGroupsPage();
        app.groupHelper.initGroupCreation();
        GroupData groupData = new GroupData();
        groupData.name = "group 1";
        groupData.footer = "footer 1";
        groupData.header = "header 1";
        app.groupHelper.fillGroupForm(groupData);
        app.groupHelper.submitGroupCreation();
        app.navigationHelper.gotoGroupsPage();
    }

    @Test
    public void testEmptyGroupCreation() throws Exception {
        app.navigationHelper.openMainPage();
        app.navigationHelper.gotoGroupsPage();
        app.groupHelper.initGroupCreation();
        app.groupHelper.fillGroupForm(new GroupData("", "", ""));
        app.groupHelper.submitGroupCreation();
        app.navigationHelper.gotoGroupsPage();
    }

}

