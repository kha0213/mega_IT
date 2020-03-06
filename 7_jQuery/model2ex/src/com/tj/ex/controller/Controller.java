package com.tj.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.service.ALoginService;
import com.tj.ex.service.BContentService;
import com.tj.ex.service.BListService;
import com.tj.ex.service.LogoutService;
import com.tj.ex.service.MAllViewService;
import com.tj.ex.service.MJoinService;
import com.tj.ex.service.MLoginService;
import com.tj.ex.service.MMemberLoginChk;
import com.tj.ex.service.MModifyService;
import com.tj.ex.service.Service;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		if(com.equals("/main.do")) {
			viewPage = "main/main.jsp";
		}else if(com.equals("/adminloginView.do")) {
			viewPage = "admin/adminLogin.jsp";
		}else if(com.equals("/adminlogin.do")) {
			service = new ALoginService();
			service.execute(request, response);
			viewPage = "allView.do";
		}else if(com.equals("/allView.do")) {
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
		}else if(com.equals("/logout.do")) {
			service = new LogoutService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(com.equals("/loginView.do")) {
			viewPage = "member/login.jsp";
		}else if(com.equals("/memberloginCheck.do")) {
			service = new MMemberLoginChk();
			service.execute(request, response);
			viewPage = "message/memberIdConfirm.jsp";
		}else if(com.equals("/memberlogin.do")) {
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(com.equals("/joinView.do")) {
			viewPage = "member/join.jsp";
		}else if(com.equals("/join.do")) {
			service = new MJoinService();
			service.execute(request, response);
			viewPage = "loginView.do";
		}else if(com.equals("/modifyView.do")) {
			viewPage = "member/modify.jsp";
		}else if(com.equals("/modify.do")) {
			service = new MModifyService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(com.equals("/list.do")) {
			service = new BListService();
			service.execute(request, response);
			viewPage = "fileboard/list.jsp";
		}else if(com.equals("/content_view.do")) {
			service = new BContentService();
			service.execute(request, response);
			viewPage = "fileboard/content_view.jsp";
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
