package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by nataliamaslova on 8/3/2014.
 */
public class ContactRemovalTests extends TestBase {

    @Test
    public void deleteSomeContact() {
        // save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        // actions
        app.getContactHelper().deleteContact(index);
        app.navigateTo().mainPage();

        //save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

        // compare states
        assertThat(newList, equalTo(oldList.without(index)));
    }

}
