package com.tj.ex7.today;

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
