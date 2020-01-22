package practice.academy;

import practice.inter.GetSalary;
import practice.inter.JobLec;

public class Gangsa extends Person {
	private String subject;

	public Gangsa(String id, String name,String subject) {
		super(id, name);
		this.subject=subject;
		setGet(new GetSalary());
		setJobs(new JobLec());
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("[강의과목] "+subject);
	}

	
	

}
