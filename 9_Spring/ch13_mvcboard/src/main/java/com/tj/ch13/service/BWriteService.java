package com.tj.ch13.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tj.ch13.dao.BoardDao;
import com.tj.ch13.dto.BoardDto;

public class BWriteService implements BService {

	@Override
	public void execute(Model model) {
		BoardDao bDao = BoardDao.getInstance();
		Map<String, Object> map = model.asMap();
		BoardDto board = (BoardDto) map.get("boardDto");
		board.setBip(((HttpServletRequest) map.get("request")).getRemoteAddr());
		int result = bDao.write(board);
		model.addAttribute("writeResult", result);

	}

}
