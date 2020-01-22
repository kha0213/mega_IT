package com.tj.practice2;

public class AcademyMain {

	public static void main(String[] args) {
		Person[] p = {new Student("A01","·Õ·ÕÀÌ","JAVA¹İ"), 
				new Student("A02","¿µ·ÕÀÌ","JAVA¹İ"),
				new Staff("B01","JYP","¿î¿µÁö¿øÆÀ"),
				new Staff("B02","È«±æµ¿","Ãë¾÷Áö¿øÆÀ"),
				new Gangsa("S01","¼³¹Î¼®","¿ª»ç"),
		};
		
		for(Person pp : p) {
			System.out.println(pp.infoString());
		}

	}

}
