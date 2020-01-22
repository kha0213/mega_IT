package singletonclass2;

public class FirstClass {
	public FirstClass( ) {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("FirstClass ½ÇÇà");
		System.out.println("½Ì±ÛÅæ°´Ã¼ÀÇ Ã³À½ I°ª :"+ singletonObject.getI());
		singletonObject.setI(200);
		System.out.println("½Ì±ÛÅæ°´Ã¼ÀÇ ¼öÁ¤ ÈÄ I°ª :"+ singletonObject.getI());

	}

}
