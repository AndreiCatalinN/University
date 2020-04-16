package com.lab3.test;

public class HourlyEmployee extends Employee
{
		//Attributes
	private double hoursWorked;
	private double hourlyRate;
	
	//Constructors
	public HourlyEmployee(String firstName, String surName, int staffNo, double annualSalary, double hw, double hr)
	{
		super(firstName, surName, staffNo, 0);
		this.hourlyRate = hr;
		this.hoursWorked = hw;
	}
		
	//Setters
	public void setHourlyRate(double h)
	{
		this.hourlyRate = h;	
	}
	public void setHoursWorked(double h)
	{
		this.hoursWorked = h;	
	}
	
	//Getters
	public double getHoursWorked()
	{
		return hoursWorked;	
	}
	public double getHourlyRate()
	{
		return hourlyRate;	
	}
	
	//Others
	public double calculatePay()
	{
		return (hourlyRate * hoursWorked);
	}
	
	public String toString()
	{
		String s= super.toString();
		s = s + "\nHourly Rate: " + getHourlyRate() +  "\nHours Worked: " + getHoursWorked();
		
		return s;
	}
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
}

