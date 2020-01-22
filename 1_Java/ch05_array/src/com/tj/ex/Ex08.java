package com.tj.ex;

public class Ex08 {
	public static void main(String[] args) {
		
		int[] arr = { 10, 20, 30 };
		for (int i : arr) {
			i = (int)(i*2);
			System.out.println(i);

		}
		
		arrayPrint(arr);
		


	}
	private static void arrayPrint(int[] array) {
		for(int idx=0;idx<array.length;idx++) {
			System.out.println(array[idx]);
		}//for
		
	}//private

	
	

}
