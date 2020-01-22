package question;
import java.util.*;
public class Practice3 {
	public static void main(String[] args) {
		String[] arrName={"영희","철수","길동","영수","말자"};
		int[] arrHeight = new int[5];
		int totalHeight =0;
		Scanner scanner = new Scanner(System.in);
		for(int i=0 ; i<arrHeight.length ; i++){
			System.out.print(arrName[i]+"의 키는? ");
			arrHeight[i]=scanner.nextInt();
			totalHeight += arrHeight[i];
		}
		System.out.print("평균키 : ");		
		System.out.println(totalHeight/arrName.length);
		scanner.close();
		int maxH=0, maxIndex=0;
		for(int i=0 ; i<arrHeight.length ; i++){
			if(arrHeight[i]>maxH){
				maxH = arrHeight[i];
				maxIndex = i;
			}
		}
		System.out.print("가장큰학생:"+arrName[maxIndex]);
		System.out.println("\t"+arrHeight[maxIndex]);
		int minH=maxH, minIndex=0;
		for(int i=0 ; i<arrHeight.length ; i++){
			if(arrHeight[i]<minH){
				minH = arrHeight[i];
				minIndex = i;
			}
		}
		System.out.printf("가장작은학생:%s\t%d",arrName[minIndex],arrHeight[minIndex]);
	}

}
