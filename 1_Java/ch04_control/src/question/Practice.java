package question;

import java.util.*;

public class Practice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��ǻ�Ͱ� �߻��� �ζǹ�ȣ 1���� ���߾� ���ƿ�");
		int com = (int) (Math.random() * 45) + 1;
		System.out.println("��ǻ�Ͱ� 1~45 ������ ���� �ϳ��� ���߽��ϴ�.! ���纸����");
		int you;
		int i = 1;
		while (i >= 0) {
			System.out.println(i + "��° �����Դϴ�.");
			you = sc.nextInt();

			if (you > 45 || you < 1) {
				System.out.println("������ �� �� ���ڴ� 1~45���̸� �Է��ؾ��� �̰� Ƚ���� ��ĥ�� �ٽ��غ�");
				continue;
			}

			if (you == com) {
				System.out.println("�����Դϴ�.! " + i + "��° ���� ���߼̱���. ���α׷��� �����մϴ�");
				break;

			} else if (you > com) {
				System.out.println("�Է��Ͻ� �� " + you + " ���� �� ���� ���ڿ���~ �ٽ��غ���!!");
				i++;

			} else {
				System.out.println("�Է��Ͻ� �� " + you + " ���� �� ū ���ڿ���~ �ٽ��غ���!!");
				i++;
			}
		} // while

		sc.close();

	}
}