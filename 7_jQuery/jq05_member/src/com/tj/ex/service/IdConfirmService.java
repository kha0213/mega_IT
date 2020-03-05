package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.Member_dao;

public class IdConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Member_dao mDao = Member_dao.getInstance();
		int result = mDao.idConfirm(id);
		if(result == 0) {
			request.setAttribute("idConfirmResult", "사용가능한 ID입니다.");
		}else {
			request.setAttribute("idConfirmResult", "중복된 ID입니다.");
		}
	}

}
