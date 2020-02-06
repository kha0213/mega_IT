package com.tj.ex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		String[] P = new String[N];
		for (int i = 0; i < N; i++) {
			P[i] = sc.nextLine();
		}
		Arrays.sort(P, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] o1r = o1.split(" ");
				int o1su = Integer.parseInt(o1r[1]) - Integer.parseInt(o1r[0]);
				String[] o2r = o2.split(" ");
				int o2su = Integer.parseInt(o2r[1]) - Integer.parseInt(o2r[0]);
				return o1su - o2su;
			}
		});
		int cnt = 0;
		
		int[] result = new int[100000];
		
		boolean b = true;
		for (int i = 0; i < P.length; i++) {
			for (int j = Integer.parseInt(P[i].split(" ")[0]); j < Integer.parseInt(P[i].split(" ")[1]); j++) {
				if (result[j] == 1) {
					b = false;
				}
			}
			if (b) {
				cnt++;
				for (int j = Integer.parseInt(P[i].split(" ")[0]); j < Integer.parseInt(P[i].split(" ")[1]); j++) {
					result[j] = 1;
				}
			}
			b = true;
		}

		System.out.println(cnt);

	}
}
