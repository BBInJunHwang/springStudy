package com.study.maven.ijhwang.ch05.aop;

import org.springframework.aop.ThrowsAdvice;

public class LogAfterThrowingAdvice implements ThrowsAdvice{
	
	// 기본 @override 할게 없다 -> 어떤 에러를 발생할지 모르기 때문에
	public void afterThrowing(RuntimeException e) throws Throwable{
		System.out.println("RuntimeException 발생");
		e.printStackTrace();
	}
}
