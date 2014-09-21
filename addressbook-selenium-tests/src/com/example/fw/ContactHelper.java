package com.example.fw;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by nataliamaslova on 8/2/2014.
 */
public class ContactHelper extends WebDriverHelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    private SortedListOf<ContactData> cachedContacts;

    public SortedListOf<ContactData> getContacts() {
        if (cachedContacts == null) {
            rebuildCache();
        }
        return cachedContacts;
    }

    public void rebuildCache() {
        cachedContacts = new SortedListOf<ContactData>(manager.getHibernateHelper().listContacts());
    }

    public ContactHelper createContact(ContactData contact) {
        manager.navigateTo().contactPage();
        fillContactForm(contact);
        submitContactCreation();
        return this;
    }

    public ContactHelper modifyContact(ContactData contact, int index) {
        manager.navigateTo().mainPage();
        initContactModification(index);
        contact.withFirstName("Natalia")
                .withLastName("Maslova")
                .withMobilePhone("+380509997755")
                .withEmail("maslova.nd@gmail.com");
        fillContactForm(contact);
        submitContactModification();
        return this;
    }

    public ContactHelper deleteContact(int index) {
        manager.navigateTo().mainPage();
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
        delayInMs(200);
        cachedContacts = null;
        return this;
    }

    public ContactHelper submitContactModification() {
        click(By.name("update"));
        delayInMs(200);
        cachedContacts = null;
        return this;
    }

    private ContactHelper submitContactDeletion() {
        click(By.xpath("//input[@value=\"Delete\"]"));
        delayInMs(200);
        cachedContacts = null;
        return this;
    }

    private void selectContactByIndex(int index) {
        click(By.xpath("//table//tr[" + (index + 2) + "]/td[7]//img"));
        delayInMs(200);
    }

    private List<WebElement> getContactRows(By by) {
        return findElements(by);
    }

}
