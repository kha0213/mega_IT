package com.tj.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex3_mvc
 */
@WebServlet("/Ex3_mvc")
public class Ex3_mvc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex3_mvc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String conPath = request.getContextPath(); // conPath = "/ch05_jsp"
		String uri = request.getRequestURI(); //uri = "/ch05_jsp/Ex3_mvc"
		String command = uri.substring(conPath.length()+1);
		
		System.out.println("conPath : "+conPath);
		System.out.println("uri : "+uri);
		System.out.println("command : "+command);
		String serverName = request.getServerName();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
