package com.tj.loop;
import java.util.*;
public class Ex11do_while {
	public static void main(String[] args) {
		int lotto; // 컴퓨터가 선택한 임의의 수
		int su; // 사용자가 수를 입력받을 수
		Scanner sc = new Scanner(System.in);
		lotto = (int)(Math.random()*45)+1;
		int min =1, max=45;
		do {
			System.out.print(min+"~"+max+"수를 맞춰보세요 : ");
			su = sc.nextInt();
			if(su<1 || su>45) {
				System.out.println("유효하지 않은 값입니다. 다시 입력하세요");
				continue;
			}
			else if(su>lotto) {
				System.out.println(su+"보다 더 작은 수를 입력해주세요");
				max = su-1;
			}
			else if(su<lotto) {
				System.out.println(su+"보다 더 큰수를 입력해주세요");
				min = su+1;
			}
		}
		while(su!=lotto);
		System.out.println("맞추셨습니다. Bye~~!!");
	}

}
