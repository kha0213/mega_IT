package com.tj.ex;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex11_empList
 */
@WebServlet("/Ex11_empList")
public class Ex11_empList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex11_empList() {
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
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDao dao = new EmpDao();
		String ename="";
		String job = "";
		if(request.getParameter("ename")!=null) {
			ename=request.getParameter("ename").toUpperCase();
		}
		if(request.getParameter("job")!=null) {
			job = request.getParameter("job").toUpperCase();
		}
		//paging
		final int PAGESIZE=5;
		final int BLOCKSIZE=3;

		String pageNum = request.getParameter("pageNum");
		if(pageNum==null || pageNum=="") pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		
		int startRow =0, endRow=0;
		startRow = (currentPage-1)*PAGESIZE+1;
		endRow = startRow+PAGESIZE-1;
		//뿌릴 emps
		ArrayList<EmpDto> emps = dao.getListEmpSearchNameJobTopN(ename, job, startRow, endRow);
		request.setAttribute("emps", emps);
		
		int empCnt = dao.cntEmpSearchNameJobTopN(ename, job);
		int pageSize = (empCnt-1)/PAGESIZE+1;
		int startPage =0,endPage=0;
		startPage = (currentPage-1)/BLOCKSIZE*BLOCKSIZE+1;
		endPage = startPage+BLOCKSIZE-1;
		if(endPage>pageSize) {
			endPage=pageSize;
		}
		Paging paging = new Paging(startRow, endRow, startPage, endPage, currentPage);
		request.setAttribute("paging", paging);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("core/ex11_empList.jsp");
		dispatcher.forward(request, response);
	}

}
