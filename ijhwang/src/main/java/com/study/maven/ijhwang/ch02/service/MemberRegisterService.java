package com.study.maven.ijhwang.ch02.service;

import java.util.Date;

import com.study.maven.ijhwang.ch02.dao.MemberDao;
import com.study.maven.ijhwang.ch02.exception.AlreadyExistingMemberException;
import com.study.maven.ijhwang.ch02.vo.Member;
import com.study.maven.ijhwang.ch02.vo.RegisterRequest;

public class MemberRegisterService {
	
	private MemberDao memberDao;
	
	// 의존객체 MemberDao를 생성자 주입 통해 전달 받음
	public MemberRegisterService(MemberDao memberDao){
		// 주입 받은 객체를 필드에 할당
		this.memberDao = memberDao;
	}
	
	
	public void regist(RegisterRequest req){
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null){
			throw new AlreadyExistingMemberException("이미 존재하는 회원입니다");
		}
		
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		memberDao.insert(newMember);
		
	}
}
