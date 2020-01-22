package com.tj.ex4_object;

public class Goods {
	private String goodsCode;
	private String goodsName;
	private int goodPrice;
	private int stockNum; // 재고수량
	// Goods g = new Goods("a01","새우깡",1500,10)

	public Goods(String goodsCode, String goodsName, int goodPrice, int stockNum) {
		super();
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.goodPrice = goodPrice;
		this.stockNum = stockNum;
	}

	public Goods() {
	}

	@Override
	public String toString() {
		return goodsName + "(" + goodsCode + ") : " + goodPrice + "원. 재고" + stockNum + "개";
	}

}
