package com.tj.ex4_object;

public class Point3DMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D p1 = new Point3D(10.1, 5.5, 1);
		Point3D p2 = p1;
		Point3D p3 = new Point3D(9.7, 5.5, 2);
		Point3D p4 = new Point3D();
		Point3D p5 = (Point3D) p1.clone();
		Point3D[] p = { p1, p2, p3, p4, p5 };
		int idx=0;
		for (Point3D point : p) {
			System.out.println("p"+(++idx)+" "+point);
		}
		if (p1 == p2) {
			System.out.println("p1과 p2주소가 같네");
		} else {
			System.out.println("p1과 p2주소가 다르네");
		}
		if (p1.equals(p2)) {
			System.out.println("p1과 p2좌표가 같네");
		} else {
			System.out.println("p1과 p2좌표가 다르네");
		}

		if (p1 == p5) {
			System.out.println("p1과 p5주소가 같네");
		} else {
			System.out.println("p1과 p5주소가 다르네");
		}
		if (p1.equals(p5)) {
			System.out.println("p1과 p5좌표가 같네");
		} else {
			System.out.println("p1과 p5좌표가 다르네");
		}

	}
}
