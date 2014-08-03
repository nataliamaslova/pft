package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by nataliamaslova on 8/3/2014.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void modifySomeContact() {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactModification(1);
        ContactData contact = new ContactData();
        contact.address = "Saint-Petersburg, Smolenskaya Street 21";
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().openMainPage();
    }

}
