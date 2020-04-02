package com.tj.ch17.service;

import java.util.List;

import com.tj.ch17.dto.Dept;
import com.tj.ch17.dto.Emp;

public interface EmpService {
	public List<Dept> deptList();
	public List<Emp> empList(Emp searchEmp);
}
