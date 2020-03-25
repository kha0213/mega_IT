package com.tj.ex1_student;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test_main {
	public static void main(String[] args) {
		String resourceLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext abapctx = new GenericXmlApplicationContext(resourceLocation);
		
		Student_info student_info1 = abapctx.getBean("student_info1",Student_info.class);
		Student_info student_info2 = abapctx.getBean("student_info2",Student_info.class);
		Student s1 = student_info1.getStudent();
		Student s2 = abapctx.getBean("student1",Student.class);
		Student s3 = abapctx.getBean("student2",Student.class);
		
		
		if(s1.equals(s2)) {
			System.out.println("s1과 s2는 같은 객체");
		}else {
			System.out.println("s1과 s2는 홍길동이지만 다른 주소 객체");
		}
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		
		abapctx.close();
		
	}
}
