package question;
import java.util.*;
public class Example04_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
				
		
		System.out.println("����� ����������?");
		int kor = sc.nextInt();
		System.out.println("����� ����������?");
		int eng = sc.nextInt();
		System.out.println("����� ����������?");
		int mat = sc.nextInt();
		
		double avr = (double)(kor+eng+mat)/3;
		sc.close();
		
		if(kor>=avr) {
			System.out.printf("����� ��������(%d��)�� ���(%.2f��) �̻��Դϴ�.\n",kor, avr);
		}
		else {
			System.out.printf("����� ��������(%d��)�� ���(%.2f��) �����Դϴ�.\n",kor, avr);
		}
		if(eng>=avr) {
			System.out.printf("����� ��������(%d��)�� ���(%.2f��) �̻��Դϴ�.\n",eng, avr);
		}
		else {
			System.out.printf("����� ��������(%d��)�� ���(%.2f��) �����Դϴ�.\n",eng, avr);
		}
		if(mat>=avr) {
			System.out.printf("����� ��������(%d��)�� ���(%.2f��) �̻��Դϴ�.\n", mat,avr);
		}
		else {
			System.out.printf("����� ��������(%d��)�� ���(%.2f��) �����Դϴ�.\n",mat, avr);
		}
		
		
		
	}

}
