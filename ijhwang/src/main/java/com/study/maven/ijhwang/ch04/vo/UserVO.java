package com.study.maven.ijhwang.ch04.vo;

public class UserVO {

	private String userId;
	private String userName;
	private String userMail;
	
	public UserVO() {
	}

	public UserVO(String userId, String userName, String userMail) {
		this.userId = userId;
		this.userName = userName;
		this.userMail = userMail;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userName=" + userName + ", userMail=" + userMail + "]";
	}
}
