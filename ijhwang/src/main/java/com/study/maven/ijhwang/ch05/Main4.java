package com.study.maven.ijhwang.ch05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.study.maven.ijhwang.ch05.service.CommonService;

public class Main4 {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch05/applicationContext4.xml");
		CommonService proxy = (CommonService) ctx.getBean("proxy");

		Map<String,Object> reqMap = new HashMap<String,Object>();
		reqMap.put("userId"		, "ijhwang");
		reqMap.put("password"	, "1234");
		
		List<?> list = (List<?>) proxy.SelectService3(reqMap);
		if(0 < list.size()){
			for(Object user : list){
				System.out.println(user.toString());
			}
		}
	}
}
