package singletonclass2;

public class SecondClass {
	public SecondClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("Second Ŭ���� ������ ������");
		System.out.println("�̱��水ü�� I�� :"+ singletonObject.getI());
		System.out.println("Second Ŭ���� ������ ��");
	}
}
