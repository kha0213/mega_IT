package com.tj.ex1_string;

public class Ex02_stringApiMethod {
	public static void main(String[] args) {
		String str1 ="abcXabc";
		String str2 =new String("AbcXabc");
		String str3 = "   ja va   ";
		String str4 = "abcXabcXabcXabc";
		
/*		��String�� �ֿ� ��ɵ�(�޼ҵ�)
		String concat(String str) : ����� ���ڿ��� str���ڿ��� ����
		String substring(int begin) : ������ġ���� ������������ ���ڿ��� ��ȯ
		int length() : ���ڿ� ���̸� ��ȯ
		String toUpperCase() : �빮�ڷ� ��ȯ
		String toLowerCase() : �ҹ��ڷ� ��ȯ
		char charAt(int index) : index ��ġ�� ���ڸ� ��ȯ
		int indexOf(char ch) : ù��° ch������ ��ġ�� ��ȯ
		int lastIndexOf(char ch) : ������ ch������ ��ġ�� ��ȯ
		boolean equals(String str) : �����ȹ��ڿ��� str���ڿ��� ������ ��
		boolean equalslgnoreCase(String str) : ��ҹ��ڱ��о��� �����ȹ��ڿ��� str���ڿ��� ������ ��
		String trim() : ���ڿ� �յ� ��������
		String replace(char old, char new) : ���ڿ� ���� old���ڸ� new���ڷ� ��ȯ
		String  replaceAll(String old, String new) : ���ڿ� ���� old���ڿ��� new�� ��ȯ
		*/
		
		System.out.println("1."+str1.concat(str2)); //str1+str2
//		System.out.println("2. "str1.subSequence(beginIndex, endIndex));
		System.out.println("2. "+str1.substring(3, 5)); //3��(4��°)���� 5�� ��!!����.
		System.out.println("3. "+str1.substring(2)); // 2��(4��°)���� ������
		System.out.println("4. "+str1.length()); // ���ڿ� ����
		System.out.println("5. "+str1.toUpperCase()); //�빮�ڷ� ����
		System.out.println("6. "+str1.toLowerCase()); // �ҹ��ڷ� ����
		System.out.println("7. "+str1.charAt(3)); // 3��(4��°)�ε����� ���ڸ� ��������
		System.out.println("8. "+str1.indexOf('b')); // ù��° b�� ������ �ε��� ��ġ
		System.out.println("9. "+str1.lastIndexOf('b'));
		System.out.println("10. "+str4.indexOf('c', 4)); // 4�� �ε������� �˻��Ͽ� ù b�� ������ �ε���
		System.out.println("11. "+str2.indexOf("bc")); // ù��° bc�� ������ �ε���
		System.out.println("12. "+str1.equals(str2));
		System.out.println("13. "+str1.equalsIgnoreCase(str2));
		System.out.println("14. "+str3.trim());
		System.out.println("15. "+str4.replace('b', '��'));
		System.out.println("16. "+str4.replace("abc", "�շ�"));
		System.out.println("str1: "+str1);
		System.out.println("str2: "+str2);
		System.out.println("str3: "+str3);
		System.out.println("str4: "+str4);
	} 

}
