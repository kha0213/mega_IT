package com.tj.ex4_object;

public class Point3D implements Cloneable{
	private double x;
	private double y;
	private int z;
	
	public Point3D() {
		x=0;
		y=0;
		z=0;
	}
	
	public Point3D(double x, double y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Point3D) {
			boolean xChk = this.x==((Point3D)obj).x;
			boolean yChk = this.y==((Point3D)obj).y;
			boolean zChk = this.z==((Point3D)obj).z;
			return xChk && yChk && zChk;
		}else {
			return false;
		}
	}
	

	@Override
	public String toString() {
		return "ÁÂÇ¥°ª ["+x+", "+y+", "+z+"]" ;
	}
	
	
	
}
