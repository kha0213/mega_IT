package question;

import java.util.*;

public class Homework_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��ǻ�Ϳ� ���������� ������ �մϴ�.! �׸��ΰ� �����ø� -1�� �Է��ϼ���!");

		int you, com;
		int win=0, draw=0, lose=0;

		while (true) {
			com = (int) (Math.random() * 3);
			System.out.println("��ǻ�Ͱ� ������ ���� ���Ͽ����ϴ�.\n ������ 0 ������ 1 ���� 2�� ���� �˴ϴ�.\n(Ȥ�ö� ������ �׸��ΰ� �����ø� -1 �� �Է��ϼ���~!)");
			you = sc.nextInt();

			
			if (you == 0) {
				System.out.println("�ʴ� : ����");
			} else if (you == 1) {
				System.out.println("�ʴ� : ����");
			} else if (you == 2) {
				System.out.println("�ʴ� : ��");
			} else if (you == -1 ) {
				break;
			} else {
				System.out.println("����!!!! �̻��� �� ���� ���� �ٽ� ��!!\n");
				continue;
			}
			if (com == 0) {
				System.out.println("��ǻ�� : ����");
			} else if (com == 1) {
				System.out.println("��ǻ�� : ����");
			} else {
				System.out.println("��ǻ�� : ��");
			}
			
			if (com==you) {
				System.out.println("���׿� �ٽ� �� �� �ұ��~?\n");
				draw++;
			} else if(you==0 && com==1 || you==1 && com==2 || you==2 && com==0) {
				System.out.println("��ǻ���� �¸��Դϴ�.~ �ٽ� �� �� �ұ��~?\n");
				lose++;
			} else {
				System.out.println("���� �¸��Դϴ�~!~! ���ϵ����. �ٽ� �� �� �ұ��~?\n");
				win++;
			}

		}//while
		System.out.printf("WIN : %dȸ  DRAW : %dȸ  LOSE : %dȸ\n",win,draw,lose);
		System.out.println("-1�� �Է��ϼ̽��ϴ� �ý����� �����մϴ�.");

	}

}
