package com.tj.ex6_file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ex02 {
	public static void main(String[] args)  {
		File file = new File("txtFile/a.txt");
		System.out.println(file.exists()? "존재하는 파일":"존재하지 않는 파일");
		try {
			System.out.println("절대경로: "+file.getAbsolutePath());
			System.out.println("표준경로: "+file.getCanonicalPath());
			Date thatTime = new Date(file.lastModified());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss");
			System.out.println("최종 수정일: "+sdf.format(thatTime));
			System.out.printf("%1$ty-%1$tm-%1$td(%1$ta) %1$tl : %1$tM : %1$tS", thatTime);
			System.out.println("파일 크기 : "+file.length());
			System.out.println("읽기 속성 : "+file.canRead());
			System.out.println("쓰기 속성 : "+file.canWrite());
			System.out.println("숨김 속성 : "+file.isHidden());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
