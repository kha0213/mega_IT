package com.tj.ex6_wrapper;
//java 클래스명 100 20 10
public class Ex03 {
	public static void main(String[] args ) {
		System.out.println("들어온 값 갯수 : "+args.length);
		int tot=0;
//		for(int cnt=0;cnt<args.length;cnt++) {
//			tot+=Integer.parseInt(args[cnt]);
//		}
		
		for(String i : args) {
			System.out.println(i);
			tot+=Double.parseDouble(i);
		}
		
		System.out.println("total "+tot);
	}
}
