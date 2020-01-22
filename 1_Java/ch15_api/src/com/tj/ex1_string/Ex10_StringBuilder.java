package com.tj.ex1_string;

public class Ex10_StringBuilder {
	public static void main(String[] args) {
/*append(String str) : ���ڿ� str �߰�
insert(int index, String str) : Ư�� index�� ���ڿ� str �߰�
delete(int start, int end) : index��ġ start���� end�� ���� ����
deleteCharAt(int index) : index��ġ�� Ư�� ���� �ϳ� ����
int capacity() : ���ڿ� ũ�� ��ȯ	
ensureCapacity(int size) : ������ ũ�⸦ size��ŭ �ø��� �޼ҵ�
trimToSize() : ������ ���� ũ�⸦ �����ϰ� ���̴� �޼ҵ�
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
		System.out.println("������ ���� ũ�� : "+capacitySize);
	}
}
