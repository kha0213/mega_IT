package com.tj.ex6_product;
// Product p1 = new Product("�����")
public class Product {
	public static int count = 100;
	private int serialNo;
	private String name;
	public Product () {
		
	}
	public Product(String name){
		serialNo = ++count; 
		this.name=name;
	}
	public String infoString() {
		return "serialNO : "+serialNo+"\t��ǰ��: "+name;
	}
	public void print() {
		System.out.println("serialNO : "+serialNo+"\t��ǰ��: "+name);
	}

}
