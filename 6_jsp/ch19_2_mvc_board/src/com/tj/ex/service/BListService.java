package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.Board_dao;

public class BListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		final int PAGESIZE = 10;
		final int BLOCKSIZE = 10;
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null || pageNum == "") pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int startRow=(currentPage-1)*PAGESIZE+1;
		int endRow = startRow+PAGESIZE-1;
		
		Board_dao bDao = new Board_dao();
		request.setAttribute("boardsList", bDao.getBoardsList(startRow, endRow));
		// pageCnt
		int pageCnt = (bDao.getBoardsTotalCount()-1)/PAGESIZE+1;
		int startPage = (currentPage-1)/BLOCKSIZE*BLOCKSIZE+1;
		int endPage = Math.min(pageCnt, startPage+BLOCKSIZE-1);
		
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("pageNum", pageNum);
	}

}
