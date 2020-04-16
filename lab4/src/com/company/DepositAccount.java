package com.company;
import static java.lang.System.out;

public class DepositAccount extends Account {
    private double interestRate;
    //Constructor
    public DepositAccount(String accName, String SortCode, String brName, double accBalance, double interestRate) {
    	super(accName, SortCode, brName, accBalance);
    	this.interestRate = interestRate;
    }
    
    //Setters and getters
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    
    public double getInterestRate() {
        return interestRate;
    }

    //Others
    @Override
    public String toString() {
        String s = super.toString() + "\nInterest Rate: ";
        s += getInterestRate();
        return s;
    }
    
    public void withdraw(double takeAmount) {
        out.println("You cannot withdraw from a deposit account");
    }
    
    public void getDetails() {
    	out.println("Account type: Deposit" );
    	out.println("Account Name: " + super.getAccountName() );
    	out.println("Account Balance: " + super.getacctBalance() );
    }
  
    public void valuableAccount() {
    	out.println("Account Balance: " + super.getacctBalance() );
    }
}