/*package com.study.maven.ijhwang.ch03.util;

import com.study.maven.ijhwang.ch03.dao.MemberDao;
import com.study.maven.ijhwang.ch03.service.ChangePasswordService;
import com.study.maven.ijhwang.ch03.service.MemberRegisterService;

*//**
 * @author ijhwang
 * @comment 조립기
 * DI 통해 객체 주입 코드만 변경하면 되는곳이며, 실제 객체를 생성하는 곳이다.
 * 
 * *//*
public class Assembler {
	
	private MemberDao memberDao;
	private MemberRegisterService memberRegisterService;
	private ChangePasswordService changePasswordService;
	
	// 의존객체 변경시 아래만 변경하면 된다.
	public Assembler(){
		memberDao = new MemberDao();
		memberRegisterService = new MemberRegisterService(memberDao);
		changePasswordService = new ChangePasswordService(memberDao);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getMemberRegisterService() {
		return memberRegisterService;
	}

	public ChangePasswordService getChangePasswordService() {
		return changePasswordService;
	}
}
*/