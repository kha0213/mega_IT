package com.tj.ex;

public class Ex1111 {

	public int solution(String s) {
		// s = aabbaccc 1개 단위로 자른경우 2a2ba3c - a2b2ac3
		int resultLength = 1; // 첫번 째 문자는 무조건 필요
		boolean eqFlag = false;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.substring(i, i + 1).equals(s.substring(i + 1, i + 2))) {
				// i 위치에서 다음문자와 일치하는 경우
				// 숫자를 붙히고 길이가 +1 됨, 직전 위치에도 일치하는 경우였으면 +1 안함.
				if (!eqFlag) {
					// System.out.println(123);
					resultLength++;
					eqFlag = true;
				}
			} else {
				// i 위치에서 다음문자와 일치하지 않는 경우
				// 새 문자 추가되고 길이 + 1됨.
				resultLength++;
				eqFlag = false;
			}
		}

		return resultLength;
	}

	public static void main(String[] args) {

		System.out.println(new Ex1111().solution("aabbaccccvvcccv"));
	}

}
