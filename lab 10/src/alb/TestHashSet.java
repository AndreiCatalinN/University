package alb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestHashSet {
    private String[] contryes = new String[]{"Albania", "Andorra", "Austria", "Belarus", "Belgium",
            "Bosnia Herzegovina", "Bulgaria", "Croatia", "Cyprus", "Czech Republic",
            "Denmark",  "Estonia",  "Hungary", "Iceland", "Ireland", "Italy", "Kosovo",
            "Latvia", "Liechtenstein", "Lithuania", "Luxemburg", "Macedonia", "Malta",
            "Moldova", "Monaco", "Montenegro", "Norway", "Poland", "Portugal",
            "Romania", "Russia", "San Marino", "Serbia", "Slovakia", "Slovenia",
            "Spain", "Sweden", "Switzerland", "Netherlands", "the United Kingdom",
            "Turkey", "Ukraine"};
    private ArrayList <String> con;
    //Constructor
    public TestHashSet() {
        con = new ArrayList<String>();
        for (int i=0;i<contryes.length;i++)
            con.add(contryes[i]);
    }
    //Prints
    public void printSet(){
        for(int i=0;i<con.size();i++)
            System.out.println(con.get(i));
    }

    public void addEntry(String country){
        con.add(country);
    }
    public void matchEntry(String Country){
            if(con.contains(Country))
                System.out.println("It does contain " + Country );
            else System.out.println("It does not contain " + Country );
    }
    public void clearSet() {
        con.clear();
    }
    public void sortSet(){
        Collections.sort(con);
    }
    public void reverseSet(){
        Collections.sort(con, Collections.reverseOrder());
    }
    public void shuffleSet(){
        Collections.shuffle(con);
    }
}
