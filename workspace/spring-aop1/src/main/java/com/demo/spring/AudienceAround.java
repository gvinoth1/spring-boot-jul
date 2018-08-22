package com.demo.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AudienceAround {
	@Pointcut("execution(* com.demo.spring.*.*(..))")
	private void pcut() {
	}

	@Around("pcut()")
	public void invoke(ProceedingJoinPoint pjp) throws Throwable {
		try {
			takeSeat();
			switchOffMobile();
			pjp.proceed();
			applaud();
		} catch (PerformerException e) {
			badPeformance(e);
		} finally {
			singerDeparts();
		}

	}

	public void switchOffMobile() {
		System.out.println("Audience Switched off mobiles...");
	}

	public void takeSeat() {
		System.out.println("Audience taken their seats...");
	}

	public void applaud() {
		System.out.println("Audience Appluads --Clap!Clap!Clap!..");
	}

	public void badPeformance(PerformerException pe) {
		System.out.println("Ver Bad Singing, we want refund....");
	}

	public void singerDeparts() {
		System.out.println("Singer is going back....");
	}
}
