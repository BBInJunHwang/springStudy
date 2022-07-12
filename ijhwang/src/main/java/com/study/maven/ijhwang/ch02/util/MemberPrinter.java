package com.study.maven.ijhwang.ch02.util;

import com.study.maven.ijhwang.ch02.vo.Member;

public class MemberPrinter {

	public void print(Member member){
		System.out.printf("회원정보 : 아이디 = %d, 이메일 = %s, 등록일 %tF\n",member.getId(), member.getEmail(), member.getRegisterDate());
	}
}
