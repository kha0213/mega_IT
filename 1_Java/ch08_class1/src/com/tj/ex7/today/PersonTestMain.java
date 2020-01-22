package com.tj.ex7.today;

public class PersonTestMain {
	public static void main(String[] args) {
		
		PersonInfo[] person = {new PersonInfo("롱롱이",29,"남자"),new PersonInfo("영롱이",25,"남성")
				
		};//PersonInfo
		PersonInfo[] iperson = new PersonInfo[2];
		iperson[0] = new PersonInfo("홍길동",20,"남자");
		iperson[1] = new PersonInfo("홍길순",19,"여자");
		
		for(int idx=0;idx<person.length;idx++) {
			person[idx].print();
		}
		for(PersonInfo idx2 : iperson) {
			idx2.print();
		}
		
		
	}

}
