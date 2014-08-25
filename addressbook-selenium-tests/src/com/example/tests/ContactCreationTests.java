package com.example.tests;

/**
 * Created by nataliamaslova on 7/27/2014.
 */

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test(dataProvider = "randomValidContactGenerator")
    public void testContactCreationWithValidData(ContactData contact) throws Exception {
        // save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

        // actions
        app.getContactHelper().createContact(contact);

        //save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

        // compare states
        assertThat(newList, equalTo(oldList.withAdded(contact)));
    }

}

