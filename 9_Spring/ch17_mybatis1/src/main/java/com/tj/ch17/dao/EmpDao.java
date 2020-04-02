package com.tj.ch17.dao;

import java.util.List;

import com.tj.ch17.dto.Emp;

public interface EmpDao {
	public List<Emp> empList(Emp searchEmp);
}
