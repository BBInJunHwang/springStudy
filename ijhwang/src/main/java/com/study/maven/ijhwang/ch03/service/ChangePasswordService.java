package com.study.maven.ijhwang.ch03.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.study.maven.ijhwang.ch03.dao.MemberDao;
import com.study.maven.ijhwang.ch03.exception.MemberNotFoundException;
import com.study.maven.ijhwang.ch03.vo.Member;

public class ChangePasswordService {

	@Autowired
	private MemberDao memberDao;
	
	/*public ChangePasswordService(MemberDao memberDao){
		this.memberDao = memberDao;
	}*/
	
	public void changePassword(String email, String oldPwd, String newPwd){
		Member member = memberDao.selectByEmail(email);
		if(member == null){
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
}
