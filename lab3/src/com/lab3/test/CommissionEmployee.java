package com.lab3.test;

public class CommissionEmployee extends Employee
{
	//Attributes
	private double commissionEarned;
	

	//Constructors
	public CommissionEmployee(String firstName, String surName, int staffNo, double annualSalary, double CEarned)
	{
		super(firstName, surName, staffNo, annualSalary);
		this.commissionEarned = CEarned;
	}
	
	//Setters
	public void setCommision(double commissionEarned)
	{
		this.commissionEarned = commissionEarned;	
	}
	
	//Getters
	public double getCommision()
	{
		return commissionEarned;	
	}
	
	//Others
	public double calculatePay()
	{
		return (super.calculatePay() + commissionEarned);
	}
	
	public String toString()
	{
		String s= super.toString();
		s = s + "\nCommission: " + getCommision();
		
		return s;
	}
}
