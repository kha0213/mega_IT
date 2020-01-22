package com.tj.ex4_object;

public class Card {
	private char kind; // ♥ ♠ ♣ ◆
	private int num; // A(1), 2~10, 11, 12, 13
	
	public Card(char kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "선택한 카드는 "+kind+num+"입니다.";
	}

//	@Override
//	public boolean equals(Object obj) {
//		if(obj!=null && obj instanceof Card) {
//			return this.kind==((Card)obj).kind && this.num==((Card)obj).num;
//		}else {
//			return false;
//		}
//	}// equals

	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Card) {
			boolean kindChk = this.kind == ((Card)obj).kind;
			boolean numChk = this.num == ((Card)obj).num;
			return kindChk && numChk;
		}else {
			return false;
		}
	}
	
}
