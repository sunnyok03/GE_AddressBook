package com.address_book;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Address Book.");

        HashMap<String,Contact> addressBook = new HashMap<>();

        while(true){
            System.out.println("Press 1 to add new contact.");
            System.out.println("Press 2 to print details by providing name.");
            System.out.println("Press 3 to exit.");

            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch){
                case 1:
                    addNewContact(addressBook);
                    System.out.println("----Added a new Contact.----");
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter full name: ");
                    String name = sc.nextLine();
                    System.out.println(addressBook.get(name));

                case 3:
                    System.out.println("Exiting program.");
                    return;

                default:
                    System.out.println("Invalid input.");
                    break;
            }

        }
    }

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


}
