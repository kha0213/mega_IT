package com.tj.ex;
import java.util.*;
public class Ex04 {
	public static void main(String[] args) {
		String[] name = {"철수","영희","길동","영수","말자"};
		int[] hei = new int[5];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<name.length;i++) {
			System.out.println(name[i]+"의 키를 입력하세요.");
			hei[i] = sc.nextInt();
		}
		sc.close();
		int max=0,min=999;
		int sum =0,avr=0;
		int minIndex=0,maxIndex=0;
		for(int i=0;i<hei.length;i++) {
			sum+=hei[i];
			if(hei[i]<min) {
				min = hei[i];
				minIndex = i;
			}
			if(hei[i]>max) {
				max = hei[i];
				maxIndex = i;
			}
		}
		
		avr = sum/hei.length;

		System.out.println("키의 총합"+sum);
		System.out.println("키의 평균"+avr);
		System.out.println("최장신키 : "+name[maxIndex]+"이고 키는 "+max);
		System.out.println("최단신키 : "+name[minIndex]+"이고 키는 "+min);
		
		
//		for(int idx=0;idx<name.length;idx++) {
//			if(hei[]<hei[i]) {
//				max = i;
//			}//if
//			else if(hei[min]<hei[i]) {
//				min = i;
//			}
//		}//for
		
	}

}
