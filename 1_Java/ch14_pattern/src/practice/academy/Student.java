package practice.academy;

import practice.inter.GetStudentPay;
import practice.inter.JobStudy;

public class Student extends Person {
	private String ban;
	
	public Student() {
		
	}
	public Student(String id, String name,String ban) {
		super(id, name);
		this.ban=ban;
		setGet(new GetStudentPay());
		setJobs(new JobStudy());
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("[¹Ý] "+ban);
	}

	
	

}
