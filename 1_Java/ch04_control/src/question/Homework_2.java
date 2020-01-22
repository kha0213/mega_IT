package question;

public class Homework_2 {

	public static void main(String[] args) {
	
		int sum=0;
		int i=0,j=0;
		for(i=1;i<=10;i++) {
			System.out.print("(");
			for(j=1;j<i+1;j++) {
				if(j!=1) {
				System.out.printf("+%d",j);}
				else {
					System.out.printf("%d",j);
				}
				sum+=j;
			}//for
			if(i!=10) {
			System.out.print(")+");
			}
			else {
				System.out.print(")");
			}
			
		}//for
		System.out.println("="+sum);
	}

}
