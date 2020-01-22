package practice.academy;

import practice.inter.GetSalary;
import practice.inter.JobMng;

public class Staff extends Person {
	private String part;

	public Staff(String id, String name,String part) {
		super(id, name);
		this.part=part;
		setGet(new GetSalary());
		setJobs(new JobMng());
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("[ºÎ¼­] "+part);
	}

	
	

}
