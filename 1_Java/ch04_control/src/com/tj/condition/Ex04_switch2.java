package com.tj.condition;

//점수입력받아 학점 출력(if, switch문)
import java.util.*;

public class Ex04_switch2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("당신의 점수를 입력하세요.");
		int score = sc.nextInt();
		sc.close();
		int temp = score == 100 ? score - 1 : score;
		switch (temp / 10) {
//		case 10:
//			System.out.println("축하해요 100점 만점 입니다.");
//			break;
		case 9:
			System.out.println("잘했어요 A등급입니다.");
			break;
		case 8:
			System.out.println("괜찮아요 B등급입니다.");
			break;
		case 7:
			System.out.println("공부하셔야겠어요 C등급입니다.");
			break;
		case 6:
			System.out.println("시험때 조셨나요? D등급입니다.");
			break;
		case 5:
		case 4:
		case 3:
		case 2:
		case 1:
		case 0:
			System.out.println("넌 학사경고야 F등급입니다.");
			break;

		default:
			System.out.println("유효하지 않은 점수입니다.");
			break;

		}
	}

}
