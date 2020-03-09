package com.tj.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tj.ex.dao.FileboardDao;

public class BWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String fIp = request.getRemoteAddr();
		String fFileName = null;
		String filepath = request.getRealPath("fileboardUp");
		int fileSize = 1024*1024*10;
		
			try {
				MultipartRequest mRequest = new MultipartRequest(request, filepath, fileSize, "utf-8",new DefaultFileRenamePolicy());
				
				Enumeration<String> enumfile = mRequest.getFileNames();
				while(enumfile.hasMoreElements()) {
					String tempStr = enumfile.nextElement();
					fFileName = mRequest.getFilesystemName(tempStr);
				}
				if(fFileName == null) {
					fFileName = "pengsu1.jpg";
				}
				String mId = mRequest.getParameter("mId");
				String fTitle = mRequest.getParameter("fTitle");
				String fContent = mRequest.getParameter("fContent");
				
				FileboardDao fDao = FileboardDao.getInstance();
				if(fDao.insertBoard(mId, fTitle, fContent, fFileName, fIp)) {
					request.setAttribute("writeResult", "글쓰기 성공하였습니다.");
				}else {
					request.setAttribute("writeResult", "글쓰기 실패하였습니다.");
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
			
			InputStream is = null;
			OutputStream os = null;
			File boardfile = new File(filepath+"/"+fFileName);
			if (!fFileName.equals("pengsu1.jpg") && boardfile.exists()) {
			try {
				is = new FileInputStream(boardfile);
				os = new FileOutputStream("D:/mega_IT/git/mega_IT/7_jQuery/model2ex/WebContent/fileboardUp/"+fFileName);
				byte[] bs = new byte[(int) boardfile.length()];
				while(true) {
					
				int fileInt = is.read(bs);
				if(fileInt==-1) break;
				os.write(bs, 0, fileInt);
				}
				
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
					try {
						if(os!=null) os.close();
						if(is!=null) is.close();
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
			}
			
			
			}
		
		
	}

}
