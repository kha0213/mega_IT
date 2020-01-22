package com.tj.method;

public class Practice {
	public static void main(String args[]) {
		printCh('бс', 15);
		System.out.println("Hello, Java");
		printCh('*', 12);
		System.out.println("Hello, Java");
		printCh('*', 12);
		System.out.println("Hello, Java");
		printCh('бс', 15);
	}

	static void printCh(char ch, int i) {
		for (int cnt = 1; cnt <= i; cnt++)
			System.out.print(ch);
		System.out.println();
	}
}
