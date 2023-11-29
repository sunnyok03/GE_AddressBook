package com.bridgelabz;

import java.util.HashMap;
import java.util.Scanner;

/*
@desc: address book system where we can store new address books and apply queries.
@params:
@return:
 */

public class AddressBookSystem {

    public static void main(String[] args) {
        HashMap<String,AddressBook>addressBookSystem = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Address book system...");

        while(true){
            System.out.println("Press 1 to add new Address book.");
            System.out.println("Press 2 to list all the address book.");
            System.out.println("Press 3 to edit name of the address book.");
            System.out.println("Press 4 to delete a address book.");
            System.out.println("Press 5 to go to address book by name.");
            System.out.println("Press 6 to exit.");
            System.out.println("----------------------------------------");

            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            String name;
            switch (ch){
                case 1:
                    addNewAddressBook(addressBookSystem);
                    break;

                case 2:
                    listAllAddressBook(addressBookSystem);
                    break;

                case 3:
                    editAddressBookName(addressBookSystem);
                    break;

                case 4:
                    deleteAddressBookName(addressBookSystem);
                    break;

                case 5:
                    goToAddressBook(addressBookSystem);
                    break;

                case 6:
                    System.out.println("Exiting Program.");
                    return;

                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }

    }


    /*
    @desc: Add new addressBook in the system
    @params:
    @return:
    */
    public static void addNewAddressBook(HashMap<String,AddressBook>addressBookSystem){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of the new address book: ");
        String name = sc.next();
        addressBookSystem.put(name,new AddressBook());
    }


    /*
    @desc: list all address books available in the system
    @params: (addressBookSystem) hashmap of the address book system
    @return:
     */
    public static void listAllAddressBook(HashMap<String,AddressBook>addressBookSystem){
        for(String addressName : addressBookSystem.keySet()){
            System.out.println(addressName);
        }
    }

    /*
    @desc: edit name of the address book
    @params: (addressBookSystem) hashmap of the address book system
    @return:
     */
    public static void editAddressBookName(HashMap<String,AddressBook>addressBookSystem){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter old name of address book: ");
        String oldName = sc.next();
        if(!addressBookSystem.containsKey(oldName)){
            System.out.println("Address book does not exist.");
        }else{
            System.out.print("Enter new name of address book: ");
            String newName = sc.next();
            addressBookSystem.put(newName,addressBookSystem.get(oldName));
            addressBookSystem.remove(oldName);
            System.out.println("New name updated as "+ newName + ".");
        }
    }

    /*
    @desc: delete the address book with given name
    @params: (addressBookSystem) hashmap of the address book system
    @return:
     */
    public static void deleteAddressBookName(HashMap<String,AddressBook>addressBookSystem){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of address book to delete: ");
        String name = sc.next();
        if(!addressBookSystem.containsKey(name)){
            System.out.println("Address book does not exist.");
        }else{
            addressBookSystem.remove(name);
            System.out.println(name + " deleted.");
        }
    }
    /*
    @desc: to apply queries on one single address book
    @params: (addressBookSystem) hashmap of the address book system
    @return:
     */

    public static void goToAddressBook(HashMap<String,AddressBook>addressBookSystem){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of address book you want to open: ");
        String name = sc.next();
        if(!addressBookSystem.containsKey(name)){
            System.out.println("Invalid address book.");
        }else{
            addressBookSystem.get(name).addressBookFunctionalities(name);
        }
    }
}
