package com.tj.ex04_acor;
// DMB�ۼ��źҰ�, 3G, TV������ ��ž��
public class AModel implements IAcor {
	private String model = "A��";
	@Override
	public void dmbReceive() {
		System.out.println(model+"�� DMB�ۼ��źҰ�");
	}

	@Override
	public void lte() {
		System.out.println(model+"�� 3G��");
	}

	@Override
	public void tvremoteControl() {
		System.out.println(model+"�� TV������ ��ž��");
	}

}
