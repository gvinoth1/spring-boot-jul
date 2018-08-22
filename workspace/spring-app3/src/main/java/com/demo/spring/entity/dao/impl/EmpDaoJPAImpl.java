package com.demo.spring.entity.dao.impl;

import com.demo.spring.entity.Emp;
import com.demo.spring.entity.dao.EmpDao;

public class EmpDaoJPAImpl implements EmpDao {

	@Override
	public String save(Emp e) {
		
		return "JPA; Emp Saved with id"+e.getEmpId();
	}

}
