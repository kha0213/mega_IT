package com.tj.condition;

//�����Է¹޾� ���� ���(if, switch��)
import java.util.*;

public class Ex04_switch2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����� ������ �Է��ϼ���.");
		int score = sc.nextInt();
		sc.close();
		int temp = score == 100 ? score - 1 : score;
		switch (temp / 10) {
//		case 10:
//			System.out.println("�����ؿ� 100�� ���� �Դϴ�.");
//			break;
		case 9:
			System.out.println("���߾�� A����Դϴ�.");
			break;
		case 8:
			System.out.println("�����ƿ� B����Դϴ�.");
			break;
		case 7:
			System.out.println("�����ϼž߰ھ�� C����Դϴ�.");
			break;
		case 6:
			System.out.println("���趧 ���̳���? D����Դϴ�.");
			break;
		case 5:
		case 4:
		case 3:
		case 2:
		case 1:
		case 0:
			System.out.println("�� �л���� F����Դϴ�.");
			break;

		default:
			System.out.println("��ȿ���� ���� �����Դϴ�.");
			break;

		}
	}

}
