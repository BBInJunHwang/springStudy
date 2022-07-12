package com.study.maven.ijhwang.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.study.maven.ijhwang.ch02.exception.AlreadyExistingMemberException;
import com.study.maven.ijhwang.ch02.exception.IdPasswordNotMatchingException;
import com.study.maven.ijhwang.ch02.exception.MemberNotFoundException;
import com.study.maven.ijhwang.ch02.service.ChangePasswordService;
import com.study.maven.ijhwang.ch02.service.MemberInfoPrinter;
import com.study.maven.ijhwang.ch02.service.MemberListPrinter;
import com.study.maven.ijhwang.ch02.service.MemberRegisterService;
import com.study.maven.ijhwang.ch02.util.VersionPrinter;
import com.study.maven.ijhwang.ch02.vo.RegisterRequest;

/**
 * @author ijhwang
 * @comment xml 2개이상 적용법 
 * 1. 설정할 xml 위치 개수만큼 명시한다.
 * public GenericXmlApplicationContext(String... resourceLocations) {
 * 
 * 2. xml 파일 내 import 실시한다.
 * ex) ch02/applicationContext3_part1 파일 내 
 * <import resource ="classpath:ch02/applicationContext3_part2.xml" /> 추가한다.
 * 
 * */
public class Main2 {
	
	private static ApplicationContext ctx = null;

	public static void main(String[] args) throws IOException {
		
		// 파일 2개 명시
		//ctx = new GenericXmlApplicationContext("classpath:ch02/applicationContext3_part1.xml","classpath:ch02/applicationContext3_part2.xml");
		
		// part1 파일내 import part2 실시
		ctx = new GenericXmlApplicationContext("classpath:ch02/applicationContext3_part1.xml");
		
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
			}else if(command.equals("list")){
				processListCommnad();
				continue;
			}else if(command.startsWith("info ")){
				processInfoCommnad(command.split(" "));
				continue;
			}else if(command.equals("version")){
				processVersionCommnad();
				continue;
			}
			printHelp();
		}
	}
	
	private static void processNewCommnad(String[] arg) {
		if(arg.length !=5){
			printHelp();
			return;
		}
		MemberRegisterService memberRegisterService = ctx.getBean("memberService",MemberRegisterService.class);
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
		ChangePasswordService changePasswordService = ctx.getBean("changePasswordService",ChangePasswordService.class);
		
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
	
	private static void processListCommnad(){
		MemberListPrinter listPrinter = ctx.getBean("listPrinter",MemberListPrinter.class);
		listPrinter.printAll();
	}
	
	private static void processInfoCommnad(String[] arg){
		if(arg.length !=2){
			printHelp();
			return;
		}
		MemberInfoPrinter memberInfoPrinter = ctx.getBean("memberInfoPrinter", MemberInfoPrinter.class);
		memberInfoPrinter.printMemberInfo(arg[1]);
	}
	
	private static void processVersionCommnad(){
		VersionPrinter versionPrinter = ctx.getBean("versionPrinter",VersionPrinter.class);
		versionPrinter.print();
	}
}
