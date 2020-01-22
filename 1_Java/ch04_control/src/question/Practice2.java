package question;

import java.util.*;

public class Practice2 {
	public static void main(String[] args) {
		System.out.println("4명의 키를 알아볼꺼야, 영롱,정훈,학배,서원의 키를 순서대로 입력해줘!");
		int[] hei = new int[4];
		String[] name = {"영롱", "정훈", "학배", "서원"};
		Scanner sc = new Scanner(System.in);

		for(int i=0;i<hei.length;i++) {
			System.out.println(name[i]+"의 키를 입력하세요.");
			hei[i]=sc.nextInt();
		}//for
		int heiSum=0;
		for(int i=0;i<hei.length;i++) {
		heiSum +=hei[i]; 
		}
		int heiAverage=heiSum/4;
		System.out.printf("4명의 키의 총합은 %d이고 4명의 키의 평균은 %d이다.\n", heiSum, heiAverage);
		
		int max=0,min=999,maxIndex=0,minIndex=0;
		
		
		for(int i=0;i<hei.length;i++) {
			
				if(max<hei[i]) {
					max = hei[i];
					maxIndex = i;
					
				}//if
				else if(min>hei[i]) {
					min = hei[i];
					minIndex = i;
				}
			
			
		}//for
		
		System.out.printf("키가 가장 큰 학생은 %s이고 키는 %d이다 \n키가 가장 작은 학생은 %s이고 키는 %d이다\n",name[maxIndex],max,name[minIndex],min);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
//		Scanner sc = new Scanner(System.in);
//		System.out.println("영롱 석원 학배의 키를 입력하고 평균과 가장 큰, 작은 사람을 알아볼께요");
//		String[] name = { "영롱", "석원", "학배", "영준", "서원" };
//		int[] hei = new int[5];
//
//		for (int i = 0; i < 5; i++) {
//			System.out.println(name[i] + "의 키를 입력하세요.");
//			hei[i] = sc.nextInt();
//
//		} // for 키 입력
//		
//		int heiSum = 0;
//
//		for (int i = 0; i < hei.length; i++) {
//			heiSum += hei[i];
//		}//for heiSum
//				
//		System.out.println("다섯명의 키의 평균은 : " + heiSum / name.length);
//		sc.close();
//
//		int max = hei[0], min = hei[0];
//		int maxInd = 0, minInd=0;
//
//		for (int j = 0; j < hei.length; j++) {
//			if (hei[j] >= max) {
//				max = hei[j];
//				maxInd = j;
//			} else if (hei[j] <= min) {
//				min = hei[j];
//				minInd = j;
//
//			}
//		} // for
//		System.out.println("가장 큰 학생 "+name[maxInd]+ "이 키는 : "+ max);
//		System.out.println("가장 작은 학생 "+name[minInd] +"이 키는 : "+ min);
//	}
//
//}
