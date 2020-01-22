package com.tj.ex1_list;

import java.util.ArrayList;

public class Ex01_arrayList {
	public static void main(String[] args) {
		String[] array = new String[3];
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "str2";
		
		for(int idx=0;idx<array.length;idx++) {
			System.out.println(idx+"번째 "+array[idx]);
		}
		
		ArrayList<String> arrayList = new ArrayList<String>(); //스트링 arrayList
		arrayList.add("str0"); // 0번 인덱스
		arrayList.add("str1"); // 1번 인덱스
		arrayList.add("str2"); // 2번 인덱스
		arrayList.add(1, "str111111111111"); //1번인덱스로 중간에 껴들어감
		arrayList.set(1, "덥다더워");
		for(String a : arrayList) {
		System.out.println(a);
		}
		
		for(int idx=0;idx<arrayList.size();idx++) {
			System.out.println(idx+"번째"+arrayList.get(idx));
		}
		arrayList.remove(1); //1번 인덱스 arrayList를 지우고 앞으로 당겨짐
		for(int idx=0;idx<arrayList.size();idx++) {
			System.out.println(idx+"번째"+arrayList.get(idx));
		}
		System.out.println(arrayList);
		arrayList.clear(); //arrayList의 모든 데이터를 지움 == size()를 0으로
		if(arrayList.isEmpty()) {
			System.out.println("arrayList.clear()됨");
		}
		arrayList=null; //객체 주소가 사라져서 추가가 안됨
		
	}
}
