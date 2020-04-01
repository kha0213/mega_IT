package com.tj.ch14.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.tj.ch14.dao.BoardDao;

public class BListService implements BService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		String pageNum = (String) map.get("pageNum");
		if(pageNum == null || pageNum.isEmpty()) {
			pageNum = "1";
		}
		final int PAGESIZE = 10, BLOCKSIZE=10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*PAGESIZE+1;
		int endRow = startRow+PAGESIZE-1;
		
		BoardDao bDao = BoardDao.getInstance();
		model.addAttribute("list", bDao.list(startRow, endRow));
		int orderNum = startRow;
		int totCnt = bDao.getBoardTotCnt();
		int inverseNum = totCnt - startRow + 1;
		
		int pageCnt = (totCnt-1)/PAGESIZE+1;
		int startPage = (currentPage-1)/BLOCKSIZE*BLOCKSIZE+1;
		int endPage = Math.min(startPage+BLOCKSIZE-1, pageCnt);
		
		model.addAttribute("orderNum", orderNum);
		model.addAttribute("inverseNum", inverseNum);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("pageCnt", pageCnt);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("BLOCKSIZE", BLOCKSIZE);
		model.addAttribute("pageNum", pageNum);
		
	}

}
