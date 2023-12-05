package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
@desc: address book system where we can store new address books and apply queries.
@params:
@return:
 */

public class AddressBookSystem {

    ArrayList<AddressBook> addressBooks; // storing all address books in the system

    public AddressBookSystem(){
        addressBooks = new ArrayList<>();
    }

    public void addressBookSystemFunctionalities() {

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
                    addNewAddressBook();
                    break;

                case 2:
                    listAllAddressBook();
                    break;

                case 3:
                    editAddressBookName();
                    break;

                case 4:
                    deleteAddressBookName();
                    break;

                case 5:
                    goToAddressBook();
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
    public void addNewAddressBook(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of the new address book: ");
        String name = sc.next();
        AddressBook addressBook = new AddressBook(name);
        addressBooks.add(addressBook);
    }


    /*
    @desc: list all address books available in the system
    @params: (addressBookSystem) hashmap of the address book system
    @return:
     */
    public void listAllAddressBook(){
        for (AddressBook addressBook : addressBooks) {
            System.out.println(addressBook.getAddressBookId());
        }
    }

    /*
    @desc: edit name of the address book
    @params: (addressBookSystem) hashmap of the address book system
    @return:
     */
    public void editAddressBookName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter old name of address book: ");
        String oldName = sc.next();
        if(addressBooks.stream().noneMatch(addressBook -> addressBook.getAddressBookId().equals(oldName))){
            System.out.println("Address book does not exist.");
        }else{
            System.out.print("Enter new name of address book: ");
            String newName = sc.next();
            addressBooks.forEach(addressBook -> {
                if(addressBook.getAddressBookId().equals(oldName)){
                    addressBook.setAddressBookId(newName);
                }
            });
            System.out.println("New name updated as "+ newName + ".");
        }
    }

    /*
    @desc: delete the address book with given name
    @params: (addressBookSystem) hashmap of the address book system
    @return:
     */
    public void deleteAddressBookName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of address book to delete: ");
        String name = sc.next();
        if(addressBooks.stream().noneMatch(addressBook -> addressBook.getAddressBookId().equals(name))){
            System.out.println("Address book does not exist.");
        }else{
            addressBooks.removeIf(addressBook -> addressBook.getAddressBookId().equals(name));
            System.out.println(name + " deleted.");
        }
    }

    /*
    @desc: to apply queries on one single address book
    @params: (addressBookSystem) hashmap of the address book system
    @return:
     */
    public void goToAddressBook(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of address book you want to open: ");
        String name = sc.next();
        if(addressBooks.stream().noneMatch(addressBook -> addressBook.getAddressBookId().equals(name))){
            System.out.println("Invalid address book.");
        }else{
            addressBooks.stream().filter(addressBook -> addressBook.getAddressBookId().equals(name)).forEach(AddressBook::addressBookFunctionalities);
        }
    }
}
