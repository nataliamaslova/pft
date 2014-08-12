package com.example.fw;

import com.example.tests.ContactData;
import org.openqa.selenium.By;

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
        click(By.xpath("//table/tbody/tr[" + (index + 2) + "]/td[7]/a/img"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void deleteContact(int index) {
        initContactModification(index);
        click(By.xpath("//input[@value=\"Delete\"]"));
    }

    public List<ContactData> getContacts() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        int quantity = driver.findElements(By.name("entry")).size();
        for (int index = 0; index < quantity; index++) {
            selectContactByIndex(index);
            ContactData contact = new ContactData();
            String firstName = driver.findElement(By.name("firstname")).getAttribute("value");
            String lastName = driver.findElement(By.name("lastname")).getAttribute("value");
            String address = driver.findElement(By.name("address")).getAttribute("value");
            String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
            String email = driver.findElement(By.name("email")).getAttribute("value");
            String birthDay = driver.findElement(By.name("bday")).getAttribute("value");
            String birthMonth = driver.findElement(By.name("bmonth")).getAttribute("value");
            String birthYear = driver.findElement(By.name("byear")).getAttribute("value");
            contact.setFirstName(firstName);
            contact.setLastName(lastName);
            contact.setAddress(address);
            contact.setMobilePhone(mobile);
            contact.setEmail(email);
            contact.setDateBirth(birthDay);
            contact.setMonthBirth(birthMonth);
            contact.setYearBirth(birthYear);

            contacts.add(contact);
            manager.getNavigationHelper().openMainPage();

//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        return contacts;
    }
}
