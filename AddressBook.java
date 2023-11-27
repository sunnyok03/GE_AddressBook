package com.address_book;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
@desc: Address Book is used to store the details of different member
and can be accessed and deleted by their full name
 */
public class AddressBook {
    HashMap<String,Contact>addressBook = new HashMap<>();

    /*
    @desc: features to query on an address book
    @params:
    @return:
     */
    public void addressBookFunctionalities(String addressBookName) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Address Book " + addressBookName + "...");

        while(true){
            System.out.println("Press 1 to add new contact.");
            System.out.println("Press 2 to print details by providing name.");
            System.out.println("Print 3 to print complete address book.");
            System.out.println("Press 4 to edit details by providing name.");
            System.out.println("Press 5 to delete details by providing name.");
            System.out.println("Press 6 to exit.");
            System.out.println("----------------------------------------------");

            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            switch (ch){
                case 1:
                    addNewContact(addressBook);
                    break;

                case 2:
                    showDetail(addressBook);
                    break;

                case 3: // print complete address book
                    for(Map.Entry<String,Contact> address : addressBook.entrySet()){
                        Contact contact = address.getValue();
                        System.out.println(contact);
                    }
                    break;

                case 4:
                    editDetails(addressBook);
                    break;

                case 5:
                   deleteDetails(addressBook);
                    break;

                case 6:
                    System.out.println("Exiting current address book.");
                    return;

                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
    }

    /*
    @desc:add a new contact to the address book
    @params: addressBook
    @return:
     */
    public void addNewContact(HashMap<String,Contact>addressBook){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter firstName: ");
        String firstName = sc.next();
        System.out.print("Enter lastName: ");
        String lastName = sc.next();
        System.out.print("Enter address: ");
        sc.nextLine(); // Consume the newline character left by previous next()
        String address = sc.nextLine();
        System.out.print("Enter city: ");
        String city = sc.next();
        System.out.print("Enter state: ");
        String state = sc.next();
        System.out.print("Enter phone number: ");
        String phoneNo = sc.next();
        System.out.print("Enter email ID: ");
        String emailID = sc.next();

        Contact contact = new Contact(firstName,lastName,address,city,state,phoneNo,emailID);
        addressBook.put(firstName+" "+lastName,contact);
        System.out.println("----Added a new Contact.----");
    }


    /*
    @desc:Edit details of a single contact by providing full name
    @params:addressBook
    @return:
     */
    public void editDetails(HashMap<String,Contact>addressBook){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.print("Enter full name to edit details: ");
        String fullName = sc.nextLine();
        if(!addressBook.containsKey(fullName)){
            System.out.println("Contact with this name does not exist.");
            return;
        }

        Contact contact = addressBook.get(fullName);

        addressBook.remove(fullName); // remove the old detail

        while(true){
            System.out.println("Press 1 to change first name.");
            System.out.println("Press 2 to change last name.");
            System.out.println("Press 3 to change address.");
            System.out.println("Press 4 to change city.");
            System.out.println("press 5 to change state.");
            System.out.println("Press 6 to change phone number.");
            System.out.println("Press 7 to change email address.");
            System.out.println("Press 8 to exit.");

            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch(ch) {
                case 1:
                    System.out.print("Enter new first name: ");
                    String firstName = sc.next();
                    contact.setFirstName(firstName);
                    break;

                case 2:
                    System.out.print("Enter new last name: ");
                    String lastName = sc.next();
                    contact.setLastName(lastName);
                    break;

                case 3:
                    System.out.print("Enter new address: ");
                    sc.nextLine();
                    String address = sc.nextLine();
                    contact.setAddress(address);
                    break;

                case 4:
                    System.out.print("Enter new city: ");
                    String city = sc.next();
                    contact.setCity(city);
                    break;

                case 5:
                    System.out.print("Enter new state: ");
                    String state = sc.next();
                    contact.setState(state);
                    break;

                case 6:
                    System.out.print("Enter new phone number: ");
                    String phoneNumber = sc.next();
                    contact.setPhoneNo(phoneNumber);
                    break;

                case 7:
                    System.out.print("Enter new emailID: ");
                    String emailID = sc.next();
                    contact.setEmailID(emailID);
                    break;

                case 8:
                    System.out.println("Completing editing.");
                    return;

                default:
                    System.out.println("Invalid input.");
                    break;
            }

            // new details added
            addressBook.put(contact.getFirstName()+" "+contact.getLastName(),contact);
        }

    }


    /*
    @desc:Enter details to delete a single contact by providing full name
    @params:addressBook,fullName
    @return:
     */
    public void deleteDetails(HashMap<String,Contact>addressBook){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.print("Enter full name to delete details: ");
        String fullName = sc.nextLine();
        if(!addressBook.containsKey(fullName)){
            System.out.println("Name does not exist.");
            return;
        }

        addressBook.remove(fullName);
        System.out.println("Details deleted.");
    }

        /*
     @desc:Enter details to show a single contact by providing full name
     @params:addressBook
     @return:
      */
    public void showDetail(HashMap<String,Contact>addressBook){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.print("Enter full name to display details: ");
        String name = sc.nextLine();
        System.out.println(addressBook.get(name)); // toString will be called in Contact class
    }

}
