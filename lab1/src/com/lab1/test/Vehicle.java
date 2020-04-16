/****************************************
*   Control: Class for a vehicle, 
*   with 2 constructors
*   Author: Andrei Negura
*   Date: 25/01/2018
*   test values "Catalin", "123qa", 200, "Green", true, 4
*****************************************/
package com.lab1.test;

public class Vehicle 
{
	private String o_name;
	private String registration_num;
	private int max_speed;
	private String color;
	private boolean automatic;
	private int no_of_wheels;
	
	public Vehicle(String name)
	{
		this.o_name = name;
	}
	
	public Vehicle(String o_name, String registration_num, int max_speed, String color, boolean automatic, int no_of_wheels) 
	{
		this.o_name = o_name;
		this.registration_num = registration_num;
		this.max_speed = max_speed;
		this.color = color;
		this.automatic = automatic;
		this.no_of_wheels = no_of_wheels;
	}
	
	public String toString()
	{
		String s ="";
		s = s + "Owner: " + o_name + " Registration number: " + registration_num;
		s = s + " Maximum Speed: " + max_speed + " Color: " + color + " Automatic gear: ";
		s = s + " Wheels: " + no_of_wheels;
		
		return s;
	}
	
}
