package com.tj.ch13.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.tj.ch13.dao.BoardDao;

public class BContentService implements BService {

	@Override
	public void execute(Model model) {
		BoardDao bDao = BoardDao.getInstance();
		Map<String,Object> map = model.asMap();
		int bid = (Integer) map.get("bid");
		model.addAttribute("dto",bDao.contentView(bid));
	}

}
