package com.tj.cal;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test_main {
	public static void main(String[] args) {
//		MyCalculator myCal = new MyCalculator();
//		myCal.setCalculator(new Calculator());
//		myCal.setN1(10023);
//		myCal.setN2(294);
		String resource_location = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resource_location);
		MyCalculator myCal = ctx.getBean("myCal",MyCalculator.class);
		myCal.add();
		myCal.sub();
		myCal.mul();
		myCal.div();
		
		ctx.close();
		
	}
}
