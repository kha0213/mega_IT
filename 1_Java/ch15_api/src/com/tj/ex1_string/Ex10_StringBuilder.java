package com.tj.ex1_string;

public class Ex10_StringBuilder {
	public static void main(String[] args) {
/*append(String str) : 문자열 str 추가
insert(int index, String str) : 특정 index에 문자열 str 추가
delete(int start, int end) : index위치 start부터 end앞 까지 삭제
deleteCharAt(int index) : index위치의 특정 문자 하나 삭제
int capacity() : 문자열 크기 반환	
ensureCapacity(int size) : 버퍼의 크기를 size만큼 늘리는 메소드
trimToSize() : 과도한 버퍼 크기를 적당하게 줄이는 메소드
*/
		StringBuilder strBuilder = new StringBuilder("abc");
//		StringBuffer strBuffer = new StringBuffer("abc");
		strBuilder.append("def");
		System.out.println(strBuilder);
		strBuilder.insert(3, "AAA");
		System.out.println(strBuilder);
		strBuilder.delete(2, 4);
		System.out.println(strBuilder);
		strBuilder.deleteCharAt(strBuilder.length()-1);
		System.out.println(strBuilder);
		strBuilder.append("dlkfjaklsssssf");
		System.out.println(strBuilder);
		int capacitySize = strBuilder.capacity();
		System.out.println("빌더의 가용 크기 : "+capacitySize);
	}
}
