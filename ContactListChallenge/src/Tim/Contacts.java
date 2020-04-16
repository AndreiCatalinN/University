package Tim;

public class Contacts {
    private String name;
    private String phoneNo;
    private String photo;

    //Constructors
    //No photo provided
    public Contacts(String name, String phoneNo) {
        this( name, phoneNo, "default");
    }

    //No photo or name provided
    public Contacts( String phoneNo) {
        //use the number as name
        this(phoneNo, phoneNo, "default");
    }

    public Contacts(String name, String phoneNo, String photo) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.photo = photo;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getPhoto() {
        return photo;
    }

    //Others


    public static Contacts createContact(String name, String phone, String ph){
        return new Contacts(name, phone, ph);
    }

}
