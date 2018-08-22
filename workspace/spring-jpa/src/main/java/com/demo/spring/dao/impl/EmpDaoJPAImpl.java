package com.demo.spring.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

@Repository

public class EmpDaoJPAImpl implements EmpDao {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public String save(Emp e) {
		em.persist(e);
		return "saved";
	}

	@Override
	public String delete(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Emp e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp findById(int id) {
		Emp e = em.find(Emp.class, id);
		return e;
	}

	@Override
	public List<Emp> getAll() {
		Query query = em.createQuery("select e from Emp e");
		List<Emp> empList = query.getResultList();
		return empList;
	}

	@Override
	public String saveBatch(List<Emp> empList) {
		for(Emp e:empList) {
			em.persist(e);
		}
		return "success";
	}

}
