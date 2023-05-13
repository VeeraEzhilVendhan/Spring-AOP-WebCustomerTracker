package com.webapp.project.customer.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLogging {
	
	private Logger logger=Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.webapp.project.customer.dao.*.*(..))")
	public void daoPackage() {}
	
	@Pointcut("execution(* com.webapp.project.customer.service.*.*(..))")
	public void servicePackage() {}

	@Pointcut("execution(* com.webapp.project.customer.controller.*.*(..))")
	public void controllerPackage() {}
	
	@Pointcut("daoPackage() || servicePackage() || controllerPackage()")
	public void appFlow() {}
	
	//Before Advice
	@Before("appFlow()")
	public void beforeAdvice(JoinPoint joinPoint)
	{
		String method=joinPoint.getSignature().toShortString();
		System.out.println(("\n----> Before Advice Method Name - "+method));
		
		Object[] args=joinPoint.getArgs();
		for(Object temp:args)
		{
			System.out.println(("\n----> Before Advice "+method+" Arguments "+temp));			
		}		
	}
	
	//After Returning Advice
	@AfterReturning(pointcut="appFlow()",returning="result")
	public void afterReturningAdvice(JoinPoint joinPoint,Object result)
	{
		String method=joinPoint.getSignature().toShortString();
		System.out.println(("\n----> After Returning Advice Method Name - "+method));
		
		System.out.println(("\n----> After Returning Advice Result - "+result));
		
	}
}