package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

/**
 * Created by nataliamaslova on 8/2/2014.
 */
public class GroupModificationTests extends TestBase {

    @Test(dataProvider = "randomValidGroupGenerator")
    public void modifySomeGroup(GroupData group) {
        // save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        // actions
        app.getGroupHelper().modifyGroup(index, group);

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        // compare states
        oldList.remove(index);
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

}
