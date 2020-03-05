package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.ex.dao.Member_dao;
import com.tj.ex.dto.Member;

public class LoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		Member_dao mDao = Member_dao.getInstance();
		Member member = mDao.loginMember(id, pw);
		if(member == null) {
			request.setAttribute("loginResultFail", "로그인 실패 아이디와 비밀번호를 확인하세요");
		}else {
			request.setAttribute("loginResult", "로그인 성공입니다.");
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
		}
		
	}

}
