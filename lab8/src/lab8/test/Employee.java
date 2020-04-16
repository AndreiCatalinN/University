package lab8.test;

public class Employee extends Person{
	
	//Attributes
	private Job job;
	private int personnelNumber;
	private Date startDate;
	private static int nextNumber = 0;
	
	//Constructors
	
			
	Employee(//Person attributes 
			 String fName, String sName, String gender, 
			 Date dob, Job j,Date d )
	{
		super(fName, sName, gender, dob);
		
		job = j;
		personnelNumber = getNextNumber();
		startDate = d;
		
	}
	
	//Getters and setters
	public Job getJob() {
		return job;
	}
	public void setJob(Job jb) {
		job = jb;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public int getPersonnelNUmber() {
		return personnelNumber;
	}
	public void setPersonnelNUmber(int personnelNUmber) {
		this.personnelNumber = personnelNUmber;
	}
	private int getNextNumber() {
		return ++nextNumber;
	}
	
	public String toString() {
		String s = super.toString();
		s +=  "Personnel num: "+ personnelNumber + "\nJob: "+
				job.toString() + "\nStart date " + 
				startDate.toString();
		return s;
	}
}