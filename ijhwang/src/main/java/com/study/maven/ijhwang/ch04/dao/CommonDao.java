package com.study.maven.ijhwang.ch04.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDao {
	@Autowired
	private List<?> userList;
	
	/*public CommonDao(){
		System.out.println("field injection");
		System.out.println(this.userList);
	}*/
	
	
	//@Autowired
	public CommonDao(List<?> userList){
		this.userList = userList;
		System.out.println("constructor injection");
		System.out.println(this.userList);
	}
	
/*	@Autowired
	public void setUserList(List<?> userList) {
		this.userList = userList;
		System.out.println("setter injection");
		System.out.println(this.userList);
	}*/

	public Object selectUser(Map<String,Object> reqMap){
		System.out.println("CommonDao.class");
		System.out.println("select User");
		
		return userList;
	}
	
	public void insertUser(Map<String,Object> reqMap){
		System.out.println("CommonDao.class");
		System.out.println("insert User");
	}
	
	public void updateUser(Map<String,Object> reqMap){
		System.out.println("CommonDao.class");
		System.out.println("update User");
	}
	
	public void deleteUser(Map<String,Object> reqMap){
		System.out.println("CommonDao.class");
		System.out.println("delete User");
	}
}
