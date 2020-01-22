package question;

import java.util.*;

public class Example04_05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("컴퓨터와 가위 바위 보 합니다.");
		System.out.println("가위는 0 바위는 1 보는 2를 입력하세요!");

		while (true) {

			int doIt, computer;
			doIt = sc.nextInt();
			computer = (int) (Math.random() * 3);
			

			if (doIt == 0) {
				System.out.println("사용자 : 가위");
			} else if (doIt == 1) {
				System.out.println("사용자 : 바위");
			} else if (doIt == 2) {
				System.out.println("사용자 : 보");
			} else {
				System.out.println("잘못 입력하셨습니다.");
				return;
			}

			if (computer == 0) {
				System.out.println("컴퓨터 : 가위");
			} else if (computer == 1) {
				System.out.println("컴퓨터 : 바위");
			} else {
				System.out.println("컴퓨터 : 보");
			}

			if (doIt == computer) {
				System.out.println("무승부입니다. 다시 가위(0) 바위(1) 보(2)를 입력하세요");
			} else if (doIt == 0 && computer == 1 || doIt == 1 && computer == 2 || doIt == 2 && computer == 0) {
				System.out.println("컴퓨터 승리입니다. 이길 때까지 해야죠! 가위(0) 바위(1) 보(2)를 입력하세요");
			} else {
				System.out.println("사용자 승리입니다. 축하합니다. 통과입니다.");
				break;
			}
		} // while
		sc.close();	
	}

}