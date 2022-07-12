package com.study.maven.ijhwang.ch03.util;

public class VersionPrinter {
	private int majorVersion;
	private int minorVersion;
	
	/**
	 * 설정 메서드 방식
	 * 메서드 이름은 set으로 시작, set뒤에 property 이름 첫문자 대문자로 치환 이름 사용
	 * 
	 * <propert name = majorVersion value="값">
	 * 값 타입이 string,int 구분 없이 알맞게 자동으로 변환 해준다.
	 * 
	 * */
	
	
	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}

	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}

	public void print(){
		System.out.printf("현재 버전은 %d.%d입니다\n",majorVersion,minorVersion);
	}

}
