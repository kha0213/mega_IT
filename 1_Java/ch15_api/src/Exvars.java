
public class Exvars {
	public static void main(String[] args) {
		System.out.println(sum(10,20));
		System.out.println(sum(10,20,30));
		System.out.println(sum(10,20,30,40));
		System.out.println(sum(10,20,30,40,50));
		
		
		
	}//main

	private static int sum(int...su) {// 가변인자 함수
		int total=0;
		for(int s : su) {
			total +=s;
		}
		return total;
	}
}
