/**
 * Created by nataliamaslova on 7/26/2014.
 */
package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupHelper().initGroupCreation();
        GroupData groupData = new GroupData();
        groupData.name = "group 1";
        groupData.footer = "footer 1";
        groupData.header = "header 1";
        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().gotoGroupsPage();
    }

    @Test
    public void testEmptyGroupCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().gotoGroupsPage();
    }

}

