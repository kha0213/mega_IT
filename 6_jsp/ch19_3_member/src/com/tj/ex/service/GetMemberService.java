package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.Member_dao;

public class GetMemberService implements MService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		Member_dao mDao = Member_dao.getInstance();
		request.setAttribute("member", mDao.getMember(mId));

	}

}
