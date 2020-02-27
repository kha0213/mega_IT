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

public class JoinService2_teacher implements MService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String saveDirectory = request.getRealPath("img");
		int maxSize = 1024 * 1024 * 10;
		String mPhoto = null;

		String mId = null, mPw = null, mName = null, mEmail = null, mAddress = null;
		Date mBirth = null;

		try {
			MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "utf-8",
					new DefaultFileRenamePolicy());

			mId = mRequest.getParameter("mId");
			mPw = mRequest.getParameter("mPw");
			mName = mRequest.getParameter("mName");
			mEmail = mRequest.getParameter("mEmail");
			mAddress = mRequest.getParameter("mAddress");
			mBirth = Date.valueOf(mRequest.getParameter("mBirth"));

			Enumeration<String> param = mRequest.getFileNames();
			if (param.hasMoreElements()) {
				String temp = param.nextElement();
				mPhoto = mRequest.getFilesystemName(temp);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// 파일 카피
		if (mPhoto != null) {
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
			} else {
				mPhoto = "NOIMG.JPG";
			}

		} // 파일카피 끝

		Member_dao mDao = Member_dao.getInstance();
		request.setAttribute("joinResult", mDao.joinMember(mId, mPw, mName, mEmail, mPhoto, mBirth, mAddress));

	} // override

}
