package question;
import java.util.*;
public class Practice3 {
	public static void main(String[] args) {
		String[] arrName={"����","ö��","�浿","����","����"};
		int[] arrHeight = new int[5];
		int totalHeight =0;
		Scanner scanner = new Scanner(System.in);
		for(int i=0 ; i<arrHeight.length ; i++){
			System.out.print(arrName[i]+"�� Ű��? ");
			arrHeight[i]=scanner.nextInt();
			totalHeight += arrHeight[i];
		}
		System.out.print("���Ű : ");		
		System.out.println(totalHeight/arrName.length);
		scanner.close();
		int maxH=0, maxIndex=0;
		for(int i=0 ; i<arrHeight.length ; i++){
			if(arrHeight[i]>maxH){
				maxH = arrHeight[i];
				maxIndex = i;
			}
		}
		System.out.print("����ū�л�:"+arrName[maxIndex]);
		System.out.println("\t"+arrHeight[maxIndex]);
		int minH=maxH, minIndex=0;
		for(int i=0 ; i<arrHeight.length ; i++){
			if(arrHeight[i]<minH){
				minH = arrHeight[i];
				minIndex = i;
			}
		}
		System.out.printf("���������л�:%s\t%d",arrName[minIndex],arrHeight[minIndex]);
	}

}
