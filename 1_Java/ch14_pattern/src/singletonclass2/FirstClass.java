package singletonclass2;

public class FirstClass {
	public FirstClass( ) {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("FirstClass ����");
		System.out.println("�̱��水ü�� ó�� I�� :"+ singletonObject.getI());
		singletonObject.setI(200);
		System.out.println("�̱��水ü�� ���� �� I�� :"+ singletonObject.getI());

	}

}
