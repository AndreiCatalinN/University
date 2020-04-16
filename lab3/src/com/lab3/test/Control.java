/****************************************
*   Control: Main class, made to play with other classes
*   		Use of polimorphism, inheritance, arrays
*   Author: Andrei Negura
*   Date: 01/02/2018
*   test values 
*   For employee:
*   "Ion", "Ion", 13, 50000
*   For hourly employee:	
*   							hours	rate
*   "Andrei", "Andrei", 69, 0, 24.00, 9.55
*   For commission employee: 	
*   							comission
*   "Aion", "Ion", 23, 100000, 250000
*****************************************/


package com.lab3.test;

public class Control 
{
	public static void main(String[] args) 
	{
		//Single objects
		Employee e = new Employee( "Ion", "Ion", 13, 50000);
		HourlyEmployee e1 = new HourlyEmployee( "Andrei", "Andrei", 69, 0, 24.00, 10);
		CommissionEmployee e2 = new CommissionEmployee("Aion", "Ion", 23, 100000, 250000);
		
		//Printing first objects
		System.out.println( e + "\n\n" );
		System.out.println( e1 + "\n\n" );
		System.out.println( e2 );
		
		//Instantiate Employees array
		int somelength = 3;
		Employee[] Emp = new Employee[somelength];
		
		Emp[0] = new Employee("Ion", "Ion", 13, 50000);
		Emp[1] = new HourlyEmployee("Andrei", "Andrei", 69, 0, 24.00, 9.55);
		Emp[2] = new CommissionEmployee("Aion", "Ion", 23, 100000, 250000);
		//Division between results
		System.out.println("\n\n\n");
		
		//Print array object
		for( int i = 0; i < Emp.length; i++ )
			System.out.println("Monthly pay: " + Emp[i].calculatePay());
	}

}
