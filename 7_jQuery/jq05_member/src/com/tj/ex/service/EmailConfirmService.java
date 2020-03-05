package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.Member_dao;
import com.tj.ex.service.Service;

public class EmailConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		Member_dao mDao = Member_dao.getInstance();
		int result = mDao.emailConfirm(email);
		if(result == 0) {
			request.setAttribute("emailConfirmResult", "사용가능한 email입니다.");
		}else {
			request.setAttribute("emailConfirmResult", "중복된 email입니다.");
		}
		
	}

}
