package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by nataliamaslova on 8/2/2014.
 */
public class GroupModificationTests extends TestBase {

    @Test
    public void modifySomeGroup() {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();

        // save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        // actions
        app.getGroupHelper().initGroupModification(0);
        GroupData group = new GroupData();
        group.name = "new name";
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().gotoGroupsPage();

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        // compare states
        oldList.remove(0);
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

}
