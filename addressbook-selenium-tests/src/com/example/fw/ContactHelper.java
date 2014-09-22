package com.example.fw;

import com.example.tests.ContactData;
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

    private SortedListOf<ContactData> contactsFromUI;

    public SortedListOf<ContactData> getContactsFromDB() {
        if (cachedContacts == null) {
            rebuildCacheOnDB();
        }
        return cachedContacts;
    }

    public void rebuildCacheOnDB() {
        cachedContacts = new SortedListOf<ContactData>(manager.getHibernateHelper().listContacts());
    }

    public SortedListOf<ContactData> getContactsFromUIMainPage() {
        contactsFromUI = new SortedListOf<ContactData>();

        manager.navigateTo().mainPage();
        List<WebElement> rows = getContactRows(By.name("entry"));
        for (WebElement row : rows) {
            ContactData contact = new ContactData()
                    .withLastName(row.findElement(By.xpath(".//td[2]")).getText())
                    .withFirstName(row.findElement(By.xpath(".//td[3]")).getText())
                    .withEmail(row.findElement(By.xpath(".//td[4]")).getText())
                    .withMobilePhone(row.findElement(By.xpath(".//td[5]")).getText());
            contactsFromUI.add(contact);
        }
        return contactsFromUI;
    }

    public SortedListOf<ContactData> getContactsFromUIEditForm() {
        contactsFromUI = new SortedListOf<ContactData>();

        manager.navigateTo().mainPage();
        int rows = getContactRows(By.name("entry")).size();
        for (int index = 0; index < rows; index++) {
            findElement(By.xpath("//table//tr[" + (index + 2) + "]/td[7]//img")).click();
            delayInMs(500);
            ContactData contact = new ContactData()
                    .withFirstName(findElement(By.name("firstname")).getAttribute("value"))
                    .withLastName(findElement(By.name("lastname")).getAttribute("value"))
                    .withAddress(findElement((By.name("address"))).getText())
                    .withMobilePhone(findElement(By.name("mobile")).getAttribute("value"))
                    .withEmail(findElement(By.name("email")).getAttribute("value"))
                    .withDateBirth(findElement(By.name("bday")).getAttribute("value"))
                    .withMonthBirth(findElement(By.name("bmonth")).getAttribute("value"))
                    .withYearBirth(findElement(By.name("byear")).getAttribute("value"));
            contactsFromUI.add(contact);
            manager.navigateTo().mainPage();
        }
        return contactsFromUI;
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
