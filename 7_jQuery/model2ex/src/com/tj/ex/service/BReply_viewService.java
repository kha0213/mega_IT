package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.FileboardDao;

public class BReply_viewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fId = Integer.parseInt(request.getParameter("fId"));
		FileboardDao fDao = FileboardDao.getInstance();
		request.setAttribute("replyView", fDao.BoardDetail(fId, false));
	}

}
