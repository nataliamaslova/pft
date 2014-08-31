package com.example.tests;

import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.tests.TestBase.*;

/**
 * Created by nataliamaslova on 8/31/2014.
 */
public class ContactDataGenerator {
    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            System.out.println("Please specify parameters: <amount of test data> <file> <format>");
            return;
        }

        int amount = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        String format = args[2];

        if (file.exists()) {
            System.out.println("File exists, please remove it manually");
            return;
        }

        List<ContactData> contacts = generateRandomContacts(amount);
        if ("csv".equals(format)) {
            saveContactsToCsvFile(contacts, file);
        } else if ("xml".equals(format)) {
            saveContactsToXmlFile(contacts, file);
        } else {
            System.out.println("Unknown format " + format);
        }
        return;
    }

    private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.alias("contact", GroupData.class);
        String xml = xstream.toXML(contacts);
        FileWriter writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (ContactData contact: contacts) {
            writer.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getAddress() + ","
                    + contact.getMobilePhone() + "," + contact.getEmail() + "," + contact.getDateBirth() + ","
                    + contact.getMonthBirth() + "," + contact.getYearBirth() + ",!" + "\n");
        }
        writer.close();
    }

    private static List<ContactData> generateRandomContacts(int amount) {
        List<ContactData> list = new ArrayList<ContactData>();
        for (int i = 0; i < amount; i++) {
            ContactData contact = new ContactData()
                    .withFirstName(generateRandomString())
                    .withLastName(generateRandomString())
                    .withAddress(generateRandomString())
                    .withMobilePhone(generateRandomString())
                    .withEmail(generateRandomString())
                    .withDateBirth(generateRandomInt(31))
                    .withMonthBirth(generateRandomMonth())
                    .withYearBirth(generateRandomInt(2010));

            list.add(contact);
        }
        return list;
    }
}
