package com.example.tests;

public class ContactData {
    public String firstName;
    public String lastName;
    public String address;
    public String mobilePhone;
    public String email;
    public String dateBirth;
    public String monthBirth;
    public String yearBirth;
    public String groupName;

    public ContactData() {
    }

    public ContactData(String firstName, String lastName, String address, String mobilePhone, String email, String dateBirth, String monthBirth, String yearBirth, String groupName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.dateBirth = dateBirth;
        this.monthBirth = monthBirth;
        this.yearBirth = yearBirth;
        this.groupName = groupName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public String getMonthBirth() {
        return monthBirth;
    }

    public String getYearBirth() {
        return yearBirth;
    }

    public String getGroupName() {
        return groupName;
    }
}
