package question;

import java.util.*;

public class Practice4 {
	public static void main(String[] args) {
		System.out.println("입력한 금액을 5만원, 만원, 오천원 권종으로 분리해볼께요\n 돈을 입력해주세요");
		Scanner sc = new Scanner(System.in);
		int you = sc.nextInt();
		

		int[] money = new int[4];
		

		money[0] = you/50000;
		you -= money[0]*50000;
		money[1] = you/10000;
		you -= money[1]*10000;
		money[2] = you/5000;
		you -= money[2]*5000;
		
		System.out.printf("5만원짜리 %d장 , 만원짜리 %d 장\n",money[0],money[1]);

		sc.close();
	}

}
