package question;

import java.util.*;

public class Example04_05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("��ǻ�Ϳ� ���� ���� �� �մϴ�.");
		System.out.println("������ 0 ������ 1 ���� 2�� �Է��ϼ���!");

		while (true) {

			int doIt, computer;
			doIt = sc.nextInt();
			computer = (int) (Math.random() * 3);
			

			if (doIt == 0) {
				System.out.println("����� : ����");
			} else if (doIt == 1) {
				System.out.println("����� : ����");
			} else if (doIt == 2) {
				System.out.println("����� : ��");
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				return;
			}

			if (computer == 0) {
				System.out.println("��ǻ�� : ����");
			} else if (computer == 1) {
				System.out.println("��ǻ�� : ����");
			} else {
				System.out.println("��ǻ�� : ��");
			}

			if (doIt == computer) {
				System.out.println("���º��Դϴ�. �ٽ� ����(0) ����(1) ��(2)�� �Է��ϼ���");
			} else if (doIt == 0 && computer == 1 || doIt == 1 && computer == 2 || doIt == 2 && computer == 0) {
				System.out.println("��ǻ�� �¸��Դϴ�. �̱� ������ �ؾ���! ����(0) ����(1) ��(2)�� �Է��ϼ���");
			} else {
				System.out.println("����� �¸��Դϴ�. �����մϴ�. ����Դϴ�.");
				break;
			}
		} // while
		sc.close();	
	}

}