package com.lab2.test;

public class Animal 
{
	private String name;
	private String breed;
	private int age;
	private boolean domesticated;
	private String colour;

	//Constructor
	public Animal(String name)
	{
		setName(name);
	}
	
	public Animal(String name,String Breed, int age, boolean domesticated, String color)
	{
		setName(name);
		setBreed(Breed);
		setAge(age);
		setDomesticated(domesticated);
		setColour(color);
		
	}
	
	//Others
	public String toString()
	{
		String s ="";
		s = s + "Name: " + name + " Breed: " + breed;
		s = s + " Age: " + age + " Domesticated: " + domesticated + " Color: ";
		s = s + colour;

		return s;
	}
	
	public void makeNoise()
	{
		if ( breed == "Dog")
			System.out.println("Bark");
		else if (breed == "Cat" )
			System.out.println("Meow");
		else if (breed == "Wolf" )
			System.out.println("Auuuu");
		else if (breed == "Bear" )
			System.out.println("Roar");

	}
	
	public void makeNoise(boolean old)
	{
		if(old == true)
		{
			if ( breed == "Dog")
				System.out.println("Quiet Bark");
			else if (breed == "Cat" )
				System.out.println("Quiet Meow");
			else if (breed == "Wolf" )
				System.out.println("Quiet Auuuu");
			else if (breed == "Bear" )
				System.out.println("Quiet Roar");
		}
		else makeNoise();

	}
	
	
	//Setters
	public void setName(String name)
	{
		this.name = name;
	}
	public void setBreed(String Breed)
	{
		this.breed = Breed;
	}
	
	public void setAge(int age)
	{	
		if( age > 0 )  
			this.age = age;
		else System.out.println("Invalid age");
	}
	public void setDomesticated(boolean d)
	{
		this.domesticated = d;
	}
	public void setColour(String color)
	{
		this.colour = color;
	}

	
	//Getters
	public String getName()
	{
		return this.name;
	}
	public String getBreed()
	{
		 return	this.breed;
	}
	public int getAge()
	{
		 return	this.age;
	}
	public boolean getDomesticated()
	{
		 return this.domesticated;
	}
	public String getcolor()
	{
		 return this.colour;
	}
	
}
