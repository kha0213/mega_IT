// java Exargs 10 20 31 50
public class Exargs {
	public static void main(String[] args) {
		System.out.println("args�迭�� ���� "+args.length);
		for(String temp : args) {
			System.out.println("Hello, "+temp);
		}
	}
}
