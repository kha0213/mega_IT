package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.ex.dao.Member_dao;

public class LoginService implements MService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");

		Member_dao mDao = Member_dao.getInstance();

		int result = mDao.loginMemberIdPwCheck(mId, mPw);
		if (result == Member_dao.LOGIN_FAIL) {
			request.setAttribute("errorMsg", "아이디와 비밀번호를 확인하세요");
		}
		if (result == Member_dao.LOGIN_SUCCESS) {
			HttpSession session = request.getSession();
			session.setAttribute("member", mDao.getMember(mId));
		}
	}

}
