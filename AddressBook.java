package com.address_book;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Address Book.");

        HashMap<String,Contact> addressBook = new HashMap<>();

        while(true){
            System.out.println("Press 1 to add new contact.");
            System.out.println("Press 2 to print details by providing name.");
            System.out.println("Print 3 to print complete address book.");
            System.out.println("Press 4 to edit details by providing name.");
            System.out.println("Press 5 to exit.");

            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            String name;
            switch (ch){
                case 1:
                    addNewContact(addressBook);
                    System.out.println("----Added a new Contact.----");
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter full name to display details: ");
                    name = sc.nextLine();
                    System.out.println(addressBook.get(name));
                    break;

                case 3:
                    for(Map.Entry<String,Contact> address : addressBook.entrySet()){
                        Contact contact = address.getValue();
                        System.out.println(contact);
                    }
                    break;

                case 4:
                    sc.nextLine();
                    System.out.print("Enter full name to edit details: ");
                    name = sc.nextLine();
                    editDetails(addressBook,name);
                    break;

                case 5:
                    System.out.println("Exiting program.");
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
    public static void addNewContact(HashMap<String,Contact>addressBook){
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
    }


    /*
    @desc:Edit details of a single contact by providing full name
    @params:addressBook, fullName
    @return:
     */
    public static void editDetails(HashMap<String,Contact>addressBook,String fullName){
        Scanner sc = new Scanner(System.in);
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
}
