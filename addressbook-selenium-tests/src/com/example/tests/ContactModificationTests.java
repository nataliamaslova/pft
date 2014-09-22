package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by nataliamaslova on 8/3/2014.
 */
public class ContactModificationTests extends TestBase {

    @Test(dataProvider = "randomValidContactGenerator")
    public void modifySomeContact(ContactData contact) {
        // save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContactsFromDB();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        // actions
        app.getContactHelper().modifyContact(contact, index);

        //save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContactsFromUIEditForm();

        System.out.println("newList get from UI = " + newList);

        System.out.println("oldList get from DB = " + oldList);

        // compare states
        assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
    }

}
