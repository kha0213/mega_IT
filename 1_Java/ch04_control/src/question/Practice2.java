package question;

import java.util.*;

public class Practice2 {
	public static void main(String[] args) {
		System.out.println("4���� Ű�� �˾ƺ�����, ����,����,�й�,������ Ű�� ������� �Է�����!");
		int[] hei = new int[4];
		String[] name = {"����", "����", "�й�", "����"};
		Scanner sc = new Scanner(System.in);

		for(int i=0;i<hei.length;i++) {
			System.out.println(name[i]+"�� Ű�� �Է��ϼ���.");
			hei[i]=sc.nextInt();
		}//for
		int heiSum=0;
		for(int i=0;i<hei.length;i++) {
		heiSum +=hei[i]; 
		}
		int heiAverage=heiSum/4;
		System.out.printf("4���� Ű�� ������ %d�̰� 4���� Ű�� ����� %d�̴�.\n", heiSum, heiAverage);
		
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
		
		System.out.printf("Ű�� ���� ū �л��� %s�̰� Ű�� %d�̴� \nŰ�� ���� ���� �л��� %s�̰� Ű�� %d�̴�\n",name[maxIndex],max,name[minIndex],min);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
//		Scanner sc = new Scanner(System.in);
//		System.out.println("���� ���� �й��� Ű�� �Է��ϰ� ��հ� ���� ū, ���� ����� �˾ƺ�����");
//		String[] name = { "����", "����", "�й�", "����", "����" };
//		int[] hei = new int[5];
//
//		for (int i = 0; i < 5; i++) {
//			System.out.println(name[i] + "�� Ű�� �Է��ϼ���.");
//			hei[i] = sc.nextInt();
//
//		} // for Ű �Է�
//		
//		int heiSum = 0;
//
//		for (int i = 0; i < hei.length; i++) {
//			heiSum += hei[i];
//		}//for heiSum
//				
//		System.out.println("�ټ����� Ű�� ����� : " + heiSum / name.length);
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
//		System.out.println("���� ū �л� "+name[maxInd]+ "�� Ű�� : "+ max);
//		System.out.println("���� ���� �л� "+name[minInd] +"�� Ű�� : "+ min);
//	}
//
//}
