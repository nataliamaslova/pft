package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by nataliamaslova on 8/2/2014.
 */
public class GroupRemovalTests extends TestBase {

    @Test
    public void deleteSomeGroup() {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();
        for (int i = 1000; i < 2000; i++) {
            app.getGroupHelper().deleteGroup(i);
        }
        app.getNavigationHelper().gotoGroupsPage();
    }
}
