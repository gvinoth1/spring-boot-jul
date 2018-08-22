package com.demo.spring.entity.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;
import com.demo.spring.entity.dao.EmpDao;

@Repository
@Qualifier("jpa")
public class EmpDaoJPAImpl implements EmpDao {

	@Override
	public String save(Emp e) {
		
		return "JPA; Emp Saved with id"+e.getEmpId();
	}

}
