/****************************************
*   Control: Main class, made to play with other classes
*   		Use of polimorphism, inheritance, interfaces
*   Author: Andrei Negura
*   Date: 15/02/2018
*   test values 
*   For employee:
*   "Ion", "Ion", 13, 50000
*   For hourly employee:	
*   							
*   "Andrei Negura de CoCo", "1234456","Main branch", 150000000
*   "Valentin Negura", "2345", "Leixlip branch", 100000, 1
*   "Andrei Negura", "1234456","Main branch", 150000000, 0
*****************************************/
package com.company;

import static java.lang.System.out;
public class Main {
    public static void main(String[] args) {
		Account acc = new Account("Andrei Negura de CoCo", "1234456","Main branch", 150000000);
		DepositAccount dep= new DepositAccount("Valentin Negura", "2345", "Leixlip branch", 100000, 1);
		CurrentAccount curr = new CurrentAccount("Andrei Apetri", "1233456","IFSC branch", 150000000, 0);
		out.println(acc+ "\n");
		acc.valuableAccount();
		
		out.println("\n" + dep + "\n");
		dep.getDetails();
		
		out.println("\n" + curr + "\n");
		
		acc.setAccountName("Andrei Negura al Francilor");
		acc.getDetails();
		
		acc.deposit(500000);
		curr.withdraw(1000000);
		curr.valuableAccount();
		
		curr.getDetails();
		
		out.println(acc.getAccountNumber() +"\n "+dep.getAccountNumber()+ "\n"+curr.getAccountNumber()+ "\n" );
		
    }
}