package com.tj.ex6_boxorrect;

public class BoxOrRext_main {
	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(5, 6, 10);
		BoxOrRect rect = new BoxOrRect(10, 5);
		box.calVolume();
		rect.calVolume();
		System.out.println("����: "+box.getWidth()+" ����: "+box.getHeight()+" ����: "+box.getDepth()+" ����: "+box.getVolume());
		System.out.println("����: "+rect.getWidth()+" ����: "+rect.getHeight()+" ����: "+rect.getDepth()+" ����: "+rect.getVolume());
	}

}
