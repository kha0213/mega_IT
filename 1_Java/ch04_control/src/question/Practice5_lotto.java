package question;

import java.util.*;

public class Practice5_lotto {
	public static void main(String[] args) {
		System.out.println("***야구게임~~ 컴퓨터가 내놓은 3자리 수 맞추기***");
		System.out.println(
				"규칙 설명: 각 자리수가 1~9까지인 3자리수가 있다 당신이 3자리수를 말하고 각 자리수마다 맞으면 Strike 틀리면 Ball로 답할 것이다.\n 예를 들면 컴퓨터가 771인 세 자리 수를 골랐고 당신이 715를 골랐으면 1 Strike, 2 Ball 이다.\n 당연히 3 Strike면 끝이다.");
		int[] com = new int[3];
		for (int i = 0; i < com.length; i++) {
			com[i] = (int) (Math.random() * 9) + 1;
		} // for 난수설정

		int strike = 0, ball = 0;
		Scanner sc = new Scanner(System.in);
		int[] you = new int[3];
		System.out.printf("자 컴퓨터가 숫자 3자리수를 골랐다. 너도 3자리의 수를 골라 써 놓아보자.\n");

		while (true) {
			System.out.printf("자 맞출때까지이~ 다시 한다 3자리의 수를 골라 써 놓아보자.\n");
			for (int i = 0; i < you.length; i++) {
				System.out.print(i + 1 + "번째 숫자를 입력하세요.");
				you[i] = sc.nextInt();
			}
			for (int k = 0; k < com.length; k++) {
				if (com[k] == you[k]) {
					strike++;
				} // if
				else if (you[k] == com[0] || you[k] == com[1] || you[k] == com[2]) {
					ball++;
				}

			}
			System.out.printf("자 너의 결과는 %d Strike , %d Ball 이야.", strike, ball);
			if (strike == 3) {
				break;

			} else {
				strike = 0;
				ball = 0;
			}

		} // while
		System.out.println("축하드려요 3strike 성공입니다!");
	}// main

}
