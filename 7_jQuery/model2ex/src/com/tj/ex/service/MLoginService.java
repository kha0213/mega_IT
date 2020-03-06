package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.ex.dao.MemberDao;

public class MLoginService implements Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao mDao = MemberDao.getInstance();
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		
		if(mDao.loginCheck(mId, mPw)) {
			HttpSession session = request.getSession();
			session.setAttribute("member", mDao.getMember(mId));
			request.setAttribute("loginResult", "로그인 성공!");
		}else {
			request.setAttribute("errorMsg", "로그인 실패 아이디와 비밀번호를 확인하세요");
		}
		
		
	}

}
