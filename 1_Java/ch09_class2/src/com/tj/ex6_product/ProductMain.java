package com.tj.ex6_product;

public class ProductMain {
	public static void main(String[] args) {
		
		
		
		Product p1 = new Product("≥√¿Â∞Ì"); //p1.serialNo = 101
		Product p2 = new Product("≥√¿Â∞Ì∞Ì");
		Product p3 = new Product("≥√¿Â∞Ì∞Ì∞Ì");
		
		System.out.println(p1.infoString());
		System.out.println(p2.infoString());
		System.out.println(p3.infoString());
		
		
	}

}
