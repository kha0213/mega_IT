package com.tj.method;
// sum(from, to), evenOdd(Â¦,È¦), abs(-5) Àý´ñ°ª
public class Arithmetic {
	public int sum(int from,int to) {
		int result=0;
		for(int i=from;i<=to;i++) {
			result +=i;
		}
		return result;
	} //sum method
	
	
	public String evenOdd(int value) {
		String result = (value%2==0) ? "Â¦¼öÀÔ´Ï´Ù" : "È¦¼öÀÔ´Ï´Ù";
		return result;
	}//evenOdd method
	
	public static int abs(int value) {
		int result = value<0 ? -value : value;
		return result;
	}//abs method
		

}
