package question;

public class Example04_06 {
	public static void main(String[] args) {
		System.out.println("���� ���� ���� ���� ���� ��ǥ�ϰڽ��ϴ�.");

		int kor = (int) (Math.random() * 100);
		int eng = (int) (Math.random() * 100);
		int mat = (int) (Math.random() * 100);
		System.out.println("����������" + kor + "��");
		System.out.println("����������" + eng + "��");
		System.out.println("����������" + mat + "��");

		System.out.println("����� ���� ������~?");

		if (kor >= 75) {
			System.out.println("A�����Դϴ�.!");
		} else if (kor >= 50) {
			System.out.println("B�����Դϴ�.!");
		} else if (kor >= 25) {
			System.out.println("C�����Դϴ�.!");
		} else {
			System.out.println("D�����̳׿�.!");
		}
		System.out.println("����� ���� ������~?");

		if (eng >= 75) {
			System.out.println("A�����Դϴ�.!");
		} else if (eng >= 50) {
			System.out.println("B�����Դϴ�.!");
		} else if (eng >= 25) {
			System.out.println("C�����Դϴ�.!");
		} else {
			System.out.println("D�����̳׿�.!");
		}
		System.out.println("����� ���� ������~?");

		if (mat >= 75) {
			System.out.println("A�����Դϴ�.!");
		} else if (mat >= 50) {
			System.out.println("B�����Դϴ�.!");
		} else if (mat >= 25) {
			System.out.println("C�����Դϴ�.!");
		} else {
			System.out.println("D�����̳׿�.!");
		}

	}

}