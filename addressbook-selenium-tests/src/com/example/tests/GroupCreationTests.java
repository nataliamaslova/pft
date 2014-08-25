/**
 * Created by nataliamaslova on 7/26/2014.
 */
package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class GroupCreationTests extends TestBase {

    @Test(dataProvider = "randomValidGroupGenerator")
    public void testGroupCreationWithValidData(GroupData group) throws Exception {
        // save old state
        SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

        // actions
        app.getGroupHelper().createGroup(group);

        //save new state
        SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

        // compare states
        assertThat(newList, equalTo(oldList.withAdded(group)));
    }

}

