package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by nataliamaslova on 8/3/2014.
 */
public class ContactRemovalTests extends TestBase {

    @Test
    public void deleteSomeContact() {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().deleteContact(1);
        app.getNavigationHelper().openMainPage();
    }

}
