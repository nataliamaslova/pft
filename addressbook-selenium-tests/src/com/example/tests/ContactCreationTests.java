package com.example.tests;

/**
 * Created by nataliamaslova on 7/27/2014.
 */

import com.example.utils.SortedListOf;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import static com.example.tests.ContactDataGenerator.loadContactsFromXml;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

//import static com.example.tests.ContactDataGenerator.loadContactsFromCsv;

public class ContactCreationTests extends TestBase {
    @DataProvider
    public Iterator<Object[]> contactsFromFile() throws IOException {
        return wrapContactsForDataProvider(loadContactsFromXml(new File("contacts.xml"))).iterator();
    }

    @Test(dataProvider = "contactsFromFile")
    public void testContactCreationWithValidData(ContactData contact) throws Exception {
        // save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContactsFromDB();

        // actions
        app.getContactHelper().createContact(contact);

        //save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContactsFromUIMainPage();

        // compare states
        assertThat(newList, equalTo(oldList.withAdded(contact)));
    }

}

