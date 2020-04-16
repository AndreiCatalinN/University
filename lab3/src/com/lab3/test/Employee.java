package com.lab3.test;

public class Employee 
{
	//Attributes
	private String fName;
	private String sName;
	private int staffNum;
	private double annualSalary;

	//Constructors
	public Employee(String firstName, String surName, int staffNo, double annualSalary)
	{
		this.fName = firstName;
		this.sName = surName;
		this.staffNum = staffNo;
		this.annualSalary = annualSalary;
	}
		
	//Setters
	public void setFName(String firstName)
	{
		this.fName = firstName;
	}
	public void setSName(String surName)
	{
		this.sName = surName;	
	}
	public void setStaffNum(int staffNum)
	{
		this.staffNum = staffNum;	
	}
	public void setAnnualSalary(double annual)
	{
		this.annualSalary = annual;	
	}

	//Getters
	public String getFName()
	{
		return fName;
	}
	public String getSName()
	{
		return sName;	
	}
	public int getStaffNum()
	{
		return staffNum;	
	}
	public double getAnnualSalary()
	{
		return annualSalary;	
	}
		
	//Others
	public double calculatePay()
	{
		return (annualSalary /12);
	}
	
	public String toString()
	{
		String s= "";
		s = s + "Name: " + getFName() +" "+ getSName() + "\nStaff Number: ";
		s = s + getStaffNum() + " \nAnnual Salary: " + getAnnualSalary();
		s = s + " \nMonthly Salary: " + calculatePay();
		
		return s;
	}
}