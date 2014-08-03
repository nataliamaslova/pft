package com.example.fw;

import com.example.tests.ContactData;
import org.openqa.selenium.By;

/**
 * Created by nataliamaslova on 8/2/2014.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("email"), contactData.getEmail());
        selectByText(By.name("bday"), contactData.getDateBirth());
        selectByText(By.name("bmonth"), contactData.getMonthBirth());
        type(By.name("byear"), contactData.getYearBirth());
        selectByText(By.name("new_group"), contactData.getGroupName());
    }

    public void initContactModification(int index) {
        selectContactByIndex(index);
    }

    private void selectContactByIndex(int index) {
        click(By.xpath("//table/tbody/tr[" + (1 + index) + "]/td[7]/a/img"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void deleteContact(int index) {
        initContactModification(index);
        click(By.xpath("//input[@value=\"Delete\"]"));
    }
}
