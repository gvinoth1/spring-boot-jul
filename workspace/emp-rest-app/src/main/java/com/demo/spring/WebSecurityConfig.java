package com.demo.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder passwordEnc() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/greet/**").permitAll()
		.antMatchers("/app/**").hasAnyRole("USER","ADMIN")
		.and().httpBasic().and().csrf().disable();

	}

	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().passwordEncoder(passwordEnc()).withUser("scott").password("$2a$10$PHlCPOZOoH9miEWpv0jQV.idReo1zyzlgFJu9rX..Z1OzhbkMgWiq").roles("USER");
		auth.inMemoryAuthentication().passwordEncoder(passwordEnc()).withUser("pavan").password("$2a$10$PHlCPOZOoH9miEWpv0jQV.idReo1zyzlgFJu9rX..Z1OzhbkMgWiq").roles("USER").disabled(true);
		auth.inMemoryAuthentication().passwordEncoder(passwordEnc()).withUser("arun").password("$2a$10$PHlCPOZOoH9miEWpv0jQV.idReo1zyzlgFJu9rX..Z1OzhbkMgWiq").roles("ADMIN");
		
	}*/
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth,DataSource ds) throws Exception {
		auth
		.jdbcAuthentication().dataSource(ds)
		.passwordEncoder(passwordEnc())
		.usersByUsernameQuery("select username,password,enabled from users where username=?")
		.authoritiesByUsernameQuery("select username,authority from authorities where username=?");
	}
}
