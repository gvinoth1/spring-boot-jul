package com.demo.spring.entity.dao.impl;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;
import com.demo.spring.entity.dao.EmpDao;
@Repository
public class EmpDaoJdbcImpl implements EmpDao {

	@Override
	public String save(Emp e) {
		
		return "JDBC ; Emp Saved with id"+e.getEmpId();
	}

}
