package com.study.maven.ijhwang.ch02.service;

import com.study.maven.ijhwang.ch02.dao.MemberDao;
import com.study.maven.ijhwang.ch02.exception.MemberNotFoundException;
import com.study.maven.ijhwang.ch02.vo.Member;

public class ChangePasswordService {

	private MemberDao memberDao;
	
	public ChangePasswordService(MemberDao memberDao){
		this.memberDao = memberDao;
	}
	
	public void changePassword(String email, String oldPwd, String newPwd){
		Member member = memberDao.selectByEmail(email);
		if(member == null){
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
}
