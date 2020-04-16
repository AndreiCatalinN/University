package com.company;
import static java.lang.System.out;

class Account implements ValidatedAccount {
    private String accountName;
    private int accountNumber;
    private String SortCode;
    private String branchName;
    private boolean inCredit = true;
    private double acctBalance;
    private static int currentNumber = 1;
	
    //Constructors
    Account(String accName, String SortCode, String brName, double accBalance){
    	this.accountName = accName;
    	setAccountNumber();
    	this.SortCode = SortCode;
    	this.branchName = brName;
    	setAcctBalance(accBalance);
    }

    //setters
    void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    void setAccountNumber() {
        this.accountNumber = currentNumber++;
    }
    
    void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }
    
    void setSortCode(String SortCode){
        this.SortCode = SortCode;
    }
    
    void setBranchName(String branchName){
        this.branchName = branchName;
    }
    
    void setInCredit(boolean inCredit)
    {
        this.inCredit = inCredit;
    }
    
    void setAcctBalance(double acctBalance)
    {
    	if(acctBalance > 0)
            this.acctBalance = acctBalance;
    	else out.println("You can't have a negative balance");
	    
    }

    //getters
    String getAccountName() {
        return accountName;
    }
    
    int getAccountNumber() {
        return accountNumber;
    }
    
    String getSortCode() {
        return SortCode;
    }
    
    public String getbranchName() {
        return branchName;
    }
   
    
    public boolean getinCredit() {
        return inCredit;
    }
   
    public double getacctBalance() {
        return acctBalance;
    }

    //Others
    @Override
    public String toString() {
        String s="";

        s = "Account name: " + this.accountName;
        s += "\nAccount number: " + this.accountNumber;
        s += "\nSort Code: " + this.SortCode;
        s += "\nBranch Name: " + this.branchName;
        s += "\nIn credit: " + this.inCredit;
        s += "\nAccount Balance: " + this.acctBalance;

        return s;
    }

    public void deposit(double depAmount) {
        this.acctBalance += depAmount;
        if (this.acctBalance > 0)
            this.inCredit = true;
    }
    
    public void withdraw(double takeAmount) {
        this.acctBalance -= takeAmount;
        if (this.acctBalance < 0)
            this.inCredit = false;
    }

    public void getDetails() {
    	out.println("Account type: Account" );
    	out.println("Account Name: " + accountName );
    	out.println("Account Balance: " + acctBalance );
    }
  
    public void valuableAccount() {
    	out.println("Money in account: " + this.acctBalance );
    }
}