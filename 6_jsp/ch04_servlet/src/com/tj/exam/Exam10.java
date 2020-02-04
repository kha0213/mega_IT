package com.tj.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exam10
 */
@WebServlet("/Exam10")
public class Exam10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exam10() {
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
		actionDo(request, response);
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String hiddenParam = request.getParameter("hiddenParam");
		String name =request.getParameter("name");
		String id =request.getParameter("id");
		String pw ="";
		for(int i=0;i<request.getParameter("pw").length();i++) {
			pw+="*";
		}
		String birth = request.getParameter("birth");
		String hobbyStr = "";
		String[] hobby = null;
		if(request.getParameterValues("hobby")!=null) {
			hobby = request.getParameterValues("hobby");
			for(int i=0;i<hobby.length;i++) {
				if(i!=hobby.length-1) {
					hobbyStr+=hobby[i]+", ";
				}else {
					hobbyStr+=hobby[i];
				}
			}
		}else {
			hobbyStr="취미없음";
		}
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String mailSendStr = "";
		String[] mailSend = null;
		if(request.getParameterValues("mailSend")!=null) {
			mailSend = request.getParameterValues("mailSend");
			for(int i=0;i<mailSend.length;i++) {
				if(i!=mailSend.length-1) {
					mailSendStr+=mailSend[i]+", ";
				}else {
					mailSendStr+=mailSend[i];
				}
			}
		}else {
			mailSendStr="모두 거부";
		}
		
		out.print("<html>");
		out.print("<head>");
		out.print("<style>");
		out.print("#wrap{padding:20px;border:1px solid #D4A190;}");
		out.print("h2{color:#D4A190;text-align: center;}");
		out.print("tr{text-align: left;}");
		out.print("</style>");
		out.print("</head>");
		out.print("<body>");
		
		out.print("<div id=\"wrap\">");
		out.print("<div><h2>회원가입정보</h2><hr color='#D4A190'></div>");
		out.print("<table>");
		
		out.print("<tr><th>");
		out.print("hiddenParam : "+hiddenParam);
		out.print("</th></tr>");
		out.print("<tr><th>");
		out.print("이름 : "+name);
		out.print("</th></tr>");
		out.print("<tr><th>");
		out.print("아이디 : "+id);
		out.print("</th></tr>");
		out.print("<tr><th>");
		out.print("비번 : "+pw);
		out.print("</th></tr>");
		out.print("<tr><th>");
		out.print("생년월일 : "+birth);
		out.print("</th></tr>");
		out.print("<tr><th>");
		out.print("취미 : "+hobbyStr);
		out.print("</th></tr>");
		out.print("<tr><th>");
		out.print("성별 : "+gender);
		out.print("</th></tr>");
		out.print("<tr><th>");
		out.print("이메일 : "+email);
		out.print("</th></tr>");
		out.print("<tr><th>");
		out.print("메일수신동의 : "+mailSendStr);
		out.print("</th></tr>");
		
		out.print("</table>");
		out.print("</div>");
		
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}

}
