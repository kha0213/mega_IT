package question;

import java.util.*;

public class Practice4 {
	public static void main(String[] args) {
		System.out.println("�Է��� �ݾ��� 5����, ����, ��õ�� �������� �и��غ�����\n ���� �Է����ּ���");
		Scanner sc = new Scanner(System.in);
		int you = sc.nextInt();
		

		int[] money = new int[4];
		

		money[0] = you/50000;
		you -= money[0]*50000;
		money[1] = you/10000;
		you -= money[1]*10000;
		money[2] = you/5000;
		you -= money[2]*5000;
		
		System.out.printf("5����¥�� %d�� , ����¥�� %d ��\n",money[0],money[1]);

		sc.close();
	}

}
