package com.demo.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.demo.spring.entity.Emp;

public class JdbcMain2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
		JdbcTemplate jt = (JdbcTemplate) ctx.getBean("jt");

		List<Emp> empList = jt.query("select * from emp", new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int index) throws SQLException {

				return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"),
						rs.getDouble("SALARY"));
			}

		});

		for (Emp e : empList) {
			System.out.println(e.getName() + " " + e.getSalary());
		}
		
		Emp e = jt.queryForObject("select * from emp where empno="+106, new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int index) throws SQLException {

				return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"),
						rs.getDouble("SALARY"));
			}

		});

		System.out.println(e.getEmpId()+" "+e.getName() + " " + e.getSalary());
	}

}
