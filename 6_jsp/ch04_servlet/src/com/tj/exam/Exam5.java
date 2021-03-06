package com.tj.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exam5
 */
@WebServlet("/Exam5")
public class Exam5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exam5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String[] color = {"red","orange","yellow","green","blue","navy","purple"};
		int su;
		if(request.getParameter("rbColor1")==null) {
			su = Integer.parseInt(request.getParameter("rbColor"));			
		}else {
			su = Integer.parseInt(request.getParameter("rbColor1"));						
		}
		int fontColorNum = (su!=0)? su-1: color.length-1;
		
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("h2{background-color:"+color[su]+";"
				+ "color:"+color[fontColorNum]+";}");

		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>배경은 "+color[su]+"색 글씨색은 "+color[fontColorNum]+"입니다.</h2>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
