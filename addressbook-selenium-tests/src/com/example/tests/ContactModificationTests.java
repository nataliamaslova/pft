package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

/**
 * Created by nataliamaslova on 8/3/2014.
 */
public class ContactModificationTests extends TestBase {

    @Test(dataProvider = "randomValidContactGenerator")
    public void modifySomeContact(ContactData contact) {
        app.navigateTo().mainPage();

        // save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        // actions
        app.getContactHelper().modifyContact(contact, index);
//        app.getContactHelper().initContactModification(index);
//        contact.withFirstName("Natalia")
//                .withLastName("Maslova")
//                .withMobilePhone("+380509997755")
//                .withEmail("maslova.nd@gmail.com");
//        app.getContactHelper()
//                .fillContactForm(contact)
//                .submitContactModification();
//        app.navigateTo().mainPage();

        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        // compare states
        oldList.remove(index);
        oldList.add(contact);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

}
