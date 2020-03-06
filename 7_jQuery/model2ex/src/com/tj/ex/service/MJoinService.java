package com.tj.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tj.ex.dao.MemberDao;
import com.tj.ex.dto.MemberDto;

public class MJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String filepath = request.getRealPath("memberPhotoUp");
		int filesize = 1024 * 1024 * 10;
		String mPhoto = null;
		try {
			MultipartRequest mRequest = new MultipartRequest(request, filepath, filesize, "utf-8",
					new DefaultFileRenamePolicy());
			String mId = mRequest.getParameter("mId");
			String mPw = mRequest.getParameter("mPw");
			String mName = mRequest.getParameter("mName");
			String mEmail = mRequest.getParameter("mEmail");
			Date mBirth = Date.valueOf(mRequest.getParameter("mBirth"));
			String mAddress = mRequest.getParameter("mAddress");
			Enumeration<String> param = mRequest.getFileNames();
			if (param.hasMoreElements()) {
				String temp = param.nextElement();
				mPhoto = mRequest.getFilesystemName(temp);
			}
			if (mPhoto == null) {
				mPhoto = "NOIMG.JPG";
			}

			MemberDao mDao = MemberDao.getInstance();
			MemberDto member = new MemberDto(mId, mPw, mName, mEmail, mPhoto, mBirth, mAddress, null);
			if (mDao.joinMember(member)) {
				request.setAttribute("joinResult", "회원가입성공! 로그인 이후 서비스를 이용하세요");
				request.setAttribute("mId", mId);
			} else {
				request.setAttribute("errorMsg", "회원가입실패 관리자에게 문의하세요");
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		InputStream is = null;
		OutputStream os = null;

		File saveFile = new File(filepath + "/" + mPhoto);
		if (!mPhoto.equals("NOIMG.JPG") && saveFile.exists()) {
			try {
				is = new FileInputStream(saveFile);
				os = new FileOutputStream("D:/mega_IT/git/mega_IT/7_jQuery/model2ex/WebContent/memberPhotoUp/"+mPhoto);
				byte[] bs = new byte[(int)saveFile.length()];
				while(true) {
					int read = is.read(bs);
					if(read==-1) break;
					os.write(bs, 0, read);
				}
				
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(os!=null) os.close();
					if(is!=null) os.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

}
