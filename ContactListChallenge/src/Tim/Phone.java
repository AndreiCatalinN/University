package Tim;

import java.util.ArrayList;

public class Phone{

    private ArrayList<Contacts> c;
    private String myNumber;

    public Phone(String num){
        myNumber = num;
        c = new ArrayList<Contacts>();
    }


    public void getContacts(){

        System.out.println("Contacts list");
        for ( int i = 0; i< c.size(); i++){
            System.out.println((i+1) +". "+ c.get(i).getName() +
                    " -- " + c.get(i).getPhoneNo() + " -- "
                    + c.get(i).getPhoto());
        }
    }

    public boolean setContact(Contacts contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already on file");
            return false;
        }
        c.add(contact);
        return true;
    }



    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int foundP = findContact(oldContact);
        if(foundP <0){
            System.out.println(oldContact.getName() + " was not found.");
            return false;
        }
        c.set(foundP, newContact);
        System.out.println(oldContact.getName() + " replaced with" + newContact.getName());
        return true;
    }

    private int findContact(String name){
        for (int i = 0; i<c.size();i++) {
            Contacts contact = c.get(i);
            if(contact.getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    private int findContact(Contacts search){
        return c.indexOf(search);
    }

}
