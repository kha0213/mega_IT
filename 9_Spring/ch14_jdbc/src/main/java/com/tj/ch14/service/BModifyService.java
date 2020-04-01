package com.tj.ch14.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tj.ch14.dao.BoardDao;
import com.tj.ch14.dto.BoardDto;

public class BModifyService implements BService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		BoardDto board = (BoardDto) map.get("board");
		BoardDao bDao = BoardDao.getInstance();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		board.setBip(request.getRemoteAddr());
		int result;
		result = bDao.modify(board);
		model.addAttribute("modifyResult", result);
	}

}
