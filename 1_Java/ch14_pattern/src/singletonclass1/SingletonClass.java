package singletonclass1;

public class SingletonClass {
	private int i;
	private static SingletonClass INSTANCE=new SingletonClass();
	public static SingletonClass getINSTANCE() {

		return INSTANCE;

	}
	
	private SingletonClass() {
	}
	
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
}
