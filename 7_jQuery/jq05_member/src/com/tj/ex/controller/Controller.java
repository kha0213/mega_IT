package com.tj.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.service.EmailConfirmService;
import com.tj.ex.service.IdConfirmService;
import com.tj.ex.service.JoinMemberService;
import com.tj.ex.service.LoginSearchService;
import com.tj.ex.service.LoginService;
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
		String viewPage = "";
		Service service = null;
		if(com.equals("/join.do")) {
			service = new JoinMemberService();
			service.execute(request, response);
			viewPage="member/loginView.do";
		}else if(com.equals("/joinIdConfirm.do")) {
			service = new IdConfirmService();
			service.execute(request, response);
			viewPage="member/joinIdConfirm.jsp";
		}else if(com.equals("/joinEmailConfirm.do")) {
			service = new EmailConfirmService();
			service.execute(request, response);
			viewPage = "member/joinEmailConfirm.jsp";
		}else if(com.equals("/login.do")) {
			service = new LoginService();
			service.execute(request, response);
			viewPage = "member/loginView.jsp";
		}else if(com.equals("/loginView.do")) {
			viewPage = "member/loginView.jsp";
		}else if(com.equals("/main.do")) {
			viewPage = "member/main.jsp";
		}else if(com.equals("/loginSearch.do")) {
			service = new LoginSearchService();
			service.execute(request, response);
			viewPage = "member/loginSearch.jsp";
		}
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
