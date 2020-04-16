package com.lab9;

public class Person {
	private String firstName;
	private String surName;
	private String city;
	
	public Person(String fName, String sName, String city) {
		this.setFirstName(fName);
		this.setSurName(sName);
		this.setCity(city);
	}

	// @return the firstName
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	// @return the surName
	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}


	// @return the city
	public String getCity() {
		return city;
	}

	
	// @param city the city to set
	public void setCity(String city) {
		this.city = city;
	}
	
	public String toString() {
		String s = "";
		
		s += "Name: "+ firstName +
				" "+ surName+" City: "+ city+ "\n";
		return s;
		
	}
	
}
