package com.tj.ex06_override;

public class ChildClass extends ParentClass { // method1(),method2()
	public ChildClass() {
		System.out.println("매개변수 없는 ChildClass 생성자");
	}
	public ChildClass(int i) {
		System.out.println("매개변수 있는 ChildClass 생성자");
	}
	@Override
	public void method2() {// override (함수의 재정의)
		System.out.println("ChildClass의 method2()함수");
	}
	public void method3() {
		System.out.println("ChildClass의 method3");
	}

}
