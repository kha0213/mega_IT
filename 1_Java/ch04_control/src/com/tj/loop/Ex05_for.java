package com.tj.loop;

public class Ex05_for {
	public static void main(String[] args) {
		for(int i=1;i<=10;i++) {
			if(i==3)
				//break; �극��ũ�� for�� ������
				continue; //��Ƽ���� �ٷ� for�� �ٽ� ���ư���
			System.out.println(i);
		}
	}

}
