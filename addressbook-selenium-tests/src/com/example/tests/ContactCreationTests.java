package com.example.tests;

/**
 * Created by nataliamaslova on 7/27/2014.
 */

import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

    @Test(dataProvider = "randomValidContactGenerator")
    public void testContactCreationWithValidData(ContactData contact) throws Exception {
        // save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        // actions
        app.getContactHelper().createContact(contact);

        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        // compare states
        oldList.add(contact);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

}

