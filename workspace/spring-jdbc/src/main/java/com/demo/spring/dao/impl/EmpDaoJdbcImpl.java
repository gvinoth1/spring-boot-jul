package com.demo.spring.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoJdbcImpl implements EmpDao {

	@Autowired
	JdbcTemplate jt;

	@Override
	//@Transactional(propagation=Propagation.NEVER)
	public String save(Emp e) {
		int count = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pst = conn
						.prepareStatement("insert into emp(empno,name,address,salary) " + "values(?,?,?,?)");
				pst.setInt(1, e.getEmpId());
				pst.setString(2, e.getName());
				pst.setString(3, e.getCity());
				pst.setDouble(4, e.getSalary());
				return pst;
			}
		});
		if (count == 1)
			return "saved";
		return "failed";
	}

	@Override
	public String delete(int empId) {
		int count = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pst = conn.prepareStatement("delete from emp where empno=?");
				pst.setInt(1, empId);
				return pst;
			}
		});
		if (count == 1)
			return "deleted";
		return "failed";
	}

	@Override
	public String update(Emp e) {
		int count = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pst = conn.prepareStatement("update emp set name=?,address=?,salary=?");
				pst.setString(1, e.getName());
				pst.setString(2, e.getCity());
				pst.setDouble(3, e.getSalary());
				return pst;
			}
		});
		if (count == 1)
			return "updated";
		return "failed";
	}

	@Override
	public Emp findById(int id) {
		Emp e = null;
		try {
			e = jt.queryForObject("select * from emp where empno=" + id, new RowMapper<Emp>() {

				@Override
				public Emp mapRow(ResultSet rs, int index) throws SQLException {

					return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"),
							rs.getDouble("SALARY"));
				}

			});
		} catch (Exception ex) {
			throw new RuntimeException("No Employee by this ID");
		}
		return e;
	}

	@Override
	public List<Emp> getAll() {
		List<Emp> empList = jt.query("select * from emp", new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int index) throws SQLException {

				return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"),
						rs.getDouble("SALARY"));
			}

		});
		return empList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String saveBatch(List<Emp> empList) {
		for (Emp e : empList) {
			save(e);
		}
		return "success";
	}
}
