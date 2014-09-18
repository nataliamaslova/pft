package com.example.fw;

/**
 * Created by nataliamaslova on 9/15/2014.
 */
public class ContactHelper extends HelpersBase {
    public ContactHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void createContact(Contact contact) {
        initContactCreation();
        fillContactForm(contact);
        confirmContactCreation();
    }

    private void initContactCreation() {
        manager.getAutoItHelper()
                .winWaitAndActivate("AddressBook Portable", "", 5000)
                .click("Add")
                .winWaitAndActivate("Add Contact", "", 5000);
    }

    private void fillContactForm(Contact contact) {
        manager.getAutoItHelper()
                .send("TDBEdit12", contact.getFirstName())
                .send("TDBEdit11", contact.getLastName());
    }

    private void confirmContactCreation() {
        manager.getAutoItHelper()
                .click("Save")
                .winWaitAndActivate("AddressBook Portable", "", 5000);
    }

    public Contact getFirstContact() {
        manager.getAutoItHelper()
                .winWaitAndActivate("AddressBook Portable", "", 5000)
                .click("TListView1")
                .send("{DOWN}{SPACE}")
                .click("Edit")
                .winWaitAndActivate("Update Contact", "", 5000);
        Contact contact = new Contact()
                .setFirstName(manager.getAutoItHelper().getText("TDBEdit12"))
                .setLastName(manager.getAutoItHelper().getText("TDBEdit11"));
        manager.getAutoItHelper().click("Cancel")
                .winWaitAndActivate("AddressBook Portable", "", 5000);
        return contact;
    }

    public void deleteFirstContact() {
        manager.getAutoItHelper()
                .winWaitAndActivate("AddressBook Portable", "", 5000)
                .click("TListView1")
                .send("{DOWN}{SPACE}")
                .click("Delete")
                .winWaitAndActivate("Confirm", "", 5000)
                .click("Edit")
                .winWaitAndActivate("AddressBook Portable", "", 5000);
    }
}
