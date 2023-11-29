package com.bridgelabz;


/*
    @desc:This class is to represent single
    entity contact of address book
    @params:
    @return:
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    /*
    @desc: print a single contact in string format
    @params:
    @return: String formatted object
     */
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
