package com.study.maven.ijhwang.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.study.maven.ijhwang.ch01.exception.AlreadyExistingMemberException;
import com.study.maven.ijhwang.ch01.exception.IdPasswordNotMatchingException;
import com.study.maven.ijhwang.ch01.exception.MemberNotFoundException;
import com.study.maven.ijhwang.ch01.service.ChangePasswordService;
import com.study.maven.ijhwang.ch01.service.MemberRegisterService;
import com.study.maven.ijhwang.ch01.util.Assembler;
import com.study.maven.ijhwang.ch01.vo.RegisterRequest;

/**
 * @author ijhwang
 * @comment xml 빈 설정없이 DI 적용법 Assembler
 * 
 * */
public class Main3 {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("입력하세요");
			String command = reader.readLine();
			if(command.equalsIgnoreCase("exit")){
				System.out.println("종료");
				break;
			}
			if(command.startsWith("new ")){
				processNewCommnad(command.split(" "));
				continue;
			}else if(command.startsWith("change ")){
				processChangeCommnad(command.split(" "));
				continue;
			}
			printHelp();
		}
	}

	private static Assembler assembler = new Assembler();
	
	private static void processNewCommnad(String[] arg) {
		System.out.println(arg.length);
		if(arg.length !=5){
			printHelp();
			return;
		}
		MemberRegisterService memberRegisterService = assembler.getMemberRegisterService();
		RegisterRequest registerRequest = new RegisterRequest();
		registerRequest.setEmail(arg[1]);
		registerRequest.setName(arg[2]);
		registerRequest.setPassword(arg[3]);
		registerRequest.setConfirmPassword(arg[4]);
		
		if(!registerRequest.isPaswordEqualToConfirmPassword()){
			System.out.println("암호가 일치하지 않습니다.");
			return;
		}
		try {
			memberRegisterService.regist(registerRequest);
			System.out.println("등록 완료");
		} catch (AlreadyExistingMemberException e) {
			System.out.println("이미 존재하는 이메일니다.");
		}
	}
	
	private static void processChangeCommnad(String[] arg) {
		if(arg.length !=4){
			printHelp();
			return;
		}
		ChangePasswordService changePasswordService = assembler.getChangePasswordService();
		
		try {
			changePasswordService.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호 변경완료");
		} catch (MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일");
		} catch (IdPasswordNotMatchingException e) {
			System.out.println("이메일과 암호가 일치 하지 않음");
		}
	}

	private static void printHelp() {
		System.out.println("잘못된 명령어입니다.");
	}
}
