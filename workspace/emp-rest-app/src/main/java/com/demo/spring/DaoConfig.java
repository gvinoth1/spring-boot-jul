package com.demo.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.demo.spring.entity.Emp;

@Configuration
@ComponentScan(basePackages = "com.demo.spring")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.demo.spring")
public class DaoConfig {

	@Autowired
	@Qualifier("dataSource")
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

	/*@Bean
	public DriverManagerDataSource dataSource1() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springdb?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}*/

	@Bean
	public HibernateJpaVendorAdapter va() {
		HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
		va.setDatabase(Database.MYSQL);
		va.setShowSql(true);
		return va;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean cb = new LocalContainerEntityManagerFactoryBean();
		cb.setDataSource(ds1);
		cb.setPackagesToScan("com.demo.spring.entity");
		cb.setJpaVendorAdapter(va());
		return cb;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager txm = new JpaTransactionManager();
		txm.setEntityManagerFactory(entityManagerFactory().getObject());
		return txm;
	}
}
