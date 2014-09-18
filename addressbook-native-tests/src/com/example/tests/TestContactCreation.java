package com.example.tests;

import com.example.fw.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by nataliamaslova on 9/14/2014.
 */
public class TestContactCreation extends TestBase {

    @Test
    public void shouldCreateContactWithValidData() throws InterruptedException {
        Contact contact = new Contact().setFirstName("tester").setLastName("tester");
        app.getContactHelper().createContact(contact);
        Contact createdContact = app.getContactHelper().getFirstContact();
        Assert.assertEquals(contact, createdContact);
        Thread.sleep(5000);
    }
}
