package question;

import java.util.*;

public class Example04_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("수를 입력하세요.");
		int num1 = sc.nextInt();
//		System.out.println("두 번째 수를 입력하세요.");
//		int num2 = sc.nextInt();
		sc.close();

		if (num1 >= 0) {
			System.out.println("그 수의 절댓값은" + num1 + "입니다.");
		} else {
			System.out.println("그 수의 절댓값은" + -num1 + "입니다.");
		}

	}

}
