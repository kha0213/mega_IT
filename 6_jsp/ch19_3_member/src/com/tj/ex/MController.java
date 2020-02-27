package com.tj.ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.service.GetMemberService;
import com.tj.ex.service.JoinService;
import com.tj.ex.service.LoginService;
import com.tj.ex.service.LogoutService;
import com.tj.ex.service.MAllViewService;
import com.tj.ex.service.MService;
import com.tj.ex.service.ModifyService;

/**
 * Servlet implementation class MController
 */
@WebServlet("*.do")
public class MController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MController() {
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
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		MService service = null;
		String viewPage = null;
		if (com.equals("/loginView.do")) {
			viewPage = "member/login.jsp";
		} else if (com.equals("/login.do")) {
			service = new LoginService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		} else if (com.equals("/logout.do")) {
			service = new LogoutService();
			service.execute(request, response);
			viewPage = "member/login.jsp";
		} else if (com.equals("/joinView.do")) {
			viewPage = "member/join.jsp";
		} else if (com.equals("/join.do")) {
			service = new JoinService();
			service.execute(request, response);
			viewPage = "member/login.jsp";
		} else if (com.equals("/modifyView.do")) {
			service = new GetMemberService();
			service.execute(request, response);
			viewPage = "member/modify.jsp";
		} else if (com.equals("/modify.do")) {
			service = new ModifyService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		} else if (com.equals("/allView.do")) {
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
