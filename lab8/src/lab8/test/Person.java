package lab8.test;

public class Person {
	
	//Attributes
	private String firstName;
	private String surName;
	private String gender;
	private Date dob;
	
	//Constructors
	Person(String firstName, String surName, String gender,
			Date dob){
		
		setName(firstName, surName);
		this.gender = gender;
		this.dob = dob;
	}
	//Setters and getters
	String getFirstName(){
		return firstName;
	}
	String getSurName(){
		return surName;
	}
	String getGender(){
		return gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob  = dob;
	}
	
	void setFirstName(String firstName){
		this.firstName = firstName;
	}
	void setSurName(String surName){
		this.surName = surName;
	}
	void setName(String firstN, String surN) {
		this.firstName = firstN;
		this.surName = surN;
		String name = firstN +" "+surN+ "\n";
		FileProcessing f= new FileProcessing("names.txt");
		f.fileWrite(name);
	}
	void setGender(String gender){
		this.gender = gender;
	}	
	
	//To string
	public String toString()
	{
		String s = "";
		s += "Name " + firstName +" "+surName +"\nDate of birth" 
				+ dob.toString()+ "\nGender: " + gender+ "\n";
		return s;
	}
}