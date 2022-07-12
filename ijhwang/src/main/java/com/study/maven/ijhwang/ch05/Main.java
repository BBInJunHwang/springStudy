package com.study.maven.ijhwang.ch05;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.study.maven.ijhwang.ch05.service.CommonService;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch05/applicationContext1.xml");
		CommonService commonService = ctx.getBean("commonService",CommonService.class);
		
		// proxy 는 인터페이스에 따라 달라지며, 가짜 commonService 라고 생각한다
		// newProxyInstance(실제 업무 클래스, proxy 인터페이스들, 보조 업무를 넣을 수 있는 익명클래스-구현해야함.)
		CommonService proxy = (CommonService) Proxy.newProxyInstance(CommonService.class.getClassLoader(), new Class[]{CommonService.class}, new InvocationHandler() {
			
			// invoke는 모든 타입을 반환해야하기 때문에 Object형이다. 
			@Override 	// invoke - 보조업무 (Method - 실제업무 , Object[] - 호출 메소드 파라미터 등 결과값)
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				long start = System.currentTimeMillis();
				
				// 실제 업무 호출
				Object result = method.invoke(commonService,args);
				
				long end = System.currentTimeMillis();
				
				System.out.println("java Proxy");
				System.out.printf("Service Process Time : %dms \n", end-start);
				return result;
			}
		});
		List<?> list = (List<?>) proxy.SelectService(null);
		//List<?> list = (List<?>) commonService.SelectService(null);
		if(0 < list.size()){
			for(Object user : list){
				System.out.println(user.toString());
			}
		}
	}
}
