package com.tj.ex2_date;

import java.util.Calendar;

import com.tj.ex1_string.Friend;

public class Ex06 {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("ȫ�浿", "010-9999-9999", "12-11"), new Friend("��浿", "010-9999-8999", "2-11"),
				new Friend("�ڱ浿", "010-9999-7999", "11-17"), };
		// 1.���� ������ �� 2.�̹��� ������ ��
		Calendar today = Calendar.getInstance();
		
		
		
		int month = today.get(Calendar.MONTH) + 1; // 1~12��
		int day = today.get(Calendar.DAY_OF_MONTH); // 1~31��
		
		String monthStr = (month<10)? ("0"+month):""+month;
		String dayStr = (day<10)? ("0"+day) : ""+day;
		String todayStr = monthStr+"-"+dayStr;
		System.out.println("������ "+todayStr);
		
		boolean searchOk = false;
		
		for(Friend f : friends) {
			if(f.getBirth().equals(todayStr)) {
				System.out.println("~~~�����ؿ� ���� �����̿���~~~");
				System.out.println(f.infoString());
				searchOk = true;
			}//if
		}//for
		if(!searchOk) {
			System.out.println("������ �ƹ��� �����!");
		}//if

	}
}
