package edu.kh.jdbc.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.model.dto.Board;
import edu.kh.jdbc.model.dto.Member;
import edu.kh.model.service.ProjectService;

public class ProjectView {

	private Scanner sc = new Scanner(System.in);
	private ProjectService service = new ProjectService();
	
	// 로그인한 회원의 정보가 담긴 Member객체를 참조할 변수 선언
	private Member loginMember = null;
	
	   public void displayMenu() {
		      int input = -1;
		      
		      do {
		         try {
		        	 if(loginMember != null) {	// 로그인 상태인 경우
		        		 System.out.println("---------------------------------------------");
		        		 System.out.printf("(%s) \n", loginMember.getMemberEmail());
		        		 System.out.println("---------------------------------------------");
		        	 }
		            System.out.println("\n***** MEMBER/BOARD 테이블 사용 JDBC ***** \n");
		            System.out.println("1. 회원 가입");
		            System.out.println("2. 로그인");
		            System.out.println("3. 회원 정보 수정"); // 닉네임, 전화번호 UPDATE
		            System.out.println("4. 회원 탈퇴"); // MEMBER_DEL_FL = 'Y' UPDATE
		            System.out.println("5. MEMBER 테이블 전체 조회"); 
		            System.out.println("6. 게시글 작성");
		            System.out.println("7. 게시글 목록 조회"); // selectBoardList()
		            System.out.println("8. 게시글 상세 조회");
		            System.out.println("9. 게시글 삭제");
		            System.out.println("10. 게시글 수정");
		            System.out.println("0. 프로그램 종료");
		            
		            System.out.print("메뉴 선택 >> ");
		            input = sc.nextInt();
		            sc.nextLine(); // 입력 버퍼 개행 문자 제거
		            
		            switch(input) {
		            case 1 : insertMember(); break;
		            case 2 : login(); break;
		            case 3 : updateMember(); break;
		            case 4 : updateDelFl(); break;
		            case 5 : selectAllMember(); break;
		            case 6 : insertBoard(); break;
		            case 7 : selectBoardList(); break;
		            case 8 : selectBoard(); break;
		            case 9 : deleteBoard(); break;
		            case 10 : updateBoard(); break;
		            case 0 : System.out.println("\n--- 프로그램 종료 ---\n");break;
		            default : System.out.println("\n*** 메뉴 번호만 입력해주세요 ***\n");
		            }
		            
		         }catch (InputMismatchException e) {
		            System.out.println("\n잘못된 입력\n");
		            sc.nextLine();
		         }
		      }while(input != 0);
		   }

	   
	   /**
	    * 회원 가입 화면
	    */
	   private void insertMember() {
	      System.out.println("\n***** 회원 가입 *****\n");
	      
	      System.out.print("이메일 : ");
	      String email = sc.next();
	      
	      System.out.print("비밀번호 : ");
	      String pw = sc.next();
	      
	      System.out.print("닉네임 : ");
	      String nickname = sc.next();
	      
	      System.out.print("휴대폰 번호(- 제외) : ");
	      String tel = sc.next();
	      sc.nextLine(); // 입력 버퍼 개행문자 제거
	      
	      System.out.print("주소 : ");
	      String address = sc.nextLine();
	   
	      // 입력 받은 값을 Member 객체에 저장하기
	      Member member = new Member(email, pw, nickname, tel, address);
	      
	      // 서비스로 member를 전달한 후 수행 결과 반환 받기
	      // -> DML(INSERT,UPDATE,DELETE) 결과는 성공한 행의 수(int)로 반환
	      
	      int result = service.insertMember(member); // 1 또는 0
	      
	      if(result > 0) {
	         System.out.println("회원 가입 성공!!!");
	      }else {
	         System.out.println("회원 가입 실패......");
	      }
	   }
	   
	   private void login() {
		System.out.println("\n***** 로그인 *****\n");
		System.out.print("이메일 : ");
		String email = sc.next();
		
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		Member member = service.login(email,pw);
		
		if (member != null) {
			System.out.println("\n 로그인 성공! \n");
			System.out.println(member);
			
			loginMember = member;
		}
		else {
			System.out.println("\n 로그인 실패! \n");
		}
		
		// 로그인 결과에 따라 출력
	}
	
		   
	/** 
	 * MEMBER 테이블 전체 조회
	 */
	private void selectAllMember() {
		   System.out.println("\n***** MEMBER 테이블 전체 조회 *****\n");
		   System.out.println("내림 차순(1), 오름 차순(아무 숫자) : ");
		   int sort = sc.nextInt();
		   
		   List<Member> memberList = service.selectAllMember(sort);
		   
		   if (memberList.isEmpty()) { // 조회 결과가 없을 경우 (리스트가 비어있을 경우, null 아님!!
			System.out.println("\n 조회 결과가 없습니다 \n");
		   }else {
					for (Member mem : memberList) {
						System.out.println(mem);
					}
		   		}
	   		}
	   
  	/**
  	 * 로그인된 회원의 닉네임, 전화번호 수정 
  	 */
  	private void updateMember() {
  		if (loginMember == null) {
			System.out.println("\n***** 로그인 후 이용해 주세요 *****\n");
			return;
		}
  		
  		// 로그인 되어있을 경우
  		System.out.print("\n수정할 닉네임 : ");
  		String nickname = sc.next();
  		
  		System.out.print("수정할 전화번호(- 제외) : ");
  		String tel = sc.next();
  		
  		// 회원 정보 수정 서비스 호출 후 결과 반환받기
  		int result = service.updateMember(nickname, tel, loginMember.getMemberNo() );
  		
  		if(result > 0) {System.out.println("\n 정보 수정 성공! \n");
  		loginMember.setMemberNickname(nickname);
  		loginMember.setMemberTel(tel);
  		System.out.println(loginMember);
  		}
  		else System.out.println("\n 정보 수정 실패 \n");
  	}
  	
  	
  	/**
  	 * 회원 탈퇴
  	 */
  	private void updateDelFl() {
  		System.out.println("\n***** 회원 탈퇴 *****\n");
  		// 로그인 여부 확인
  		if (loginMember == null) {
			System.out.println("\n***** 로그인 후 이용해 주세요 *****\n");
			return;
		}
  		// 로그인 상태인 경우
  		// 1) 비밀번호 입력 받기
  		System.out.print("비밀번호를 입력해 주세요 : ");
  		String pw = sc.next();
  		
  		// 2) 서비스 메서드 호출 후 결과 반환 받기
  		// - 매개변수 : 회원번호, 입력 받은 비밀번호
  		// - 반환값 : SQL 수행 후 결과 행의 개수
  		int result = service.updateDelFl(loginMember.getMemberNo(), pw);
  		
  		
  		// 3) 성공일 경우 : "탈퇴 되었습니다", loginMember = null;
  		//	  실패일 경우 : "비밀번호가 일치하지 않습니다"
  		if (result > 0) {
			System.out.println("\n탈퇴 되었습니다");
			loginMember = null;
		}
  		else {
			System.out.println("비밀번호가 일치하지 않습니다");
		}
  		
  	}
  	
  	private void insertBoard() {
  		System.out.println("\n***** 게시글 작성 *****\n");
  		// 로그인 여부 확인
  		if (loginMember == null) {
			System.out.println("\n***** 로그인 후 이용해 주세요 *****\n");
			return;
		}
  		
  		System.out.print("제목 입력 : ");
  		String title = sc.nextLine();
  		
  		System.out.println("내용 입력 (입력 종료 : !wq)");
  		String content = ""; //빈 문자열
  		while (true) {
			String temp = sc.nextLine();
			
			if(temp.equals("!wq")) { //입력 종료 커맨드인 경우
				break;
			}
			content += temp + "\n"; //입력 받은 한 줄을 content에 누적
		}
  		
  		// BOARD 테이블에 삽입하는 서비스 호출 후 결과 반환 받기
  		int result = service.insertBoard(title, content, loginMember.getMemberNo() );
  		
  		if (result > 0) {
			System.out.println("\n***** 게시글이 등록 되었습니다 *****\n");
		} else {
			System.out.println("\n***** 게시글이 등록 실패 *****\n");
		}
  	}
  	
  	
  	private void selectBoardList() {
  		System.out.println("\n***** 게시글 목록 조회 *****\n");
  		
  		List<Board> boardList = new ArrayList<Board>();
  		boardList = service.selectBoardList();
  		
  		if(boardList.isEmpty()) System.out.println("\n 조회 결과가 없습니다 \n");
  		else {
			for (Board board : boardList) {
				System.out.printf("게시글 번호: %d / 제목 : %s / 작성일 : %s /\n조회수 : %d / 작성자번호 : %d / 작성자 닉네임 : %s \n\n",
						board.getBoardNo(), board.getBoardTitle(), board.getBoardCreateDate(), board.getReadCount(), board.getMemberNo(), board.getMemberNickname());
			}
		}
  	}
  	
  	private void selectBoard() {
  		System.out.println("\n***** 게시글 상세 조회 *****\n");
  		System.out.print("게시글 번호 입력 : ");
  		int boardNo = sc.nextInt();
  		
  		// 서비스 메서드 호출후 반환 받기
  		Board board = service.selectBoard(boardNo);
  		
  		// 조회 결과 존재하지 않을 경우
  		if (board == null) {
			System.out.println("\n***** 게시글이 존재하지 않습니다 *****\n");
			return;
		}
  		
  		// 조회 결과가 있을경우
  		System.out.printf("[%d] %s \n",
  				board.getBoardNo(), board.getBoardTitle());
  		
  		System.out.println("작성일 : " + board.getBoardCreateDate());
  		System.out.println("조회수 : " + board.getReadCount());
  		System.out.printf("작성자 : %s (%d) \n",
  				board.getMemberNickname(), board.getMemberNo() );
  		
  		System.out.println("---------------------------------------------------");
  		System.out.println(board.getBoardContent());
  		System.out.println("---------------------------------------------------");
  		
  	}
  	
  	private void deleteBoard() {
  		System.out.println("\n***** 게시글 삭제 *****\n");

  		if (loginMember == null) {
			System.out.println("\n***** 로그인 후 이용해 주세요 *****\n");
			return;
		}
  		
  		System.out.print("게시글 번호 : ");
  		int boardNo = sc.nextInt();
  		
  		int result = service.findBoard(loginMember.getMemberNo(), boardNo);
  		
  		if (result == 0) {
  			System.out.println("해당 계정이 작성한 게시글이 없습니다");
			return;
		}
  		
  		System.out.print("정말 삭제하시겠습니까?(Y/N) : ");
  		String YN = sc.next();
  		if (YN.equals("Y")) {
			result = service.deleteBoard(boardNo);
			if(result > 0 ) System.out.println("삭제되었습니다");
		}
  		
	}
  	
  	private void updateBoard() {
  		System.out.println("\n***** 게시글 수정 *****\n");

  		if (loginMember == null) {
			System.out.println("\n***** 로그인 후 이용해 주세요 *****\n");
			return;
		}
  		
  		System.out.print("게시글 번호 : ");
  		int boardNo = sc.nextInt();
  		
  		int result = service.findBoard(loginMember.getMemberNo(), boardNo);
  		
  		if (result == 0) {
  			System.out.println("해당 계정이 작성한 게시글이 없습니다");
			return;
		}
  		
  		System.out.print("제목 입력 : ");
  		String title = sc.next();
  		sc.nextLine();
  		
  		System.out.println("내용 입력 (입력 종료 : !wq)");
  		String content = ""; //빈 문자열
  		while (true) {
			String temp = sc.nextLine();
			
			if(temp.equals("!wq")) { //입력 종료 커맨드인 경우
				break;
			}
			content += temp + "\n"; //입력 받은 한 줄을 content에 누적
		}
  		
  		result = service.updateBoard(boardNo, title, content);
  		if(result > 0) System.out.println("게시글 수정 성공!");
  		else System.out.println("게시글 수정 실패!");
	}
}















