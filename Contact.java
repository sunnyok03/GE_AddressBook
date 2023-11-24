package com.address_book;

public class Contact {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String phoneNo;
    String emailID;


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
}
