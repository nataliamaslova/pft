/**
 * Created by nataliamaslova on 7/26/2014.
 */
package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {

    @Test(dataProvider = "randomValidGroupGenerator")
    public void testGroupCreationWithValidData(GroupData group) throws Exception {
        // save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        // actions
        app.getGroupHelper().createGroup(group);

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        // compare states
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

}

