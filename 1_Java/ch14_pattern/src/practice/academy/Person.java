package practice.academy;

import practice.inter.IGet;
import practice.inter.IJob;

public class Person {
	private String id;
	private String name;
	private IGet get;
	private IJob jobs;
	
	public Person() {
		
	}
	
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}


	public void print() {
		System.out.print("[ID] "+id+" [¿Ã∏ß] "+name+" ");
		
	}
	
	public void getMoney() {
		get.getMoney();
	}
	public void jobs() {
		jobs.job();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public IGet getGet() {
		return get;
	}


	public void setGet(IGet get) {
		this.get = get;
	}


	public IJob getJobs() {
		return jobs;
	}


	public void setJobs(IJob jobs) {
		this.jobs = jobs;
	}
	
	
}
