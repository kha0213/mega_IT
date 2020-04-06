package com.tj.ch17_2.service;

import java.util.List;

import com.tj.ch17_2.dto.Dept;
import com.tj.ch17_2.dto.Emp;
import com.tj.ch17_2.dto.EmpDept;

public interface EmpService {
	public List<Dept> deptList();
	public List<Emp> empList(Emp emp); //controller에서 페이징해볼까
	public int total();
	public Emp detail(int empno);
	public List<Emp> managerList();
	public int insert(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
	public List<EmpDept> empDeptList(String pageNum); //service에서 페이징해볼까 (원래는 매개변수 Emp)
	public void insertN(int n);
}
