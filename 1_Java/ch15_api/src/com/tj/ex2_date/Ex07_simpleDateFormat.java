package com.tj.ex2_date;

import java.text.*;
import java.util.*;

public class Ex07_simpleDateFormat {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� E���� a hh�� mm�� ss��");
		// y�� M�� 
		// d�� 
		// D �����о�����(1~365) 
		// E ���� 
		// a����/���� 
		// W���� ���° �� 
		// w ���� ���°��
		// H��(0~23)
		// h��(1~12)
		// m �� 
		// s��
		// S�и�������(1/1000)
		
		String todayStr = sdf.format(cal.getTime());  // cal.getTime() = cal�� date������ �ٲ� ��
		System.out.println(todayStr);
		
		
		
	}

}
