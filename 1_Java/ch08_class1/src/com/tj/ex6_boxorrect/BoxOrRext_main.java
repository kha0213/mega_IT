package com.tj.ex6_boxorrect;

public class BoxOrRext_main {
	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(5, 6, 10);
		BoxOrRect rect = new BoxOrRect(10, 5);
		box.calVolume();
		rect.calVolume();
		System.out.println("가로: "+box.getWidth()+" 세로: "+box.getHeight()+" 높이: "+box.getDepth()+" 부피: "+box.getVolume());
		System.out.println("가로: "+rect.getWidth()+" 세로: "+rect.getHeight()+" 높이: "+rect.getDepth()+" 부피: "+rect.getVolume());
	}

}
