package com.tj.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.service.BContentService;
import com.tj.ex.service.BDeleteService;
import com.tj.ex.service.BListService;
import com.tj.ex.service.BModifyService;
import com.tj.ex.service.BModifyViewService;
import com.tj.ex.service.BReplyService;
import com.tj.ex.service.BReplyViewService;
import com.tj.ex.service.BWriteService;
import com.tj.ex.service.Service;

/**
 * Servlet implementation class BController
 */
@WebServlet("*.do")
public class BController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getRequestURI().substring(request.getContextPath().length());
		String viewPage = null;
		Service service = null;

		if (command.equals("/boardsList.do")) {
			service = new BListService();
			service.execute(request, response);
			viewPage = "board/list.jsp";
		} else if (command.equals("/write_view.do")) {
			viewPage = "board/write_view.jsp";
		} else if (command.equals("/write.do")) {
			// service의 execute() 호출 - BWriteService.java
			service = new BWriteService();
			service.execute(request, response);
			viewPage = "boardsList.do";
		} else if (command.equals("/content_view.do")) {
			// service의 execute() 호출 - BContentService.java
			service = new BContentService();
			service.execute(request, response);
			viewPage = "board/content_view.jsp";
		} else if (command.equals("/modify_view.do")) {
			// service의 execute() 호출 - BModifyViewService.java
			service = new BModifyViewService();
			service.execute(request, response);
			viewPage = "board/modify_view.jsp";
		} else if (command.equals("/modify.do")) { // DB에 글수정
			// service의 execute() 호출 - BModifyService.java
			service = new BModifyService();
			service.execute(request, response);
			viewPage = "boardsList.do";
		} else if (command.equals("/delete.do")) {
			// service의 execute() 호출 - BDeleteService.java
			service = new BDeleteService();
			service.execute(request, response);
			viewPage = "boardsList.do";
		} else if (command.equals("/reply_view.do")) {
			// service의 execute()호출 - BReplyViewService.java
			service = new BReplyViewService();
			service.execute(request, response);
			viewPage = "board/reply_view.jsp";
		} else if (command.equals("/reply.do")) { // 답변글 DB저장
			// service의 execute()호출 - BReplyService.java
			service = new BReplyService();
			service.execute(request, response);
			viewPage = "boardsList.do";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
