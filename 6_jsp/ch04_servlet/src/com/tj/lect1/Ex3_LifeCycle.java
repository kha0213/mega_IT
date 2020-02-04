package com.tj.lect1;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex3_LifeCycle
 */
@WebServlet("/Ex3_LifeCycle")
public class Ex3_LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PostConstruct
	private void postConstruct() {
		System.out.println("Ex3_LifeCycle 객체 생성되자 마자 바로 실행 2");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex3_LifeCycle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// 객체가 만들어질 때 최초에 한 번 수행
		System.out.println("Ex3_LifeCycle servlet 객체가 생성될 때 수행(init)1");
	}
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//client의 요청이 들어올 때
//		response.getWriter().append("<h1>service() 수행</h1>");
//	}
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// 객체가 메모리에서 해제(끝낼 때)
		 System.out.println("servlet종료");
	}
	@PreDestroy
	private void preDestroy() {
		System.out.println("객체 소멸되기 바로 직전에 수행");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// client의 요청이 get방식으로 들어올 때
		response.getWriter().append("<h1>doGet() 수행</h1>");
		System.out.println("doGet() 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// client의 요청이 post방식으로 들어올 때
		response.getWriter().append("<h1>doPost() 수행</h1>");
		doGet(request, response);
	}

}
