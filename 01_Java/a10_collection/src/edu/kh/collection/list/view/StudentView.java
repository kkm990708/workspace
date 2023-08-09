package edu.kh.collection.list.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;

import edu.kh.collection.list.model.dto.Student;
import edu.kh.collection.list.model.service.StudentService;

public class StudentView {
	private Scanner sc = new Scanner(System.in);
	private StudentService service = new StudentService();
	
	// alt + shitf + j
	/**
	 *  메뉴 출력용 view 메서드
	 */
	public void displayMenu() {
		int input = 0;
		do {
			try {	// 예외가 발생할 수 있는 코드 작성 부분
				System.out.println();
				System.out.println("\n****** 학생 관리 프로그램 ******\n");
				System.out.println("1. 학생 추가");
				System.out.println("2. 학생 전체 조회");
				System.out.println("3. 학생 한명 조회");
				System.out.println("4. 학생 한명 삭제");
				System.out.println("5. 성별 조회");
				System.out.println("6. 같은 학년 조회");
				System.out.println("7. 이름으로 조회");
				System.out.println("8. 중복 확인");
				System.out.println("9. 성적 순서로 조회(정렬)");
				System.out.println("0. 프로그램 종료");
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt(); // InputMismatchException 가능성 있음
							
				switch (input) {
				case 1 : addStudent(); break;
				case 2 : selectAllStudent();
				case 3 : selectOne(); break;
				case 4 : deleteStudent(); break;
				case 5 : selectGender(); break;
				case 6 : selectGrade(); break;
				case 7 : selectName(); break;
				case 8 : duplicateValidation(); break;
				case 9 : sortScore(); break;
				case 0: System.out.println("프로그램 종료"); break;
				default: System.out.println("** 잘못 입력 **"); break;
				}
				
				
			} catch (InputMismatchException e) {
				// InputMismatchException : Scanner 입력 타입이 잘못됨
				System.out.println("** 메뉴 번호만 입력해주세요 **");
				input = -1;	// 예외 발생시 while문 종료를 막기 위해 변경
				
				// Scanner 입력 버퍼에 남아있는 잘못 입력된 값을 제거하는 코드
				// sc.nextLine() : 입력 버퍼에서 한줄(/n 까지) 읽어오는 기능
				sc.nextLine();
			}
		} while (input != 0); // input이 0이면 종료
	}




	/**
	 * 학생 추가 view 메서드
	 */
	private void addStudent() { 
		System.out.println("\n------- 학생추가 -------\n");
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		
		System.out.print("반 : ");
		int ban = sc.nextInt();
		
		System.out.print("번호 : ");
		int number = sc.nextInt();
		
		System.out.print("이름 : ");
		String name =sc.next();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0);
		
		System.out.print("점수 : ");
		int score = sc.nextInt();
		
		boolean result = service.addStudent(grade, ban, number, name, gender, score);
		
		if 
		(result) {
			System.out.println(name + "학생이 추가되었습니다");
		}
		else {
			System.out.println("추가실패(중복된 학생 있음)");
		}
	}
	
	/**
	 * 학생 전체 조회 view 메스 
	 */
	private void selectAllStudent() {
		// Service에 있는 studentList를 통째로 얻어와 for문 이용하여 출력
		List<Student> studentsList= service.selectAllStudent();
			for (int i = 0;  i < studentsList.size(); i++) {
				System.out.printf("[%d] %s \n",i , studentsList.get(i));
												// == studentList.get(i).toString
			
		}
	}

	/**
	 * 학생 1명 조회
	 */
	private void selectOne() {
		System.out.println("\n-------- 학생 1명 조회(index) --------\n");
		System.out.print("조회할 학생의 index 입력 : ");
		int index = sc.nextInt();
		// Service의 studentList 에서 index가 일치하는 학생 1명 받환받기
		Student std = service.selectOne(index);
		// std == null 또는 학생1명 객체주소
		if (std == null) {
			System.out.println("해당 index에 학생이 존재하지 않습니다");
		}
		else {
			System.out.print(std);
		}
	}
	
	/**
	 *  학생 1명 삭제 view
	 */
	private void deleteStudent() {
		System.out.println("\n------- 학생 1명 삭제 -------");
		// 인덱스 번호를 입력 받아서 Service 메서드를 호출
		// List에 해당하는 인덱스 학생이 있으면 List에서 삭제후 삭제된 학생을 반환
		// -> "000학생의 정보가 삭제되었습니다" 출력
		
		// List에 해당하는 인덱스가 없으면
		// null 반환
		// -> 해당 index에 학생이 존재하지 않습니다
		
		System.out.print("삭제할 학생의 index 입력 : ");
		int index = sc.nextInt();
		Student std = service.selectOne(index);
		// std == null 또는 학생1명 객체주소
		if (std == null) {
			System.out.println("해당 index에 학생이 존재하지 않습니다");
		}
		else {
			Student remove = service.deleteStudent(index);
			System.out.println(remove.getName() + " 학생의 정보가 삭제되었습니다");
		}
		
	}
	
	
	/**
	 * 성별 조회 view 메서드
	 */
	private void selectGender() {
		System.out.println("\n--------- 성별 조회 ---------\n");
		System.out.print("조회할 성별을 입력해주세요(M,F) : ");
		char gender = sc.next().toUpperCase().charAt(0);
								// 대문자
		
		if (gender != 'M' && gender != 'F') {
			System.out.println("** M또는 F만 입력해해주세요 **");
			return;
		}
		// M 또는 F를 입력한 경우
		// Service에 성별 조회 메서드 호출(입력받은 성별 전달)
		// 일치하는 성별만 담긴 학생 목록을 받환 받기
		List<Student> searchList = service.selectGender(gender);
		
		// 만약 검색 결과가 없을경우
		// == searchList가 비어있을 경우
		// == searchList의 size()가 0인경우
		if (searchList.isEmpty()) {
			//searchList.size() == 0;
			System.out.println("검색 결과가 없습니다");
		}	
		else {	// 검색 결과가 있을경우
			for(Student s : searchList) {
				System.out.println(s);
			}
		}
	}
	
	/**
	 * 같은학년 조회 view 메서드, 학년은 1~6학년 까지만 존재 
	 */ 
	public void selectGrade() {
		System.out.println("\n-------- 같은 학년 조회 --------\n");
		System.out.print("조회할 학년을 입력해주세요 : ");
		int grade = sc.nextInt();
		
		if (grade < 1 || grade > 6) {
			System.out.println("학년은 1 ~ 6학년 까지만 존재합니다");
			return;
		}
		List<Student> searchList = service.selectGrade(grade);
		
		if (searchList.isEmpty()) {
			System.out.println("검색 결과가 없습니다");
		}	
		else {
			for(Student s : searchList) {
				System.out.println(s);
			}
		}
		
	}
	
	/**
	 * 이름으로 조회 view 메서드
	 */
	public void selectName() {
		System.out.println("\n-------- 이름으로 조회 --------\n");
		
		System.out.print("검색할 학생의 이름 입력 : ");
		
		String name = sc.next();
		List<Student> searchList = service.selectName(name);
		
		if (searchList.isEmpty()) {
			System.out.println("검색 결과가 없습니다");
		}
		else {
			for(Student s : searchList) {
				System.out.println(s);
			}
		}
	}
	
	/**
	 * 중복확인 view 메서드
	 */
	public void duplicateValidation() { 
		// 학년, 반 ,번호, 이름, 성별, 점수를 입력받아
		// 모두 똑같은 학생이 존재하는지 확인
		System.out.println("\n-------- 중복 확인 --------\n");
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		
		System.out.print("반 : ");
		int ban = sc.nextInt();
		
		System.out.print("번호 : ");
		int number = sc.nextInt();
		
		System.out.print("이름 : ");
		String name =sc.next();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0);
		
		System.out.print("점수 : ");
		int score = sc.nextInt();
		
		// 입력받은 값을 서비로 전달하여
		// 중복이면 true, 아니면 false 반환 받기
		boolean result = service.duplicateValidation(grade, ban, number, name, gender, score);
		if (result) {
			System.out.println("같은 학생이 있습니다");
		}else {
			System.out.println("같은 학생이 없습니다");
			
		}
	}
	
	/**
	 * 성적 순서로 조회(정렬) view 메서드
	 */
	private void sortScore() {
		System.out.println("\n-------- 성적 순서로 조회(정렬) --------\n");
		List<Student> sortList = service.sortScore();
		for(Student s : sortList) {
			System.err.println(s);
		}
	}
}
