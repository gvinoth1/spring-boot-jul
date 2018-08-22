package com.demo.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public interface EmpRepository extends CrudRepository<Emp, Integer> {

}
