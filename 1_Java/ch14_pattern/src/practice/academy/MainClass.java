package practice.academy;

public class MainClass {
	public static void main(String[] args) {
		Student st1 = new Student("30301", "������", "��ȭ��");
		Student st2 = new Student("30302", "������", "Java��");
		Gangsa gs1 = new Gangsa("J01", "ȫ�浿", "java");
		Gangsa gs2 = new Gangsa("J02", "��ö��", "db");
		Staff s = new Staff("A01", "������", "�������");
		Person[] person = {st1, st2, gs1, gs2, s};
		System.out.println("�����ð��̴� �� ���սô�");
		for(Person p : person)
			p.jobs();
		System.out.println("������ �� ������ �� ����");
		for(Person p : person)
			p.getMoney();
		System.out.println("�ñ��ϸ� ����Ʈ");
		for(Person p : person)
			p.print();
	}
}
