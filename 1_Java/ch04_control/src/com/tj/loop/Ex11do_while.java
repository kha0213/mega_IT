package com.tj.loop;
import java.util.*;
public class Ex11do_while {
	public static void main(String[] args) {
		int lotto; // ��ǻ�Ͱ� ������ ������ ��
		int su; // ����ڰ� ���� �Է¹��� ��
		Scanner sc = new Scanner(System.in);
		lotto = (int)(Math.random()*45)+1;
		int min =1, max=45;
		do {
			System.out.print(min+"~"+max+"���� ���纸���� : ");
			su = sc.nextInt();
			if(su<1 || su>45) {
				System.out.println("��ȿ���� ���� ���Դϴ�. �ٽ� �Է��ϼ���");
				continue;
			}
			else if(su>lotto) {
				System.out.println(su+"���� �� ���� ���� �Է����ּ���");
				max = su-1;
			}
			else if(su<lotto) {
				System.out.println(su+"���� �� ū���� �Է����ּ���");
				min = su+1;
			}
		}
		while(su!=lotto);
		System.out.println("���߼̽��ϴ�. Bye~~!!");
	}

}
