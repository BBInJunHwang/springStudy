package com.study.maven.ijhwang.ch01.vo;

import java.util.Date;

import com.study.maven.ijhwang.ch01.exception.IdPasswordNotMatchingException;

public class Member {

	private Long id;
	private String email;
	private String pasword;
	private String name;
	private Date registerDate;
	
	public Member(String email, String pasword, String name, Date registerDate) {
		this.email = email;
		this.pasword = pasword;
		this.name = name;
		this.registerDate = registerDate;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	public void changePassword(String oldPassword, String newPassword){
		if(!pasword.equals(oldPassword)){
			throw new IdPasswordNotMatchingException();
		}
		this.pasword = newPassword;
	}
	
}
