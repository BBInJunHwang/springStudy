package com.study.maven.ijhwang.ch02.exception;

public class AlreadyExistingMemberException extends RuntimeException{
	public AlreadyExistingMemberException(String message){
		super(message);
	}

}
