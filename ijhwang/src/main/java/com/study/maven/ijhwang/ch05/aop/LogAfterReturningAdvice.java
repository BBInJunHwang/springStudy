package com.study.maven.ijhwang.ch05.aop;

import java.lang.reflect.Method;
import java.util.Map;

import org.springframework.aop.AfterReturningAdvice;

public class LogAfterReturningAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("\n");
		System.out.println("After Advice");
		System.out.println("after : " + arg1.getName());
		System.out.println("target : " + arg3);
		Object inputParam = null;
		for (Object obj : arg2) {
			if (obj instanceof Map) {
				inputParam = obj;
			}
		}
		System.out.println("parameter : " + inputParam);
		System.out.println("returnValue : "+ arg0);
		System.out.println("\n");
	}

}
