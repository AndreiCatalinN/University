package com.lab9;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;
public class Control {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Screen s = new Screen("Lab9");
		
		
	}
	
	public void part1(){
		ArrayList  <Person> persons  = new ArrayList();
		Scanner keyboard = new Scanner(System.in);
		String fname, sname, city;
		for(int i=0;i<3 ; i++)
		{
			out.println("Input person " + (i+1));
			out.println("First name: ");
			fname = keyboard.nextLine();
			
			out.println("Surname: ");
			sname = keyboard.nextLine();
			
			out.println("City: ");
			city = keyboard.nextLine();
			
			persons.add(new Person(fname, sname, city));
		}
		
		for(int i = 0 ;i<3 ; i++)
			out.println(persons.get(i));
	}

}
