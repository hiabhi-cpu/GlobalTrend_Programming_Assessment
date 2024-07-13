package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MainAspect {
	Logger logger=LoggerFactory.getLogger(MainAspect.class);
	
	@Around("@annotation(com.example.demo.TrackExecutionTime)")
	public Object tracktime(ProceedingJoinPoint jp) throws Throwable{
		long startTime=System.currentTimeMillis();
		Object object=jp.proceed();
		long endTime=System.currentTimeMillis();
		logger.info("Method name : "+ jp.getSignature()+" time taken to execute : "+(endTime-startTime));
		return object;
	}
}
