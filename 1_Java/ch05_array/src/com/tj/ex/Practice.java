package com.tj.ex;

public class Practice {
	public static void main(String[] args) {
		System.out.println("������ ����2) 2���� �迭�� ����� �� �հ� ���ϱ�");
		int[][] arr = {{5,5,5,5,5},{10,10,10,10,10},{20,20,20,20,20},{30,30,30,30,30}};
		int tot=0;
		
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				tot += arr[i][j];
				
			}//for
			
		}//for
		
		System.out.println(tot);
		
		
	} 


}
