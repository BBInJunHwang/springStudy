package com.study.maven.ijhwang.ch01;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author ijhwang
 * @comment 싱글톤 객체
 * 
 * */
public class Main2 {
	
	public static void main(String[] args) {
		
		/**
		 * 스프링 별도 설정 없을시 싱글톤 범위를 가지며, 단일 객체로서 같은 속성을 가진다.
		 * 
		 * */
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch01/applicationContext.xml");
		Greeter greeter1 = ctx.getBean("greeter",Greeter.class); 
		Greeter greeter2 = ctx.getBean("greeter",Greeter.class); 
		
		System.out.println(greeter1 == greeter2);
		ctx.close();
	}
}
