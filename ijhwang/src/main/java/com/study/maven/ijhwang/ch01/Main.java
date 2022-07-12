package com.study.maven.ijhwang.ch01;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author ijhwang
 * @comment 빈객체 생성과 사용
 * 
 * */
public class Main {

	public static void main(String[] args) {
		
		/*
		
		xml 파일 내 빈설정은 아래 자바코드와 같은 의미이다.
		 
		<bean id="greeter" class="com.study.maven.ijhwang.ch01.Greeter">
			<property name="format" value="$s, 안녕하세요!" />
		</bean>
		
		Greeter greeter = new Greeter();
		greeter.setFormat("%s, 안녕하세요!");
		*/
		
		
		// GenericXmlApplicationContext는 ApplicationContext 인터페스를 구현한 구현체임 
		// 해당 xml 파일로 부터 설정파일 읽어서 빈객체 생성 및 관리
		// 컨테이너 초기화, 빈객체 생성과 의존객체 주입 및 초기화
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch01/applicationContext.xml");
		
		// 컨테이너 사용
		Greeter greeter = ctx.getBean("greeter",Greeter.class); // 빈 id , 빈 타입
		
		String msg = greeter.greet("스프링");
		System.out.println(msg);
		
		// 컨테이너 종료, 빈객체 소멸
		ctx.close();
		
		/*
		1. 스프링컨테이너는 가장 먼저 빈 객체를 생성한다.
		2. <property>로 지정된 의존을 설정한다. 의존 자동 주입을 통한 의존 설정도 이 시점에 수행
		3. 모든 의존 설정이 완료되면 , 빈 객체의 초기화를 수행한다. 빈객체를 초기화 하기위해 스프링은 빈객체의 지정한 메서드를 호출한다.
		4. 스프링 컨테이너를 종료하면 스프링 컨테이너는 빈 객체의 지정한 메서드를 호출해서 빈객체의 소멸을 처리한다. 
		*/
	}

}
