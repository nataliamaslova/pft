/**
 * Created by nataliamaslova on 7/26/2014.
 */
package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();

        // save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        // actions
        app.getGroupHelper().initGroupCreation();
        GroupData group = new GroupData();
        group.name = "tea";
        group.footer = "footer 1";
        group.header = "header 1";
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().gotoGroupsPage();

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        // compare states
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

    @Test
    public void testEmptyGroupCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();

        // save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        // actions
        app.getGroupHelper().initGroupCreation();
        GroupData group = new GroupData("", "", "");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().gotoGroupsPage();

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        // compare states
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

}

