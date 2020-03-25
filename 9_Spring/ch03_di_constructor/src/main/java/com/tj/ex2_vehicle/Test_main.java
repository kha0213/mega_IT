package com.tj.ex2_vehicle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test_main {
	public static void main(String[] args) {
		String resourceLocation = "classpath:applicationCTX1.xml";
		AbstractApplicationContext abapctx = new GenericXmlApplicationContext(resourceLocation);
		Vehicle vh = abapctx.getBean("vh",Vehicle.class);
		vh.ride("롱롱");
		
		abapctx.close();
	}
}
