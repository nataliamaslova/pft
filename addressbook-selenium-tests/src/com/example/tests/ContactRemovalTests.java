package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by nataliamaslova on 8/3/2014.
 */
public class ContactRemovalTests extends TestBase {

    @Test
    public void deleteSomeContact() {
        app.getNavigationHelper().openMainPage();
        int index = 0;

        // save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        // actions
        app.getContactHelper().deleteContact(index);
        app.getNavigationHelper().openMainPage();

        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        // compare states
        oldList.remove(index);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

}
