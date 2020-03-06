package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.MemberDao;

public class MAllViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		final int PAGESIZE = 3;
		final int BLOCKSIZE = 5;
		MemberDao mDao = MemberDao.getInstance();
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null || pageNum.equals("")) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		request.setAttribute("mAllView", mDao.allMember(startRow, endRow));
		int totalMember = mDao.getMemberTotCnt();
		int pageCnt = (totalMember - 1) / PAGESIZE + 1;
		int startPage = (currentPage - 1) / BLOCKSIZE * BLOCKSIZE + 1;
		int endPage = Math.min(startPage + BLOCKSIZE - 1, pageCnt);

		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
	}

}
