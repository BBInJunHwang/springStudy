package com.study.maven.ijhwang.ch05.aop;

import java.lang.reflect.Method;
import java.util.Map;

import org.springframework.aop.MethodBeforeAdvice;

public class LogBeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("Before Advice");
		System.out.println("before : " + arg0.getName());
		System.out.println("target : " + arg2);
		
		Object inputParam = null;
		for (Object obj : arg1) {
			if (obj instanceof Map) {
				inputParam = obj;
			}
		}
		
		System.out.println("parameter : " + inputParam);
		System.out.println("\n");
	}

}
