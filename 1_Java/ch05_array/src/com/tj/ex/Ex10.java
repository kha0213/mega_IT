package com.tj.ex;
// ������ ���� 76,45,34,89,100,50,90,92
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
		
		System.out.printf("���� %d�̰�, ���%.2f�̰�, �ִ� %d �ּڰ� %d �̴�\n",tot,avg,max,min);
		
		
		
	}

}
