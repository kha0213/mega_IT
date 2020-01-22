package com.tj.ex1_tryCatch;

public class Ex03_finally {
	public static void main(String[] args) {
		int[] iArr = { 0, 1, 2 };

		for (int idx = 0; idx <= iArr.length; idx++) {
			try {
				System.out.println("iArr[" + idx + "] = " + iArr[idx]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("���ܸ޼��� : "+e.getMessage());
			} finally { // �� ������
				System.out.println("try�� ���� �Ŀ��� �̺κ��ϰ�, catch�� ���� �Ŀ��� �̺κ��� �ݵ�� �� ������.");
			}
		}//for

	}
}
