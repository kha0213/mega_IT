package com.tj.practice2;

public class AcademyMain {

	public static void main(String[] args) {
		Person[] p = {new Student("A01","�շ���","JAVA��"), 
				new Student("A02","������","JAVA��"),
				new Staff("B01","JYP","�������"),
				new Staff("B02","ȫ�浿","���������"),
				new Gangsa("S01","���μ�","����"),
		};
		
		for(Person pp : p) {
			System.out.println(pp.infoString());
		}

	}

}
