package com.tj.ex1_string;

public class Ex02_stringApiMethod {
	public static void main(String[] args) {
		String str1 ="abcXabc";
		String str2 =new String("AbcXabc");
		String str3 = "   ja va   ";
		String str4 = "abcXabcXabcXabc";
		
/*		※String의 주요 기능들(메소드)
		String concat(String str) : 저장된 문자열과 str문자열을 결합
		String substring(int begin) : 시작위치부터 마지막까지의 문자열을 반환
		int length() : 문자열 길이를 반환
		String toUpperCase() : 대문자로 반환
		String toLowerCase() : 소문자로 반환
		char charAt(int index) : index 위치의 문자를 반환
		int indexOf(char ch) : 첫번째 ch문자의 위치를 반환
		int lastIndexOf(char ch) : 마지막 ch문자의 위치를 반환
		boolean equals(String str) : 지정된문자열과 str문자열이 같은지 비교
		boolean equalslgnoreCase(String str) : 대소문자구분없이 지정된문자열과 str문자열이 같은지 비교
		String trim() : 문자열 앞뒤 공백제거
		String replace(char old, char new) : 문자열 내의 old문자를 new문자로 반환
		String  replaceAll(String old, String new) : 문자열 내의 old문자열을 new로 반환
		*/
		
		System.out.println("1."+str1.concat(str2)); //str1+str2
//		System.out.println("2. "str1.subSequence(beginIndex, endIndex));
		System.out.println("2. "+str1.substring(3, 5)); //3번(4번째)부터 5번 앞!!까지.
		System.out.println("3. "+str1.substring(2)); // 2번(4번째)부터 끝까지
		System.out.println("4. "+str1.length()); // 문자열 길이
		System.out.println("5. "+str1.toUpperCase()); //대문자로 변경
		System.out.println("6. "+str1.toLowerCase()); // 소문자로 변경
		System.out.println("7. "+str1.charAt(3)); // 3번(4번째)인덱스의 문자를 가져오기
		System.out.println("8. "+str1.indexOf('b')); // 첫번째 b가 나오는 인덱스 위치
		System.out.println("9. "+str1.lastIndexOf('b'));
		System.out.println("10. "+str4.indexOf('c', 4)); // 4번 인덱스부터 검색하여 첫 b가 나오는 인덱스
		System.out.println("11. "+str2.indexOf("bc")); // 첫번째 bc가 나오는 인덱스
		System.out.println("12. "+str1.equals(str2));
		System.out.println("13. "+str1.equalsIgnoreCase(str2));
		System.out.println("14. "+str3.trim());
		System.out.println("15. "+str4.replace('b', '♡'));
		System.out.println("16. "+str4.replace("abc", "롱롱"));
		System.out.println("str1: "+str1);
		System.out.println("str2: "+str2);
		System.out.println("str3: "+str3);
		System.out.println("str4: "+str4);
	} 

}
