package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by nataliamaslova on 8/2/2014.
 */
public class GroupModificationTests extends TestBase {

    @Test
    public void modifySomeGroup() {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupHelper().initGroupModification(5);
        GroupData group = new GroupData();
        group.name = "new name";
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().gotoGroupsPage();
    }

}
