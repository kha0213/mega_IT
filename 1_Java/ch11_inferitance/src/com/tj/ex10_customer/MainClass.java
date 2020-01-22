package com.tj.ex10_customer;

public class MainClass {

	public static void main(String[] args) {
		Customer customer = new Customer("롱롱이","010-3121-3235","서울시 송파구","2019-12-04");
		customer.buy(10000);
		
		Staff staff = new Staff("SCV","010-2233-3215","서울시 종로구","2017-10-10");
		Person[] person = {customer,staff};
		for(Person s : person) {
			System.out.println(s.infoString());
		}
		Person customer1 = new Staff("하잉","전번","03-28","하하부서");
		System.out.println(customer1.infoString());
		if(customer1 instanceof Customer) {
		((Customer) customer1).buy(100);
		}
	
	
	}//main
		
}
