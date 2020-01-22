package com.tj.ex;

public class Ex05 {
	public static void main(String[] args) {
		int[] arr = {76,45,89,36};
		int temp = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					
				}
			}//for j
		}//for
		for(int idx=0;idx<arr.length;idx++) {
			System.out.println(arr[idx]);
		}
	}

}
