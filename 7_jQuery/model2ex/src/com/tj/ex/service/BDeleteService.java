package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.FileboardDao;

public class BDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fId = Integer.parseInt(request.getParameter("fId"));
		FileboardDao fDao = FileboardDao.getInstance();
		if(fDao.deleteBoard(fId)){
			request.setAttribute("deleteResult", "삭제 성공");
		}else {
			request.setAttribute("deleteResult", "삭제 실패");
		}
		
		
	}

}
