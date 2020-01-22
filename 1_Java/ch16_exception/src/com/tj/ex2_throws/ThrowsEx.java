package com.tj.ex2_throws;

public class ThrowsEx {
	public ThrowsEx() throws Exception{
		actionC();
	}

	private void actionC() throws ArrayIndexOutOfBoundsException{
		System.out.println("actionC ���ݺ�");
		actionB();
		System.out.println("actionC �Ĺݺ�");
	}

	private void actionB() throws ArrayIndexOutOfBoundsException{
		System.out.println("actionB ���ݺ�");
		actionA();
		System.out.println("actionB �Ĺݺ�");
	}

	private void actionA() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionA ���ݺ�");
		int[] iArr = { 0, 1, 2, 3 };
		System.out.println("iArr[4] = " + iArr[4]);
		//ArrayIndexOutOfBoundsException
		System.out.println("actionA �Ĺݺ�");
	}
}
