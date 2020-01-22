package com.tj.loop;

public class Ex01_for {
	public static void main(String[] args) {
		int tot=0;
		for(int i=1;i<=20;i++) {
			System.out.print(i);
			tot+=i;
			if(i!=20) {
				System.out.print("+");
			}
		}
		System.out.println("="+tot);
	}

}
