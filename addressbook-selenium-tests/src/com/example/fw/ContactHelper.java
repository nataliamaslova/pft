package com.example.fw;

import com.example.tests.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
        click(By.xpath("//table//tr[" + (index + 2) + "]/td[7]//img"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void deleteContact(int index) {
        initContactModification(index);
        click(By.xpath("//input[@value=\"Delete\"]"));
        delayInMs(200);
    }

    public List<ContactData> getContacts() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> rows = getContactRows(By.name("entry"));
        for (WebElement row : rows) {
            ContactData contact = new ContactData();
            contact.setLastName(row.findElement(By.xpath(".//td[2]")).getText());
            contact.setFirstName(row.findElement(By.xpath(".//td[3]")).getText());
            contact.setEmail(row.findElement(By.xpath(".//td[4]")).getText());
            contact.setMobilePhone(row.findElement(By.xpath(".//td[5]")).getText());
            contacts.add(contact);
        }
        return contacts;
    }

    private List<WebElement> getContactRows(By by) {
        return findElements(by);
    }

}
