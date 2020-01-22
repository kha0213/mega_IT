package com.tj.ex;
//거스름돈 2680원을 500,100,50,10 원짜리 몇개 구별하시오
public class Ex11 {
	public static void main(String[] args) {
		
		int[] coinUnit = {500,100,50,10};
		
		System.out.println("거스름돈 2680원이 있다.");
		
		int money = 2680; 
		
//		for(int i=0;i<coinUnit.length;i++) {
//			
//			System.out.println(coinUnit[i]+"원 짜리는 "+money/coinUnit[i]+"개");
//			money %= coinUnit[i];
		
		for(int coin : coinUnit) {
			System.out.println(coin+"원 짜리는 "+money/coin+"개");
			money %= coin;		
		}
		
	}

}
