package com.tj.ex;
//�Ž����� 2680���� 500,100,50,10 ��¥�� � �����Ͻÿ�
public class Ex11 {
	public static void main(String[] args) {
		
		int[] coinUnit = {500,100,50,10};
		
		System.out.println("�Ž����� 2680���� �ִ�.");
		
		int money = 2680; 
		
//		for(int i=0;i<coinUnit.length;i++) {
//			
//			System.out.println(coinUnit[i]+"�� ¥���� "+money/coinUnit[i]+"��");
//			money %= coinUnit[i];
		
		for(int coin : coinUnit) {
			System.out.println(coin+"�� ¥���� "+money/coin+"��");
			money %= coin;		
		}
		
	}

}
