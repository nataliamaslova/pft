package com.example.tests;

public class ContactData implements Comparable<ContactData> {
    private String firstName;
    private String lastName;
    private String address;
    private String mobilePhone;
    private String email;
    private String dateBirth;
    private String monthBirth;
    private String yearBirth;
    private String groupName;

    public ContactData() {
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setMonthBirth(String monthBirth) {
        this.monthBirth = monthBirth;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setYearBirth(String yearBirth) {
        this.yearBirth = yearBirth;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                ", dateBirth='" + dateBirth + '\'' +
                ", monthBirth='" + monthBirth + '\'' +
                ", yearBirth='" + yearBirth + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactData)) return false;

        ContactData that = (ContactData) o;

        if (!lastName.equals(that.lastName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return lastName.hashCode();
    }

    @Override
    public int compareTo(ContactData other) {
        return this.getLastName().toLowerCase().compareTo(other.getLastName().toLowerCase());
    }

}
