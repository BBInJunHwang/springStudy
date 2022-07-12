package com.study.maven.ijhwang.ch03.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.study.maven.ijhwang.ch03.dao.MemberDao;
import com.study.maven.ijhwang.ch03.util.MemberPrinter;
import com.study.maven.ijhwang.ch03.vo.Member;

public class MemberListPrinter {
	
	@Autowired(required=false)
	private MemberDao memberDao;
	
	@Autowired
	@Qualifier("test")
	private MemberPrinter memberPrinter;
	
	/*public MemberListPrinter(MemberDao memberDao, MemberPrinter memberPrinter) {
		this.memberDao = memberDao;
		this.memberPrinter = memberPrinter;
	}*/
	
	public void printAll(){
		Collection<Member> members = memberDao.selectAll();
		for(Member m : members){
			memberPrinter.print(m);
		}
	}
}
