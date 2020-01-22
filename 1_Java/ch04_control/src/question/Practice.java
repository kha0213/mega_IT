package question;

import java.util.*;

public class Practice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("컴퓨터가 발생한 로또번호 1개를 맞추어 보아요");
		int com = (int) (Math.random() * 45) + 1;
		System.out.println("컴퓨터가 1~45 사이의 숫자 하나를 정했습니다.! 맞춰보세요");
		int you;
		int i = 1;
		while (i >= 0) {
			System.out.println(i + "번째 실행입니다.");
			you = sc.nextInt();

			if (you > 45 || you < 1) {
				System.out.println("범위를 잘 봐 숫자는 1~45사이를 입력해야해 이건 횟수로 안칠께 다시해봐");
				continue;
			}

			if (you == com) {
				System.out.println("정답입니다.! " + i + "번째 만에 맞추셨군요. 프로그램을 종료합니다");
				break;

			} else if (you > com) {
				System.out.println("입력하신 수 " + you + " 보다 더 작은 숫자에요~ 다시해봐요!!");
				i++;

			} else {
				System.out.println("입력하신 수 " + you + " 보다 더 큰 숫자에요~ 다시해봐요!!");
				i++;
			}
		} // while

		sc.close();

	}
}