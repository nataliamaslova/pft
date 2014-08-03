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
        app.getGroupHelper().deleteGroup(1);
        app.getNavigationHelper().gotoGroupsPage();
    }
}
