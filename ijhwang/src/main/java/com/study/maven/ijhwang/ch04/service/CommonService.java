package com.study.maven.ijhwang.ch04.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.maven.ijhwang.ch04.dao.CommonDao;

@Service
public class CommonService {
	private CommonDao commonDao;
	
	//@Autowired
	public CommonService(CommonDao commonDao) {
		this.commonDao = commonDao;
	}
	/*public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}*/

	

	public Object SelectService(Map<String,Object> reqMap) throws InterruptedException{
		System.out.println("CommonService.class");
		System.out.println("Call selectUser");
		
		return commonDao.selectUser(reqMap);
	}
	
	public void insertService(Map<String,Object> reqMap){
		System.out.println("CommonService.class");
		System.out.println("Call insertUser");
		commonDao.insertUser(reqMap);
	}
	
	public void UpdateService(Map<String,Object> reqMap){
		System.out.println("CommonService.class");
		System.out.println("Call updateUser");
		commonDao.insertUser(reqMap);
	}
	
	public void DeleteService(Map<String,Object> reqMap){
		System.out.println("CommonService.class");
		System.out.println("Call deleteUser");
		commonDao.insertUser(reqMap);
	}
	
	
}
