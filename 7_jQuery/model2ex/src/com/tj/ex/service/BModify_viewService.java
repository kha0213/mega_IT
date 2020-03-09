package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.FileboardDao;

public class BModify_viewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		FileboardDao fDao = FileboardDao.getInstance();
		int fId = Integer.parseInt(request.getParameter("fId"));
		request.setAttribute("modifyView", fDao.BoardDetail(fId, false));
	}

}
