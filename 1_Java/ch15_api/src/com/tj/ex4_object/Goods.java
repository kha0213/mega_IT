package com.tj.ex4_object;

public class Goods {
	private String goodsCode;
	private String goodsName;
	private int goodPrice;
	private int stockNum; // ������
	// Goods g = new Goods("a01","�����",1500,10)

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
		return goodsName + "(" + goodsCode + ") : " + goodPrice + "��. ���" + stockNum + "��";
	}

}
