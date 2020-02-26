package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.MemberDao;

public class MemberListService implements Service {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		final int PAGESIZE = 3;
		final int BLOCKSIZE = 2;
		MemberDao mDao = MemberDao.getInstance();
		int countMember = mDao.getCountMember();
		
		
		request.setAttribute("memberList", mDao.getListMember());
	}

}
