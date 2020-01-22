package com.tj.ex;
import java.util.*;
// int[] arr = {10,20,30,40,50} 배열 값을 누적한 합을 출력하는 프로그램
public class Ex06 {
	public static void main(String[] args) {
		int[] arr = new int[5];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<arr.length;i++) {
			System.out.println(i+1+"번째 숫자를 입력하세요.");
			arr[i] = sc.nextInt();
			}
		sc.close();
		int tot=0;
		for(int i=0;i<arr.length;i++) {
			tot+=arr[i];
		}
		System.out.println("입력한 숫자의 총합은 "+tot+"입니다.");
				
		
	}

}
