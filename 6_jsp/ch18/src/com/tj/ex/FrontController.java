
package com.tj.ex;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.member.MemberDao;
import com.tj.member.MemberDto;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
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
		//StringBuffer url = request.getRequestURL();
		//String answer = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
	
		String viewPage = "";
		Service service = null;
		
		if(command.equals("/insert.do")) {
			request.setAttribute("result", "insert command");
			viewPage = "1_front/ex02.jsp";
		}else if(command.equals("/select.do")) {
			System.out.println("select command 호출함");
			request.setAttribute("result", "select command");
			viewPage = "1_front/ex02.jsp";
		}else if(command.equals("/delete.do")) {
			System.out.println("delete command 호출함");
			request.setAttribute("result", "delete command");
			viewPage = "1_front/ex02.jsp";
		}else if(command.equals("/update.do")) {
			System.out.println("update command 호출함");
			request.setAttribute("result", "update command");
			viewPage = "1_front/ex02.jsp";
		}else if(command.equals("/listMember.do")) {
			service = new ListMemberService();
			service.execute(request, response);
			viewPage = "1_front/ex03list.jsp";
		}else if(command.equals("/joinPro.do")) {
			service = new JoinMemberService();
			service.execute(request, response);
			viewPage = "1_front/ex04joinResult.jsp";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
