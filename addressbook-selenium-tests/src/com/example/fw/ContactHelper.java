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

    public List<ContactData> getContacts() {
        List<ContactData> contacts = new ArrayList<ContactData>();

        manager.navigateTo().mainPage();
        List<WebElement> rows = getContactRows(By.name("entry"));
        for (WebElement row : rows) {
            ContactData contact = new ContactData()
                    .withLastName(row.findElement(By.xpath(".//td[2]")).getText())
                    .withFirstName(row.findElement(By.xpath(".//td[3]")).getText())
                    .withEmail(row.findElement(By.xpath(".//td[4]")).getText())
                    .withMobilePhone(row.findElement(By.xpath(".//td[5]")).getText());
            contacts.add(contact);
        }
        return contacts;
    }

    public ContactHelper createContact(ContactData contact) {
        manager.navigateTo().contactPage();
        fillContactForm(contact);
        submitContactCreation();
        return this;
    }

    public void modifyContact(ContactData contact, int index) {
        initContactModification(index);
        contact.withFirstName("Natalia")
                .withLastName("Maslova")
                .withMobilePhone("+380509997755")
                .withEmail("maslova.nd@gmail.com");
        fillContactForm(contact);
        submitContactModification();
    }

    public ContactHelper deleteContact(int index) {
        initContactModification(index);
        submitContactDeletion();
        return this;
    }

    //---------------------------------------------------------------------------------

    public ContactHelper fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("email"), contactData.getEmail());
        selectByText(By.name("bday"), contactData.getDateBirth());
        selectByText(By.name("bmonth"), contactData.getMonthBirth());
        type(By.name("byear"), contactData.getYearBirth());
        return  this;
    }

    public ContactHelper initContactModification(int index) {
        selectContactByIndex(index);
        return this;
    }

    public ContactHelper submitContactCreation() {
        click(By.name("submit"));
        return this;
    }

    public ContactHelper submitContactModification() {
        click(By.name("update"));
        return this;
    }

    private void submitContactDeletion() {
        click(By.xpath("//input[@value=\"Delete\"]"));
        delayInMs(200);
    }

    private void selectContactByIndex(int index) {
        click(By.xpath("//table//tr[" + (index + 2) + "]/td[7]//img"));
    }

    private List<WebElement> getContactRows(By by) {
        return findElements(by);
    }

}
