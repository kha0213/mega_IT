package com.tj.ch17_2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tj.ch17_2.dto.Dept;

@Repository
public class DeptDaoImpl implements DeptDao {
	
	@Autowired
	private SqlSession sessionTemplate;
	
	@Override
	public List<Dept> deptList() {
		return sessionTemplate.selectList("deptList");
	}

}
