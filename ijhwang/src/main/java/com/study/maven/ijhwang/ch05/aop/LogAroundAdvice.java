package com.study.maven.ijhwang.ch05.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		long start = System.currentTimeMillis();
		
		Object result = invocation.proceed();
		
		long end = System.currentTimeMillis();
		
		System.out.println("Spring DI Proxy");
		System.out.printf("Service Process Time : %dms \n", end-start);
		
		return result;
	}

}
