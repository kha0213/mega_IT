package question;
public class Homework_3 {

	public static void main(String[] args) {
		System.out.println("주사위를 두 번 던져서 합이 6이되면 끝입니다.");
		
		for(int i=1;i<=6;i++) {
			for(int j=1;j<=6;j++) {
				if(i+j==6) {
					System.out.println("i 주사위: "+i+", j주사위: "+j);
				}
				
			}//for j
		}//for i

	}

}
