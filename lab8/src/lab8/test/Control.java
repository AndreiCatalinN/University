package lab8.test;

import static java.lang.System.out;

public class Control {
	public static void main(String [] args) {
		
		
		String role ="Hefe";
		Employee test2 = new Employee(//Name, gender, dob
									"Andrei", "Negura", "male",
									new Date(26,11,1997),
									//Salary, job title, f to
									//check if the job title is valid
									new Job(20000, role, 12),
									//Start date
									new Date(22,10,1200));
		
		Job jobtest2 = new Job(1000, "Someone2",2);
		
		out.println(jobtest2+ "\n!!!!!!!!!!!!!!\n");
		out.println(test2);
	}
}