package com.study.maven.ijhwang.ch05.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDaoImpl implements CommonDao{
	
	@Autowired
	private List<?> userList;
	
	public CommonDaoImpl(List<?> userList){
		this.userList = userList;
	}
	
	public Object selectUser(Map<String,Object> reqMap){
		System.out.println("CommonDaoImpl.class");
		System.out.println("select User\n");
		
		return userList;
	}
}
