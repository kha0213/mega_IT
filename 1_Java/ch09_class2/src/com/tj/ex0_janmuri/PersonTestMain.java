package com.tj.ex0_janmuri;
class PersonInfo {
	private String name;
	private int age;
	private String gender;
	
	public PersonInfo() {
		System.out.println("�ȳ��ϼ���.\n �̸�, ����, ������ �Է����ּ���.");
	}
	public PersonInfo(String name, int age, String gender) {
		this.name=name;
		this.age=age;
		this.gender=gender;
		System.out.printf("�ȳ��ϼ���.\n�̸� : %s, ���� : %d��, ���� : %s�� �ԷµǾ����ϴ�.\n",name,age,gender);
	}
	public void print() {
		System.out.printf("�̸� : %s\t",name);
		System.out.printf("���� : %d��\t",age);
		System.out.printf("���� : %s\n",gender);
		
	}
		
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(0<=age && age<=100) {
			this.age = age;
		}
		else if(100<age && age<=140) {
			this.age=age;
			System.out.println("100���� �Ѿ����? ����?");
		}
		else {
			System.out.println("����!! �ٽ� ���� ���� �ϼ���.");
		}
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		if(gender.equals("����") || gender.equals("man") || gender.equals("Man") || gender.equals("����")) {
		this.gender = "����";
		}
		else if(gender.equals("����") || gender.equals("woman") || gender.equals("Woman") || gender.equals("����")) {
		this.gender = "����";
		}
		else {
			System.out.println("�߸��Է��ϼ̽��ϴ�. ���� �Ǵ� ���ڷ� �Է����ּ���.");
		}
	}

}

public class PersonTestMain {
	public static void main(String[] args) {
		
		PersonInfo[] person = {new PersonInfo("�շ���",29,"����"),new PersonInfo("������",25,"����")
				
		};//PersonInfo
		PersonInfo[] iperson = new PersonInfo[2];
		iperson[0] = new PersonInfo("ȫ�浿",20,"����");
		iperson[1] = new PersonInfo("ȫ���",19,"����");
		
		for(int idx=0;idx<person.length;idx++) {
			person[idx].print();
		}
		for(PersonInfo idx2 : iperson) {
			idx2.print();
		}
		
		
	}

}
