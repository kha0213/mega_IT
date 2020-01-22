package com.tj.ex2_throws;

public class MainClass {
	public static void main(String[] args)  {
			try {
				new ThrowsEx();
			} catch (Exception e) {
				System.out.println("오류발생");
			}
	}
}
