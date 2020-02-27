package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.Board_dao;

public class BModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bip = request.getRemoteAddr();

		Board_dao bDao = new Board_dao();
		request.setAttribute("modifyResult", bDao.modifyBoard(bname, btitle, bcontent, bip, bid));
	}

}
