package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class JdbcMain1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
		JdbcTemplate jt = (JdbcTemplate) ctx.getBean("jt");

		int count = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pst = conn
						.prepareStatement("insert into emp(empno,name,address,salary) " 
				+ "values(?,?,?,?)");
				pst.setInt(1, 106);
				pst.setString(2, "Karthik");
				pst.setString(3, "Chennai");
				pst.setDouble(4, 56000);
				return pst;
			}
		});
		System.out.println("Rows Inserted : " + count);
	}

}
