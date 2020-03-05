package com.tj.ex.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.Member_dao;
import com.tj.ex.dto.Member;

public class JoinMemberService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		Date birth = null; 
		String birthStr = request.getParameter("birth");
		if(birthStr != null) {
			birth = Date.valueOf(birthStr);
		}
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		Member_dao mDao = Member_dao.getInstance();
		int result = mDao.insertMember(new Member(id, pw, name, birth, gender, email, phone, address));
		if(result == 1) {
			request.setAttribute("joinResult", "가입성공입니다 로그인 이후 서비스 이용하세요");
		}else {
			request.setAttribute("joinResult", "가입실패입니다 관리자에게 문의하세요");
		}
		
		
	}

}
