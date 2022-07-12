package com.study.maven.ijhwang.ch03.exception;

public class AlreadyExistingMemberException extends RuntimeException{
	public AlreadyExistingMemberException(String message){
		super(message);
	}

}
