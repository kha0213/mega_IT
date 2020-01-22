package com.tj.ex;
// 오늘의 문제 76,45,34,89,100,50,90,92
public class Ex10 {
	public static void main(String[] args) {
		int[] grade = {76,45,34,89,100,50,90,92};
		int tot = 0;
		double avg;
		int max=0, min=999;
				
		for(int i=0;i<grade.length;i++) {
			tot += grade[i];
			if(max < i) {
				max = grade[i];
			}
			if(min > i) {
				min=grade[i];
			}
		}
		avg = tot/grade.length;
		
		System.out.printf("총합 %d이고, 평균%.2f이고, 최댓값 %d 최솟값 %d 이다\n",tot,avg,max,min);
		
		
		
	}

}
