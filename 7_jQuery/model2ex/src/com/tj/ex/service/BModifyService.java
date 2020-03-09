package com.tj.ex.service;

import java.io.File;
import java.io.FileInputStream;
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

public class BModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String fIp = request.getRemoteAddr();
		String filepath = request.getRealPath("fileboardUp");
		int maxSize = 1024*1024*10;
		MultipartRequest mRequest = null;
		String fFileName = null;
		try {
			mRequest = new MultipartRequest(request, filepath, maxSize, "utf-8",new DefaultFileRenamePolicy());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		int fId = Integer.parseInt(mRequest.getParameter("fId"));
		String mId = mRequest.getParameter("mId");
		String fTitle = mRequest.getParameter("fTitle");
		String fContent = mRequest.getParameter("fContent");
		FileboardDao fDao = FileboardDao.getInstance();
		if(request.getParameter("fileChk")!=null) {
			if(fDao.modifyBoardNotFile(fId, fTitle, fContent, fIp)) {
				request.setAttribute("modifyResult", mId+"님 글 수정 성공");
			}else {
				request.setAttribute("modifyResult", mId+"님 글 수정 실패");
			}
		}else {
			Enumeration<String> enumfile = mRequest.getFileNames();
			if(enumfile.hasMoreElements()) {
				String tempStr = enumfile.nextElement();
				fFileName = mRequest.getFilesystemName(tempStr);
			}
			if(fFileName == null) {
				fFileName = "pengsu1.jpg";
			}
			if(fDao.modifyBoardPlusFile(fId, fTitle, fContent, fFileName, fIp)) {
				request.setAttribute("modifyResult", mId+"님 글 수정 성공");
			}else {
				request.setAttribute("modifyResult", mId+"님 글 수정 실패");
			}
			InputStream is = null;
			OutputStream os = null;
			File file = new File(filepath+"/"+fFileName);
			if(!fFileName.equals("pengsu1.jpg") && file.exists()) {
				try {
					is = new FileInputStream(file);
					os = new FileOutputStream("D:\\mega_IT\\git\\mega_IT\\7_jQuery\\model2ex\\WebContent\\fileboardUp/"+fFileName);
					byte[] bs = new byte[(int)file.length()];
					
					while(true) {
						int fileInt = is.read(bs);
						if(fileInt == -1) break;
						os.write(bs, 0, fileInt);
					}
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}finally {
					try {
						if(os!=null) os.close();
						if(is!=null) is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				
				
			}
			
			
			
			
		}
		
		
	}

}
