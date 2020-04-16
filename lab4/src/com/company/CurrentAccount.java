package com.company;
import static java.lang.System.out;

public class CurrentAccount extends Account {
    private double penaltyAmount;
    
    //Constructors 
    public CurrentAccount(String accName, String SortCode, String brName,double accBalance, double penaltyAmount){
    	super(accName, SortCode, brName, accBalance);
    	this.penaltyAmount = penaltyAmount;
    }
    
    //Setters and getters
    public void setPenaltyAmount(double penaltyAmount){
        this.penaltyAmount = penaltyAmount;
    }

    public double getPenaltyAmount(){
        return penaltyAmount;
    }

    //Others
    @Override
    public String toString() {
        return super.toString() + "\nPenalty amount: " + penaltyAmount;
    }

    public void withdraw(double takeAmount)
    {
        if (super.getacctBalance() < 0 )
        	out.println("Insufficient funds");
        else super.withdraw(takeAmount);
    }

    public String checkCredit()
    {
        if (super.getinCredit())
            return "The account is in credit";
       return "The account is not in credit";
    }
    
    public void checkCredit(String warningMessage)
    {
        double ch = super.getacctBalance();
        if ( ch > 0 && ch < 100)
            out.println(warningMessage);
    }
    
    public void getDetails()
    {
    	out.println("Account type: Current" );
    	out.println("Account Name: " + super.getAccountName() );
    	out.println("Account Balance: " + super.getacctBalance() );
    }
  
    public void valuableAccount()
    {
    	out.println("Account Balance: " + super.getacctBalance() );
    }
    
}