package com.study.maven.ijhwang.ch02.service;

import com.study.maven.ijhwang.ch02.dao.MemberDao;
import com.study.maven.ijhwang.ch02.util.MemberPrinter;
import com.study.maven.ijhwang.ch02.vo.Member;

public class MemberInfoPrinter {
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	/**
	 * 설정 메서드 방식
	 * 메서드 이름은 set으로 시작, set뒤에 property 이름 첫문자 대문자로 치환 이름 사용
	 * 
	 * <property name = set제외, 대문자->소문자 치환 ex) setMemberDao -> memberDao 
	 * <propert name = printer ref="빈명">
	 * 만약 setter 값이 없다면 빈생성시 setterMethod 필요하다고 에러발생
	 * 
	 * */
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void setMemberPrinter(MemberPrinter memberPrinter) {
		this.memberPrinter = memberPrinter;
	}
	
	public void printMemberInfo(String email){
		Member member = memberDao.selectByEmail(email);
		if(null == member){
			System.out.println("데이터 없음");
			return;
		}
		memberPrinter.print(member);
	}

	
	
}
