package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.EmpDao;
import com.tj.ex.dto.Emp;

public class EmpService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		
		Emp emp = new Emp(0,ename,job,0,null,0,0,0);
		EmpDao eDao = EmpDao.getInstance();
		request.setAttribute("emps", eDao.getEmpList(emp));
		
	}

}
