package com.demo.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.demo.spring.entity.Emp;

@Configuration
@ComponentScan(basePackages = "com.demo.spring")
@EnableTransactionManagement
public class DaoConfig {

	@Autowired
	@Qualifier("dataSource1")
	DataSource ds1;

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springdb?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	public DriverManagerDataSource dataSource1() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springdb?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	public JdbcTemplate jt() {
		JdbcTemplate jt = new JdbcTemplate();
		// jt.setDataSource(dataSource());
		jt.setDataSource(ds1);
		return jt;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager txm = new DataSourceTransactionManager();
		txm.setDataSource(ds1);
		return txm;
	}

}
