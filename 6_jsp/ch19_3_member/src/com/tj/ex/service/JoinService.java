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
import com.tj.ex.dao.Member_dao;

public class JoinService implements MService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String saveDirectory = request.getRealPath("img");
		int maxSize = 1024 * 1024 * 10;
		String mPhoto = null;
		try {
			MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "utf-8",
					new DefaultFileRenamePolicy());

			Member_dao mDao = Member_dao.getInstance();
			String mId = mRequest.getParameter("mId");

			int result = mDao.mIdConfirm(mId);
			if (result == Member_dao.EXISTENT) {
				request.setAttribute("errorMsg", "중복된 아이디라 가입이 불가능합니다.");
				return;
			}
			String mPw = mRequest.getParameter("mPw");
			String mName = mRequest.getParameter("mName");
			String mEmail = mRequest.getParameter("mEmail");
			String mAddress = mRequest.getParameter("mAddress");
			String mBirthStr = mRequest.getParameter("mBirth");
			Date mBirth = null;
			if (mBirthStr != null && !mBirthStr.equals("")) {
				mBirth = Date.valueOf(mBirthStr);
			}

			Enumeration<String> param = mRequest.getFileNames();
			if (param.hasMoreElements()) {
				String temp = param.nextElement();
				mPhoto = mRequest.getFilesystemName(temp);
			}
			if (mPhoto == null) {
				mPhoto = "NOIMG.JPG";
			}
			result = mDao.joinMember(mId, mPw, mName, mEmail, mPhoto, mBirth, mAddress);
			if (result == Member_dao.FAIL) {
				request.setAttribute("errorMsg", "회원가입이 실패되었습니다. 관리자에게 문의하세요");
				return;
			} else {
				request.setAttribute("joinResult", "회원가입을 성공하였습니다. 로그인 이후에 서비스 이용해주세요");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// 파일 카피

		InputStream is = null;
		OutputStream os = null;
		File saveFile = new File(saveDirectory + "/" + mPhoto);
		if (!mPhoto.equals("NOIMG.JPG") && saveFile.exists()) {
			try {
				is = new FileInputStream(saveFile);
				os = new FileOutputStream("D:/mega_IT/git/mega_IT/6_jsp/ch19_3_member/WebContent/img/" + mPhoto);
				byte[] bs = new byte[(int) saveFile.length()];
				while (true) {
					int nReadCnt = is.read(bs);
					if (nReadCnt == -1)
						break;
					os.write(bs, 0, nReadCnt);
				}

			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (os != null)
						os.close();
					if (is != null)
						is.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}

		} // 파일카피 끝

	} // override

}
