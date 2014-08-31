/**
 * Created by nataliamaslova on 7/26/2014.
 */
package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

//import static com.example.tests.GroupDataGenerator.generateRandomGroups;

public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> groupsFromFile() throws IOException {
        return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
    }

    @Test(dataProvider = "groupsFromFile")
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

