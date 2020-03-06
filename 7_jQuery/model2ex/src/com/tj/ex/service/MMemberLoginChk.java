package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.MemberDao;

public class MMemberLoginChk implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		MemberDao mDao = MemberDao.getInstance();
		if(mDao.mIdConfirm(mId)) {
			request.setAttribute("idConfirm", "중복된 아이디입니다.");
		}else {
			request.setAttribute("idConfirm", "사용가능한 아이디입니다.");
		}
	}

}
