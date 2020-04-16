package lab8.test;

public class Date {
	
	//Attributes
	private int day;
	private int month;
	private int year;
	
	//Constructors
	Date(int day, int month, int year){
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
		
	}
	//Getters and setters
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		if(day > 0 && day <32)
			this.day = day;
		else System.out.println("Invalid day");
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if(month >0 && month<13)
			this.month = month;
		else System.out.println("Invalid month");
	}
	public int getYear() {
			return year;
	}
	public void setYear(int year) {
		if(year > 0)
			this.year = year;
		else System.out.println("Invalid year");
	}
	
	public String toString() {
		String s = "";
		
		s += "(dd/mm/yyyy) :" +day+ "/"+month+ "/"+ year;
		return s;
	}
	
	
}