package com.example.fw;

import com.beust.jcommander.internal.Lists;
import com.example.tests.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nataliamaslova on 8/2/2014.
 */
public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void deleteGroup(int index) {
        selectGroupByIndex(index);
        click(By.name("delete"));
    }

    private void selectGroupByIndex(int index) {
        click(By.xpath("//input[@name='selected[]'][" + index + "]"));
    }

    public void initGroupModification(int index) {
        selectGroupByIndex(index);
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public List<GroupData> getGroups() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
        for (WebElement checkbox: checkboxes) {
            GroupData group = new GroupData();
            String title = checkbox.getAttribute("title");
            group.name = title.substring("Select(".length() + 1, title.length()-")".length());
            groups.add(group);
        }
        return groups;
    }
}
