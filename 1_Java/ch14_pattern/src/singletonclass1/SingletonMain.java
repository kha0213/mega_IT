package singletonclass1;

public class SingletonMain {
	public static void main(String[] args) {
		SingletonClass obj1 = SingletonClass.getINSTANCE();
		obj1.setI(99);
		SingletonClass obj2 = SingletonClass.getINSTANCE();
		System.out.println("obj2�� I : "+obj2.getI());
		System.out.println("obj1�� I : "+obj1.getI());


	}
}