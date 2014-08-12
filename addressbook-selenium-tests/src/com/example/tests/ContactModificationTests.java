package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by nataliamaslova on 8/3/2014.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void modifySomeContact() {
        app.getNavigationHelper().openMainPage();
        int index = 0;

        // save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        // actions
        app.getContactHelper().initContactModification(index);
        ContactData contact = new ContactData();
        contact.setFirstName(oldList.get(index).getFirstName());
        contact.setLastName(oldList.get(index).getLastName());
        contact.setAddress("Saint-Petersburg, Smolenskaya Street 21");
        contact.setMobilePhone(oldList.get(index).getMobilePhone());
        contact.setEmail(oldList.get(index).getEmail());
        contact.setDateBirth(oldList.get(index).getDateBirth());
        contact.setMonthBirth(oldList.get(index).getMonthBirth());
        contact.setYearBirth(oldList.get(index).getYearBirth());
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().openMainPage();

        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        // compare states
        oldList.remove(index);
        oldList.add(contact);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

}
