package com.tj.ch14.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch14.constant.Constant;
import com.tj.ch14.dto.BoardDto;
import com.tj.ch14.service.BContentService;
import com.tj.ch14.service.BDeleteService;
import com.tj.ch14.service.BListService;
import com.tj.ch14.service.BModifyService;
import com.tj.ch14.service.BModifyViewService;
import com.tj.ch14.service.BReplyService;
import com.tj.ch14.service.BReplyViewService;
import com.tj.ch14.service.BService;
import com.tj.ch14.service.BWriteService;

@Controller
public class Bcontroller {
	private BService service;
	private int writable = 0;
	private int modifiable = 0;
	private int repliable = 0;
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = template;
	}

	@RequestMapping(value = "list", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(String pageNum, Model model) {
		model.addAttribute("pageNum", pageNum);
		service = new BListService();
		service.execute(model);
		return "mvcboard/list";
	}

	@RequestMapping(value = "write_view", method = RequestMethod.GET)
	public String write_view() {
		writable = 1;
		return "mvcboard/write_view";
	}

	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(BoardDto boardDto, Model model, HttpServletRequest request) {
		if (writable == 1) {
			service = new BWriteService();
			model.addAttribute("request", request);
			service.execute(model);
		}
		writable = 0;
		return "forward:list.do";
	}

	@RequestMapping(value = "content_view", method = RequestMethod.GET)
	public String content_view(int bid, Model model) {
		model.addAttribute("bid", bid);
		service = new BContentService();
		service.execute(model);
		return "mvcboard/content_view";
	}

	@RequestMapping(value = "modify_view", method = RequestMethod.GET)
	public String modify_view(int bid,Model model) {
		modifiable = 1;
		model.addAttribute("bid", bid);
		service = new BModifyViewService();
		service.execute(model);
		return "mvcboard/modify_view";
	}
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute("board") BoardDto board,Model model,HttpServletRequest request) {
		if(modifiable == 1) {
			model.addAttribute("request",request);
			service = new BModifyService();
			service.execute(model);
		}
		modifiable = 0;
		return "forward:list.do";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int bid,Model model) {
		model.addAttribute("bid",bid);
		service = new BDeleteService();
		service.execute(model);
		return "forward:list.do";
	}

	@RequestMapping(value = "reply_view", method = RequestMethod.GET)
	public String reply_view(int bid,Model model) {
		repliable = 1;
		model.addAttribute("bid",bid);
		service = new BReplyViewService();
		service.execute(model);
		return "mvcboard/reply_view";
	}
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String reply(@ModelAttribute("board") BoardDto board,Model model,HttpServletRequest request) {
		if(repliable == 1) {
			model.addAttribute("request",request);
			service = new BReplyService();
			service.execute(model);
		}
		repliable = 0;
		return "forward:list.do";
	}
}
