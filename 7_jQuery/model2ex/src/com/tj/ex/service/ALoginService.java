package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.ex.dao.AdminDao;

public class ALoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String aId = request.getParameter("aId");
		String aPw = request.getParameter("aPw");
		AdminDao aDao = AdminDao.getInstance();
		if(aDao.adminLoginCheck(aId, aPw)) {
			request.setAttribute("loginResult", "관리자 로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("admin", aDao.getAdmin(aId));
		}else {
			request.setAttribute("errorMsg", "관리자 로그인 실패! 아이디와 비밀번호 확인하세요");			
		}
		
	}

}
