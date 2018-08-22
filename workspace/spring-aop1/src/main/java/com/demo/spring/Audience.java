package com.demo.spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class Audience {
	@Pointcut("execution(* com.demo.spring.*.*(..))")
	private void pcut() {
	}

	@Before("pcut()")
	public void switchOffMobile() {
		System.out.println("Audience Switched off mobiles...");
	}

	@Before("pcut()")
	public void takeSeat() {
		System.out.println("Audience taken their seats...");
	}

	@AfterReturning("pcut()")
	public void applaud() {
		System.out.println("Audience Appluads --Clap!Clap!Clap!..");
	}

	@AfterThrowing(pointcut = "pcut()", throwing = "pe")
	public void badPeformance(PerformerException pe) {
		System.out.println("Ver Bad Singing, we want refund....");
	}

	@After("pcut()")
	public void singerDeparts() {
		System.out.println("Singer is going back....");
	}
}
