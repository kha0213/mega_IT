package question;

import java.util.*;

public class Practice5_lotto {
	public static void main(String[] args) {
		System.out.println("***�߱�����~~ ��ǻ�Ͱ� ������ 3�ڸ� �� ���߱�***");
		System.out.println(
				"��Ģ ����: �� �ڸ����� 1~9������ 3�ڸ����� �ִ� ����� 3�ڸ����� ���ϰ� �� �ڸ������� ������ Strike Ʋ���� Ball�� ���� ���̴�.\n ���� ��� ��ǻ�Ͱ� 771�� �� �ڸ� ���� ����� ����� 715�� ������� 1 Strike, 2 Ball �̴�.\n �翬�� 3 Strike�� ���̴�.");
		int[] com = new int[3];
		for (int i = 0; i < com.length; i++) {
			com[i] = (int) (Math.random() * 9) + 1;
		} // for ��������

		int strike = 0, ball = 0;
		Scanner sc = new Scanner(System.in);
		int[] you = new int[3];
		System.out.printf("�� ��ǻ�Ͱ� ���� 3�ڸ����� �����. �ʵ� 3�ڸ��� ���� ��� �� ���ƺ���.\n");

		while (true) {
			System.out.printf("�� ���⶧������~ �ٽ� �Ѵ� 3�ڸ��� ���� ��� �� ���ƺ���.\n");
			for (int i = 0; i < you.length; i++) {
				System.out.print(i + 1 + "��° ���ڸ� �Է��ϼ���.");
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
			System.out.printf("�� ���� ����� %d Strike , %d Ball �̾�.", strike, ball);
			if (strike == 3) {
				break;

			} else {
				strike = 0;
				ball = 0;
			}

		} // while
		System.out.println("���ϵ���� 3strike �����Դϴ�!");
	}// main

}
