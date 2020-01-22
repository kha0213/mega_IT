package question;
import java.util.*;
public class Example04_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
				
		
		System.out.println("당신의 국어점수는?");
		int kor = sc.nextInt();
		System.out.println("당신의 영어점수는?");
		int eng = sc.nextInt();
		System.out.println("당신의 수학점수는?");
		int mat = sc.nextInt();
		
		double avr = (double)(kor+eng+mat)/3;
		sc.close();
		
		if(kor>=avr) {
			System.out.printf("당신의 국어점수(%d점)는 평균(%.2f점) 이상입니다.\n",kor, avr);
		}
		else {
			System.out.printf("당신의 국어점수(%d점)는 평균(%.2f점) 이하입니다.\n",kor, avr);
		}
		if(eng>=avr) {
			System.out.printf("당신의 영어점수(%d점)는 평균(%.2f점) 이상입니다.\n",eng, avr);
		}
		else {
			System.out.printf("당신의 영어점수(%d점)는 평균(%.2f점) 이하입니다.\n",eng, avr);
		}
		if(mat>=avr) {
			System.out.printf("당신의 수학점수(%d점)는 평균(%.2f점) 이상입니다.\n", mat,avr);
		}
		else {
			System.out.printf("당신의 수학점수(%d점)는 평균(%.2f점) 이하입니다.\n",mat, avr);
		}
		
		
		
	}

}
