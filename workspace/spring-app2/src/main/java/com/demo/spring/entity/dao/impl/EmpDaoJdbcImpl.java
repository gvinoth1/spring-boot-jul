package com.demo.spring.entity.dao.impl;

import com.demo.spring.entity.Emp;
import com.demo.spring.entity.dao.EmpDao;

public class EmpDaoJdbcImpl implements EmpDao {

	@Override
	public String save(Emp e) {
		
		return "JDBC ; Emp Saved with id"+e.getEmpId();
	}

}
