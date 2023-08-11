package edu.kh.ioview;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.management.loading.PrivateClassLoader;

import edu.kh.io.model.dto.Member;
import edu.kh.io.model.service.MemberService;

public class MemberView {
	private Scanner sc = new Scanner(System.in);
	// MemberService 객체 생성
	private MemberService service = new MemberService(); 
	
	/**
	 * 메뉴출력시작
	 */
	public void displayMenu() {
		int input = 0;
		
		do {
			try {
				
				System.out.println();
				System.out.println("\n---------- 회원관리 프로그램 ----------\n");
				System.out.println("1. 회원 목록 조회");
				System.out.println("2. 회원 가입;");
				System.out.println("3. 아이디/비밀번호 일치하는 회원 조회");
				System.out.println("4. 아이디/비밀번호 일치하는 회원의 비밀번호 변경");
				System.out.println("5. 아이디/비밀번호 일치하는 회원의 탈퇴");
				System.out.println("0. 종료");
				System.out.print("메뉴를 선택하세요 : ");
				input = sc.nextInt();
				System.out.println();
				switch (input) {
				case 1: selectAll();	break;
				case 2:	sighUp();  break;
				case 3:	selectOne(); break;
				case 4: changePw(); break;
				case 5: removeAc(); break;
				case 0: System.out.println("프로그램이 종료됩니다");	break;

				default:
					break;
				}
				
				
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다");
				input = -1; //첫번째 반복에서 변수 방생ㅅ
				sc.nextLine(); //입력 버퍼에 잘못입력된 문자열 제거
			}
		} while (input != 0);
		
	}
	
	/**
	 * 회원 목록 조회뷰
	 */
	private void selectAll() {
		System.out.println("\n 회원 목록 조회\n");
		//Service로 부터 회원 목록을 받환 받아서 모두 출력
		List<Member> memberList = service.selectAll();
		// 회원 목록이 비어있을 경우 == 회원이 없는 경우
		// memberList.txt 파일이 없어서 읽어온 회원 목록이 없는 경우
		if (memberList.isEmpty()) {
			System.out.println("[[======== 회원이 존재하지 않습니다 ========]]");
			return;
		}
		
		
		// 회원이 있을경우 향상된 for문으로 모두출력
		for(Member member : memberList)
			System.out.println(member);
			
	}
	private void sighUp(){
	System.out.println("\n========  회원가입 ========\n");
	Scanner sc = new Scanner(System.in);
	System.out.print("ID : ");
	String id = sc.next();
	System.out.print("PW : ");
	String pw = sc.next();
	System.out.print("이름 : ");
	String name = sc.next();
	System.out.print("포인트 : ");
	int point = sc.nextInt();
	
	// 회원받은 값을, 서비스로 전달 후
	// 회원가입(memberList에 추가) 성공시 true
	// 아이디가 중복이면 false 반환
	boolean result = service.sighUp(id,pw,name,point);
	if (result) {
		System.out.println(id + "회원이 가입 되었습니다");
	}
	else {
		System.out.println("이미 사용중인 id입니다");
	}
	}
	
	/**
	 * 아이디/비밀번호 일치 회원 조회 view
	 */
	private void selectOne() {
		System.out.println("\n======== 아이디/비밀번호 일치하는 회원 조회 ========\n");
		System.out.print("ID : ");
		String id = sc.next();
		
		System.out.print("PW : ");
		String pw = sc.next();
		System.out.println();
		
		// 입력받은 값을 서비스로 전달하여 일치하는 회원(Member)반환, 없으면 null 반환
		Member member = service.selectOne(id,pw);
		if (member == null) {
			System.out.println("일치하는 회원이 없습니다");
		}
		
		else {
			System.out.println("ID : " + member.getId());
			System.out.println("PW : " + member.getPw());
			System.out.println("이름 : " + member.getName());
			System.out.println("포인트 : " + member.getPoint());
		}
	}
	
	private void changePw() {
		System.out.println("\n======== 아이디/비밀번호 일치하는 회원 비밀번호 변경 ========\n");
		System.out.print("ID : ");
		String id = sc.next();
		
		System.out.print("PW : ");
		String pw = sc.next();
		System.out.println();
		
		// 입력받은 값을 서비스로 전달하여 일치하는 회원(Member)반환, 없으면 null 반환
		Member member = service.selectOne(id,pw);
		if (member == null) {
			System.out.println("일치하는 회원이 없습니다");
			return;
		}
		System.out.print("변경할 비빌번호를 입력하세요 : ");
		String chPw =sc.next();
		service.changePw(member,chPw);
		System.out.println("변경후 비밀번호 : " + member.getPw());
		
	}
	
	private void removeAc() {
		System.out.println("\n======== 아이디/비밀번호 일치하는 회원의 탈퇴 ========\n");
		System.out.print("ID : ");
		String id = sc.next();
		
		System.out.print("PW : ");
		String pw = sc.next();
		System.out.println();
		
		Member member = service.selectOne(id,pw);
		
		if (member == null) {
			System.out.println("일치하는 회원이 없습니다");
			return;
		}
		
		service.removeAc(member);
		
	}
}
