package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.Board_dao;

public class BReplyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		final boolean do_not_hitUp = false;
		int bid = Integer.parseInt(request.getParameter("bid"));
		Board_dao bDao = new Board_dao();
		request.setAttribute("replyView", bDao.boardContentView(bid, do_not_hitUp));
	}

}
