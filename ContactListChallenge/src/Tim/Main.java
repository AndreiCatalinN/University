package Tim;

import java.util.Scanner;

public class Main {
    private static Scanner keyboard = new Scanner(System.in);
    private static Phone ph = new Phone("0871238797");
    public static void main(String[] args) {

        char option = '0';
        boolean turnedOn = true;
        options();
        while(turnedOn) {

            switch (option){
                case '1': {
                    //turn off program
                    System.out.println("Turning off");
                    turnedOn = false;
                    break;
                }
                case '2': {
                    //get contacts list
                    System.out.println("Contact list");
                    ph.getContacts();
                    break;
                }
                case '3': {
                    //add new contact
                    System.out.println("Add new contact");
                    ph.setContact( );
                    break;
                }
                case '4': {
                    //update existing contact
                    ph.updateContact();
                    break;
                }
                case '5': {
                    //remove contact

                    break;
                }
                case '6': {
                    //search contact

                    break;
                }
                case '7': {
                    //print menu
                    options();
                    break;
                }
                default:{
                    //error catcher
                    System.out.println("Wrong Input");
                    break;
                }

            }
        }
    }

    private static void options(){
        System.out.println("1. Quit");
        System.out.println("2. Print Contacts");
        System.out.println("3. Add new Contact");
        System.out.println("4. Update Contact");
        System.out.println("5. Remove Contact");
        System.out.println("6. Search Contact");
        System.out.println("7. Print Options again");
        System.out.println("Enter your option: ");
    }
}
