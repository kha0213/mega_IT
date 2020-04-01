package com.tj.ch13.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.tj.ch13.dao.BoardDao;
import com.tj.ch13.dto.BoardDto;

public class BReplyViewService implements BService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int bid = (Integer) map.get("bid");
		BoardDao bDao = BoardDao.getInstance();
		BoardDto board = bDao.modifyView_replyView(bid);
		model.addAttribute("dto", board);
	}

}
