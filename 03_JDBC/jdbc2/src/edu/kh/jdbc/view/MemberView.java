package edu.kh.jdbc.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.model.dto.Member;
import edu.kh.jdbc.service.MemberService;

public class MemberView {

	private Scanner sc = new Scanner(System.in);

	private MemberService service = new MemberService();
	
	
	
	
	
	
	
	
	
	
	
	
	/**		alt + shift + j : 툴팁 주석
	 * 메뉴 출력용 메서드
	 */
	public void displayMenu() {
		int input = -1;
		
		do {
			
			try {
				System.out.println("\n------Member 테이블로 JDBC 연습핟기------\n");
				System.out.println("1. 회원가입(INSERT)");
				System.out.println("2. 회원 정보 수정(UPDATE)");
				System.out.println("3. 회원 탈퇴(DELETE)");
				System.out.println("4. 비밀번호 변경(UPDATE)");
				// 이메일, 비밀번호 , 새 비밀번호르 입력받아
				// 이메일, 비밀번호가 일치하는 회원의 비밀번호를
				// 새 비밀번호로 변경
				// 메어드 이름: updatePw()
				System.out.println("0. 종료");
				System.out.print("메뉴 선택 >> ");
					
				input = sc.nextInt();
				switch (input) {
				
				case 1 : insertMember(); break;
				
				case 2 : updateMember(); break;
				
				case 3 : deleteMember(); break;
				
				case 4 : updatePw(); break;
				
				case 0 : System.out.println("프로그램 종료"); break;
				
				default: System.out.println("\n메뉴에 작성된 번호만 입력하세요\n");
				}
				
				
				
			} catch (InputMismatchException e) {
				System.out.println("\n[잘못된 입력입니다]\n ");
				sc.nextLine(); // 입력버퍼에 입력된 잘못 입력된 문자열 제거
			}
		} while (input != 0);
		
		
		
	}

	
	/**
	 * 회원 가입 화면
	 */
	private void insertMember() {
		System.out.println("\n*********** 회원가입 ***********\n");
		
		System.out.print("이메일 : ");
		String email =sc.next();
		
		System.out.print("비밀번호 : ");
		String pw =sc.next();
		
		System.out.print("닉네임 : ");
		String nickname =sc.next();
		
		System.out.print("휴대폰번호(- 업음) : ");
		String tel =sc.next();
		
		sc.nextLine();
		
		System.out.print("주소 : ");
		String address =sc.nextLine();
		
		// 입력받은 값을 Member 객체에 저장하기
			
		Member member = new Member(email,pw,nickname,tel,address);
		
		// 서비스로 memeber를 전달한후 수행결과 반환받기
		// -> DML(INSERT, UPDATE, DELETE) 결과는 성공한 행의 수 로 반환
		int result = service.insertMember(member); // 1 또는 0
		if(result >0) {
			System.out.println("회원 가입 성공!!");
		}
		else {
			System.out.println("회원 가입 실패.....");
		}
	}
	
	
	private void updateMember() {
		// 아이디, 비밀번호가 일치하는 회원의
		// 닉네임, 전화번호, 주소를 수정
		// (아이디 중복 없다고 가정)
		
		System.out.println("\n********* 회원 정보 수정 *********\n");
		System.out.print("이메일 : ");
		String email =sc.next();
		
		System.out.print("비밀번호 : ");
		String pw =sc.next();
		
		System.out.print("수정할 닉네임 : ");
		String nickname =sc.next();
		
		System.out.print("수정할 휴대폰번호(- 업음) : ");
		String tel =sc.next();
		
		sc.nextLine();	// 입력버퍼 개행문자 제거
		
		System.out.print("수정할 주소 : ");
		String address =sc.nextLine();
		
		// Member 객체를 생성하여 입력받은 값을 대입
		Member member = new Member(email, pw, nickname, tel, address);
		
		// 회원 정보 수정서비스 호출(member 전달) 후
		// 결과(수정된 행의 개수) 반환 받기
		
		int result = service.updateMember(member);
		
		// result == 1 : 수정 성공(이메일, 비밀번호 일치)
		// result == 0 : 수정 실패(이메일 또는 비밀번호 불일치)
		
		if (result > 0) System.out.println("\n회원 정보 수정 성공!");
		else System.out.println("\n아이디 또는 비밀번호 불일치");
		
	}
	
	
	/** 회원 탈퇴 화면
	 * 
	 */
	private void deleteMember() {
		// 이메일, 비밀번호가 일치하는 회원 탈퇴(DELETE)
		// 이메일, 비밀번호 일치 -> 탈퇴 성공
		// 불일치 -> 이메일 또는 비밀번호 불일치
		
		System.out.println("\n******** 회원탈퇴 ********\n");
		System.out.print("탈퇴할 이메일 : ");
		String email =sc.next();
		
		System.out.print("탈퇴할 비밀번호 : ");
		String pw =sc.next();
		
		sc.nextLine();
		
		Member member = new Member(email, pw);
		
		// 삭제 서비스 호출 (성공 1 반환, 실패 0 반환)
		int result = service.deleteMember(member);
		
		if (result > 0) System.out.println("\n탈퇴 성공!");
		else System.out.println("\n이메일 또는 비밀번호 불일치");
		
		
	}
	
	private void updatePw() {
		System.out.println("\n******** 비밀번호 변경 ********\n");
		System.out.print("이메일 : ");
		String email =sc.next();
		
		System.out.print("비밀번호 : ");
		String pw =sc.next();
		
		System.out.print("새 비밀번호 : ");
		String chPw =sc.next();
		
		sc.nextLine();
		
		// 이메일과 비밀번호를 member 객체로 묶는다
		Member member = new Member(email, pw);
		
		// 변경 서비스 호출 
		int result = service.updatePw(member, chPw);
		
		if(result > 0) System.out.println("\n비밀번호 변경 성공!");
		else System.out.println("\n이메일 또는 비밀번호 불일치");
	}
}
