package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

/**
 * Created by nataliamaslova on 8/3/2014.
 */
public class ContactRemovalTests extends TestBase {

    @Test
    public void deleteSomeContact() {
        app.getNavigationHelper().openMainPage();

        // save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        // actions
        app.getContactHelper().deleteContact(index);
        app.getNavigationHelper().openMainPage();

        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        // compare states
        Collections.sort(oldList);
        oldList.remove(index);
        assertEquals(newList, oldList);
    }

}
