package question;

public class Example04_06 {
	public static void main(String[] args) {
		System.out.println("국어 영어 수학 랜덤 학점 발표하겠습니다.");

		int kor = (int) (Math.random() * 100);
		int eng = (int) (Math.random() * 100);
		int mat = (int) (Math.random() * 100);
		System.out.println("국어점수는" + kor + "점");
		System.out.println("영어점수는" + eng + "점");
		System.out.println("수학점수는" + mat + "점");

		System.out.println("당신의 국어 학점은~?");

		if (kor >= 75) {
			System.out.println("A학점입니다.!");
		} else if (kor >= 50) {
			System.out.println("B학점입니다.!");
		} else if (kor >= 25) {
			System.out.println("C학점입니다.!");
		} else {
			System.out.println("D학점이네요.!");
		}
		System.out.println("당신의 영어 학점은~?");

		if (eng >= 75) {
			System.out.println("A학점입니다.!");
		} else if (eng >= 50) {
			System.out.println("B학점입니다.!");
		} else if (eng >= 25) {
			System.out.println("C학점입니다.!");
		} else {
			System.out.println("D학점이네요.!");
		}
		System.out.println("당신의 수학 학점은~?");

		if (mat >= 75) {
			System.out.println("A학점입니다.!");
		} else if (mat >= 50) {
			System.out.println("B학점입니다.!");
		} else if (mat >= 25) {
			System.out.println("C학점입니다.!");
		} else {
			System.out.println("D학점이네요.!");
		}

	}

}