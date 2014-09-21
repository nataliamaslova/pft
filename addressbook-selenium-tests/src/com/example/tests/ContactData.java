package com.example.tests;

public class ContactData implements Comparable<ContactData> {

    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String mobilePhone;
    private String email;
    private String dateBirth;
    private String monthBirth;
    private String yearBirth;

    public ContactData() {
    }


    public String getId() {
        return id;
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

    public void setYearBirth(String yearBirth) {
        this.yearBirth = yearBirth;
    }

    public void setId(String id) {
        this.id = id;
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

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
        return this;
    }

    public ContactData withMonthBirth(String monthBirth) {
        this.monthBirth = monthBirth;
        return this;
    }

    public ContactData withYearBirth(String yearBirth) {
        this.yearBirth = yearBirth;
        return this;
    }
}
