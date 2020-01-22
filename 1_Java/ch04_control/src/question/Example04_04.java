package question;
import java.util.*;
public class Example04_04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가위, 바위, 보 중 하나를 입력하세요.");
		
		String word = sc.nextLine();
		sc.close();
		
		System.out.println("당신은 "+word+"를 내셨습니다.");
				
		
	}
	
}