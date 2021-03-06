package com.study.maven.ijhwang.ch04;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import com.study.maven.ijhwang.ch04.service.CommonService;

public class Main {
	
	
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch04/applicationContext1.xml");
		
		CommonService commonService = ctx.getBean(CommonService.class);
		List<?> list = (List<?>) commonService.SelectService(null);
		if(0 < list.size()){
			for(Object user : list){
				System.out.println(user.toString());
			}
		}
		
		
		
		/*ApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch04/applicationContext1.xml");
		
		List<UserVO> list = (List<UserVO>) ctx.getBean("userList");
		//List<UserVO> list2 = (List<UserVO>) ctx.getBean(List.class);
		
		System.out.println(list.toString());*/
		//System.out.println(list2.toString());
		
		
	}
	

}
