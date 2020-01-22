package question;

import java.util.*;

public class Homework_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("컴퓨터와 가위바위보 게임을 합니다.! 그만두고 싶으시면 -1을 입력하세요!");

		int you, com;
		int win=0, draw=0, lose=0;

		while (true) {
			com = (int) (Math.random() * 3);
			System.out.println("컴퓨터가 무엇을 낼지 정하였습니다.\n 가위는 0 바위는 1 보는 2를 내면 됩니다.\n(혹시라도 게임을 그만두고 싶으시면 -1 을 입력하세요~!)");
			you = sc.nextInt();

			
			if (you == 0) {
				System.out.println("너님 : 가위");
			} else if (you == 1) {
				System.out.println("너님 : 바위");
			} else if (you == 2) {
				System.out.println("너님 : 보");
			} else if (you == -1 ) {
				break;
			} else {
				System.out.println("떼끼!!!! 이상한 수 쓰지 말고 다시 해!!\n");
				continue;
			}
			if (com == 0) {
				System.out.println("컴퓨터 : 가위");
			} else if (com == 1) {
				System.out.println("컴퓨터 : 바위");
			} else {
				System.out.println("컴퓨터 : 보");
			}
			
			if (com==you) {
				System.out.println("비겼네요 다시 한 번 할까요~?\n");
				draw++;
			} else if(you==0 && com==1 || you==1 && com==2 || you==2 && com==0) {
				System.out.println("컴퓨터의 승리입니다.~ 다시 한 번 할까요~?\n");
				lose++;
			} else {
				System.out.println("너의 승리입니다~!~! 축하드려요. 다시 한 번 할까요~?\n");
				win++;
			}

		}//while
		System.out.printf("WIN : %d회  DRAW : %d회  LOSE : %d회\n",win,draw,lose);
		System.out.println("-1을 입력하셨습니다 시스템을 종료합니다.");

	}

}
