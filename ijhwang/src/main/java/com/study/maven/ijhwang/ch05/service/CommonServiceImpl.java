package com.study.maven.ijhwang.ch05.service;

import java.util.Map;
import org.springframework.stereotype.Service;
import com.study.maven.ijhwang.ch05.dao.CommonDao;

@Service("commonService")
public class CommonServiceImpl implements CommonService {
	private CommonDao commonDao;

	public CommonServiceImpl(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

	public Object SelectService(Map<String, Object> reqMap) throws InterruptedException {
		System.out.println("CommonServiceImpl.class");
		System.out.println("Call selectUser\n");

		Thread.sleep(2000);
		return commonDao.selectUser(reqMap);
	}

	@Override
	public Object SelectService2(Map<String, Object> reqMap) throws InterruptedException {
		System.out.println("CommonServiceImpl.class");
		System.out.println("Call selectUser2\n");
		
		Thread.sleep(2000);
		return commonDao.selectUser(reqMap);
	}

	@Override
	public Object SelectService3(Map<String, Object> reqMap) throws InterruptedException {
		System.out.println("CommonServiceImpl.class");
		System.out.println("Call selectUser2\n");
		
		Thread.sleep(2000);
		return commonDao.selectUser(reqMap);
	}
	
}
