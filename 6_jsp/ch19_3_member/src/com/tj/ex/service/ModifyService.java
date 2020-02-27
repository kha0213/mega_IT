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
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tj.ex.dao.Member_dao;

public class ModifyService implements MService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String saveDirectory = request.getRealPath("img");
		int maxSize = 1024 * 1024 * 10;
		String mPhoto = null;
		boolean fileCopy = false;
		try {
			MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "utf-8",
					new DefaultFileRenamePolicy());

			String mId = mRequest.getParameter("mId");
			String mPw = mRequest.getParameter("mPw");
			String mName = mRequest.getParameter("mName");
			String mEmail = mRequest.getParameter("mEmail");
			String mAddress = mRequest.getParameter("mAddress");
			String mBirthStr = mRequest.getParameter("mBirth");
			Date mBirth = null;
			if (!mBirthStr.equals("")) {
				mBirth = Date.valueOf(mBirthStr);
			}
			Enumeration<String> param = mRequest.getFileNames();
			String temp = param.nextElement();
			mPhoto = mRequest.getFilesystemName(temp);
			if (mPhoto == null || mPhoto.equals("")) {
				mPhoto = mRequest.getParameter("dbmPhoto");
			} else {
				fileCopy = true;
			}
			Member_dao mDao = Member_dao.getInstance();
			int result = mDao.modifyMember(mPw, mName, mEmail, mPhoto, mBirth, mAddress, mId);
			if (result == Member_dao.FAIL) {
				request.setAttribute("errorMsg", "정보수정에 실패하였습니다.");
			} else {
				request.setAttribute("modifyResult", "정보수정에 성공하셨습니다.");
			}
			HttpSession session = request.getSession();
			session.setAttribute("member", mDao.getMember(mId));

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// 파일 카피
		if (fileCopy == false) {
			return;
		}
		InputStream is = null;
		OutputStream os = null;
		File saveFile = new File(saveDirectory + "/" + mPhoto);
		if (saveFile.exists()) {
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

	}

}
