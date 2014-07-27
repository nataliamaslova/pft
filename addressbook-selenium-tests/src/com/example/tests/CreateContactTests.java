package com.example.tests;

/**
 * Created by nataliamaslova on 7/27/2014.
 */

import org.testng.annotations.Test;

public class CreateContactTests extends TestBase {

    @Test
    public void testUntitled() throws Exception {
        openMainPage();
        gotoContactPage();
        ContactData contactData = new ContactData();
        contactData.firstName = "Alexander";
        contactData.lastName = "Dumchikov";
        contactData.address = "Ukraine\nKiev\nRadishcsheva Street 5";
        contactData.mobilePhone = "+380507775577";
        contactData.email = "dumchikoff@ukr.net";
        contactData.dateBirth = "17";
        contactData.monthBirth = "July";
        contactData.yearBirth = "1980";
        contactData.groupName = "group 1";
        fillContactForm(contactData);
        submitContactCreation();
        gotoHomePage();
    }

}

