package com.study.maven.ijhwang.ch02.service;

import java.util.Collection;

import com.study.maven.ijhwang.ch02.dao.MemberDao;
import com.study.maven.ijhwang.ch02.util.MemberPrinter;
import com.study.maven.ijhwang.ch02.vo.Member;

public class MemberListPrinter {
	
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter memberPrinter) {
		this.memberDao = memberDao;
		this.memberPrinter = memberPrinter;
	}
	
	public void printAll(){
		Collection<Member> members = memberDao.selectAll();
		for(Member m : members){
			memberPrinter.print(m);
		}
	}
}
