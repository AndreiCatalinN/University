/****************************************
*   Control: Main class, made to play with other classes
*   Author: Andrei Negura
*   Date: 25/01/2018
*   test values 
*   "Catalin", "123qa", 200, "Green", true, 4
*****************************************/

package com.lab1.test;

public class Control 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Vehicle car = new Vehicle("Catalin", "1233qa", 201, "Green", true, 4);
		Vehicle BMW = new Vehicle("Catalin", "1234qa", 202, "Blue", false, 4);
		Vehicle lexus = new Vehicle("Catalin", "1235qa", 203, "Red", true, 2);
		Vehicle cars = new Vehicle("Car");
		System.out.println("Hello world");
		System.out.println(car);
		System.out.println(BMW);
		System.out.println(lexus);
		System.out.println(cars);
	}
}

