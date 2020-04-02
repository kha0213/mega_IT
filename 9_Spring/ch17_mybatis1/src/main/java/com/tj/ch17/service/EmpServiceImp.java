package com.tj.ch17.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.ch17.dao.DeptDao;
import com.tj.ch17.dao.EmpDao;
import com.tj.ch17.dto.Dept;
import com.tj.ch17.dto.Emp;

@Service
public class EmpServiceImp implements EmpService {
	@Autowired
	private DeptDao dDao;
	
	@Autowired
	private EmpDao eDao;
	
	
	@Override
	public List<Dept> deptList() {
		return dDao.deptList();
	}

	@Override
	public List<Emp> empList(Emp searchEmp) {
		if(searchEmp.getEname()!=null) {
			searchEmp.setEname(searchEmp.getEname().toUpperCase());
		}
		if(searchEmp.getJob()!=null) {
			searchEmp.setJob(searchEmp.getJob().toUpperCase());
		}
		return eDao.empList(searchEmp);
	}

}
