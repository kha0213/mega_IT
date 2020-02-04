package com.tj.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exam8
 */
@WebServlet("/Exam8")
public class Exam8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exam8() {
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
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<link href='/ch04_servlet/css/exam8.css' rel='stylesheet'>");
		out.print("</head>");
		out.print("<body>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<th colspan=\"2\">반갑습니다 "+writer+"님</th>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<th>글제목</th>");
		out.print("<td>"+title+"</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<th>글내용</th>");
		out.print("<td><pre>"+content+"</pre></td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("</body></html>");
		
		
		
		
	}

}
