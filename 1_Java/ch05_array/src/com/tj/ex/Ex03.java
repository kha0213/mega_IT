package com.tj.ex;
// 두 개의 같은 내용의 배열을 따로 두고 싶을 때
public class Ex03 {
	public static void main(String[] args) {
		int[] score = {10,20,30,40,50};
		int[] s = new int[score.length];
//		for(int idx=0;idx<score.length;idx++) {
//			s[idx] = score[idx];
//		}
System.arraycopy(score, 0, s, 0, score.length);		
		
		for(int idx=0;idx<s.length;idx++) {
			System.out.println("score["+idx+"]="+score[idx]+"\ts["+idx+"]="+s[idx]);
		}
		score[0] = 9999;
		System.out.println("변경 후");
		
		for(int idx=0;idx<s.length;idx++) {
			System.out.println("score["+idx+"]="+score[idx]+"\ts["+idx+"]="+s[idx]);
		}
		
	}

}
