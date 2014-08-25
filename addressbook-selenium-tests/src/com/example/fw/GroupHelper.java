package com.example.fw;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by nataliamaslova on 8/2/2014.
 */
public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    private SortedListOf<GroupData> cachedGroups;

    public SortedListOf<GroupData> getGroups() {
       if (cachedGroups == null) {
           rebuildCache();
       }
       return cachedGroups;
    }

    private void rebuildCache() {
        cachedGroups = new SortedListOf<GroupData>();

        manager.navigateTo().groupsPage();
        List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
        for (WebElement checkbox: checkboxes) {
            String title = checkbox.getAttribute("title");
            String name = title.substring("Select(".length() + 1, title.length() - ")".length());
            cachedGroups.add(new GroupData().withName(name));
        }
    }

    public GroupHelper createGroup(GroupData group) {
        manager.navigateTo().groupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
        rebuildCache();
        return this;
    }

    public GroupHelper modifyGroup(int index, GroupData group) {
        initGroupModification(index);
        fillGroupForm(group);
        submitGroupModification();
        returnToGroupsPage();
        rebuildCache();
        return this;
    }

    public GroupHelper deleteGroup(int index) {
        selectGroupByIndex(index);
        submitGroupDeletion();
        returnToGroupsPage();
        rebuildCache();
        return this;
    }

    //---------------------------------------------------------------------------------------------

    public void returnToGroupsPage() {
        click(By.linkText("groups"));
    }

    public GroupHelper initGroupCreation() {
        click(By.name("new"));
        return this;
    }

    public GroupHelper fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
        return this;
    }

    private GroupHelper selectGroupByIndex(int index) {
        click(By.xpath("//input[@name='selected[]'][" + (index + 1) + "]"));
        return this;
    }

    public GroupHelper initGroupModification(int index) {
        selectGroupByIndex(index);
        click(By.name("edit"));
        return this;
    }

    private GroupHelper submitGroupCreation() {
        click(By.name("submit"));
        cachedGroups = null;
        return this;
    }

    private GroupHelper submitGroupModification() {
        click(By.name("update"));
        cachedGroups = null;
        return this;
    }

    private GroupHelper submitGroupDeletion() {
        click(By.name("delete"));
        cachedGroups = null;
        return this;
    }

}
