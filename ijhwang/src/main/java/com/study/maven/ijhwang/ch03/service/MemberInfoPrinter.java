package com.study.maven.ijhwang.ch03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.study.maven.ijhwang.ch03.dao.MemberDao;
import com.study.maven.ijhwang.ch03.util.MemberPrinter;
import com.study.maven.ijhwang.ch03.vo.Member;

public class MemberInfoPrinter {
	
	@Autowired(required=false)
	private MemberDao memberDao;
	
	@Autowired
	@Qualifier("test") // 한정자를 지정하게 되면, 해당 한정자를 가진 빈을 의존객체로 사용
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
	
	/*public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	
	public void setMemberPrinter(MemberPrinter memberPrinter) {
		this.memberPrinter = memberPrinter;
	}*/
	
	public void printMemberInfo(String email){
		Member member = memberDao.selectByEmail(email);
		if(null == member){
			System.out.println("데이터 없음");
			return;
		}
		memberPrinter.print(member);
	}

	
	
}
