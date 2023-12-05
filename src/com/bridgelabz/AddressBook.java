package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
@desc: Address Book is used to store the details of different member
and can be accessed and deleted by their full name
 */
public class AddressBook {
    private String addressBookId;
    private final ArrayList<Contact> contacts;

    private final HashMap<String,List<Contact>> cityContacts;
    private final HashMap<String,List<Contact>> stateContacts;

    public AddressBook(String addressBookId){
        this.addressBookId = addressBookId;
        this.contacts = new ArrayList<>();
        this.cityContacts = new HashMap<>();
        this.stateContacts = new HashMap<>();
    }

    public void setAddressBookId(String addressBookId){
        this.addressBookId = addressBookId;
    }

    public String getAddressBookId(){
        return addressBookId;
    }

    /*
    @desc: features to query on an address book
    @params:
    @return:
     */
    public void addressBookFunctionalities() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Address Book " + this.addressBookId + "...");

        while(true){
            System.out.println("Press 1 to add new contact.");
            System.out.println("Press 2 to print details by providing name.");
            System.out.println("Print 3 to print complete address book.");
            System.out.println("Press 4 to edit details by providing name.");
            System.out.println("Press 5 to delete details by providing name.");
            System.out.println("Press 6 to print contacts with same city.");
            System.out.println("Press 7 to print contacts with same state.");
            System.out.println("Press 8 to exit.");
            System.out.println("----------------------------------------------");

            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            switch (ch){
                case 1:
                    addNewContact();
                    break;

                case 2:
                    showDetail();
                    break;

                case 3: // print complete address book
                    for(Contact contact : contacts){
                        System.out.println(contact);
                    }
                    break;

                case 4:
                    editDetails();
                    break;

                case 5:
                   deleteDetails();
                    break;

                case 6:
                    sameCity();
                    break;

                case 7:
                    sameState();
                    break;

                case 8:
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
    public void addNewContact(){
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

        Contact newContact = new Contact(firstName,lastName,address,city,state,phoneNo,emailID);
        if(contacts.stream().anyMatch(contact -> contact.getFullName().equals(newContact.getFullName()))){
            System.out.println("-----Contact already there.-----");
            return;
        }
        
        contacts.add(newContact);
        if(cityContacts.get(newContact.getCity()) == null){
            List<Contact>temp = new ArrayList<>();
            temp.add(newContact);
            cityContacts.put(newContact.getCity(),temp);
        }else{
            cityContacts.get(newContact.getCity()).add(newContact); // adding new contact to cityContacts
        }
        if(stateContacts.get(newContact.getState()) == null){
            List<Contact>temp = new ArrayList<>();
            temp.add(newContact);
            stateContacts.put(newContact.getState(),temp);
        }else{
            stateContacts.get(newContact.getState()).add(newContact);// adding new contact to stateContacts
        }
        System.out.println("----Added a new Contact.----");
    }


    /*
    @desc:Edit details of a single contact by providing full name
    @params:addressBook
    @return:
     */
    public void editDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter full name to edit details: ");
        String fullName = sc.nextLine();

        for (int i=0;i<contacts.size();i++) {
            Contact contact = contacts.get(i);
            String oldFullName = contact.getFirstName() + " " + contact.getLastName();
            if (oldFullName.equals(fullName)) {
                contacts.remove(contact); // remove the old detail
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
                    boolean closeLoop = false;
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
                            closeLoop = true;
                            break;

                        default:
                            System.out.println("Invalid input.");
                            break;
                    }

                    if(closeLoop){
                        break;
                    }
                }
                // new details added
                contacts.add(contact);
            }
        }
    }


    /*
    @desc:Enter details to delete a single contact by providing full name
    @params:addressBook,fullName
    @return:
     */
    public void deleteDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter full name to delete details: ");
        String fullName = sc.nextLine();
        for(Contact contact:contacts){
            String oldFullName = contact.getFirstName()+" "+contact.getLastName();
            if(oldFullName.equals(fullName)){
                contacts.remove(contact);
                break;
            }
        }
        System.out.println("Details deleted.");
    }

        /*
     @desc:Enter details to show a single contact by providing full name
     @params:addressBook
     @return:
      */
    public void showDetail(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter full name to display details: ");
        String name = sc.nextLine();
        for(Contact contact:contacts){
            if(contact.getFullName().equals(name)){
                System.out.println(contact);
                break;
            }
        }
    }


    /*
    @desc: prints all the contact in current address book with given city name
    @params:
    @return:
     */
    public void sameCity(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter city name to search: ");
        String cityName = sc.next();
        if(cityContacts.get(cityName).isEmpty()){
            System.out.println("-----No contact in given city.-----");
        }else{
            System.out.println("Contacts in given city are: ");
            cityContacts.get(cityName).forEach(System.out::println);
        }
    }

        /*
    @desc: prints all the contact in current address book with given state name
    @params:
    @return:
     */
    public void sameState(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter state name to search: ");
        String stateName = sc.next();
        List<Contact> sameStateContacts = contacts.stream().filter(
                contact -> contact.getState().equals((stateName))).toList();
        if(sameStateContacts.isEmpty()){
            System.out.println("-----No contact in given state.-----");
        }else{
            System.out.println("Contacts in given state are: ");
            sameStateContacts.forEach(System.out::println);
        }
    }
}
