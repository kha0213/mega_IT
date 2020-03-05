package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.Member_dao;

public class LoginSearchService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Member_dao mDao = Member_dao.getInstance();
		String[] result = mDao.loginSearch(name, email);
		if(result!=null) {
		request.setAttribute("id", result[0]);
		request.setAttribute("pw", result[1]);
		}
		
	}

}
