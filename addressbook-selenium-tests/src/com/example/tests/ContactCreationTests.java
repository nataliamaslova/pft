package com.example.tests;

/**
 * Created by nataliamaslova on 7/27/2014.
 */

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreationWithValidData() throws Exception {
        app.getNavigationHelper().openMainPage();

        // save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        // actions
        app.getNavigationHelper().gotoContactPage();
        ContactData contact = new ContactData();
        contact.setFirstName("Alexander");
        contact.setLastName("Dumchikov");
        contact.setAddress("Ukraine\nKiev\nRadishcsheva Street 5");
        contact.setMobilePhone( "+380507775577");
        contact.setEmail("dumchikoff@ukr.net");
        contact.setDateBirth("17");
        contact.setMonthBirth("July");
        contact.setYearBirth("1980");
        contact.setGroupName("group 1");
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().gotoHomePage();

        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        // compare states
        oldList.add(contact);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

}

