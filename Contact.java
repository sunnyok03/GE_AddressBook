package com.address_book;


/*
This class is to represent single
 entity contact of address book
 */
public class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String phoneNo;
    private String emailID;


    public Contact(String firstName, String lastName,
                   String address, String city,
                   String state, String phoneNo, String emailID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phoneNo = phoneNo;
        this.emailID = emailID;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", emailID='" + emailID + '\'' +
                '}';
    }
}
