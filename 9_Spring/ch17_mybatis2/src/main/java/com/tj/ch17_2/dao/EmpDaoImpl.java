package com.tj.ch17_2.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tj.ch17_2.dto.Emp;
import com.tj.ch17_2.dto.EmpDept;

@Repository
public class EmpDaoImpl implements EmpDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<Emp> empList(Emp emp) {
		return sqlSessionTemplate.selectList("empList", emp);
	}

	@Override
	public List<EmpDept> empDeptList(EmpDept empDept) {
		return sqlSessionTemplate.selectList("empDeptList", empDept);
	}

	@Override
	public int total() {
		return sqlSessionTemplate.selectOne("total");
	}

	@Override
	public Emp detail(int empno) {
		return sqlSessionTemplate.selectOne("detail",empno);
	}

	@Override
	public List<Emp> managerList() {
		return sqlSessionTemplate.selectList("managerList");
	}

	@Override
	public int insert(Emp emp) {
		return sqlSessionTemplate.insert("insert", emp);
	}

	@Override
	public int update(Emp emp) {
		return sqlSessionTemplate.update("update",emp);
	}

	@Override
	public int delete(int empno) {
		return sqlSessionTemplate.delete("delete",empno);
	}

}
