package question;

import java.util.*;

public class Example04_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("���� �Է��ϼ���.");
		int num1 = sc.nextInt();
//		System.out.println("�� ��° ���� �Է��ϼ���.");
//		int num2 = sc.nextInt();
		sc.close();

		if (num1 >= 0) {
			System.out.println("�� ���� ������" + num1 + "�Դϴ�.");
		} else {
			System.out.println("�� ���� ������" + -num1 + "�Դϴ�.");
		}

	}

}
