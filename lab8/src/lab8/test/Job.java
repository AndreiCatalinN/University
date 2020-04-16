package lab8.test;

public class Job {
	
	//Attributes
	private double salary;
	private String role;
	private  int jobID;
	
	//Constructors
	Job(double sal, String role, int jobID){
		this.salary = sal;
		setRole(role);
		setJobID(jobID);
	}
	//Getter
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role){
		FileProcessing f = new FileProcessing("roles.txt");
		String roles = f.fileOpen();
		
		if(f.)
			this.role = role;
		else
			System.out.println("Invalid job");
	}
	public int getJobID() {
		return jobID;
	}
	private void setJobID(int jobid) {
		jobID = jobid;
	}
	
	public String toString() {
		String s = "";
		s += "Salary: " + salary + "\nJob: "
				+ role + "\nJobID: " + jobID;
		return s;
	}
}