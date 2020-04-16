/****************************************
*   Control: Main class, made to play with other classes
*   Author: Andrei Negura
*   Date: 01/02/2018
*   test values 
*   "Spot", "dog", -1, true,"brown"
*   "Leo"
*   
*****************************************/

package com.lab2.test;

import java.util.Scanner;

public class Control 
{

	public static void main(String[] args) 
	{
		//Create objects
		Animal S = new Animal("Spot", "Dog", 12, true,"brown");
		Animal L = new Animal("Leo", "Cat", 13, true,"brown");
		Animal A = new Animal("Furry", "Wolf", 20, false,"brown");
		Animal B = new Animal("Fluffy", "Bear", 7, false,"brown");
		//Print them
		A.makeNoise();
		B.makeNoise(true);
		System.out.println(S);
		System.out.println(L);
		
		//With input!
		Scanner inp = new Scanner(System.in);
		//Name
		System.out.print("Name: ");
		S.setName( inp.nextLine() );
		//Breed
		System.out.print("Breed: ");
		S.setBreed(inp.nextLine());
		//Color
		System.out.print("Color: ");
		S.setColour(inp.nextLine());
		//Age
		System.out.print("Age: ");
		S.setAge(inp.nextInt());
		
		//Domesticated
		System.out.print("Domesticated: ");
		S.setDomesticated(inp.nextBoolean());
		
		
		
		System.out.println(S);
		
	}

}
