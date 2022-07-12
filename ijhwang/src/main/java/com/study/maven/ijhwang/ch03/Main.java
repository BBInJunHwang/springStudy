package com.study.maven.ijhwang.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.study.maven.ijhwang.ch03.exception.AlreadyExistingMemberException;
import com.study.maven.ijhwang.ch03.exception.IdPasswordNotMatchingException;
import com.study.maven.ijhwang.ch03.exception.MemberNotFoundException;
import com.study.maven.ijhwang.ch03.service.ChangePasswordService;
import com.study.maven.ijhwang.ch03.service.MemberInfoPrinter;
import com.study.maven.ijhwang.ch03.service.MemberListPrinter;
import com.study.maven.ijhwang.ch03.service.MemberRegisterService;
import com.study.maven.ijhwang.ch03.util.VersionPrinter;
import com.study.maven.ijhwang.ch03.vo.RegisterRequest;

public class Main {

		private static ApplicationContext ctx = null;

		public static void main(String[] args) throws IOException {
			
			/**
			 * ch03/applicationContext1.xml 확인 해보면 @Autowired 적용으로  property, construct-arg 생략 부분있음
			 * */
			//ctx = new GenericXmlApplicationContext("classpath:ch03/applicationContext1.xml");
			
			/**
			 * No qualifying bean of type 'com.study.maven.ijhwang.ch03.util.MemberPrinter' 
			 * available: expected single matching bean but found 2: memberPrinter1,memberPrinter2
			 * 다음과 같이 @Autowired 적용 시 같은 클래스 빈이 2개이상 존재 시 주입대상은 하나인데 둘줄 어떤걸 선택해야 할지 모른다.
			 * 
			 * qualifier 이용해서 한정자값을 지정해준다.
			 * */
			ctx = new GenericXmlApplicationContext("classpath:ch03/applicationContext2.xml");
		
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
