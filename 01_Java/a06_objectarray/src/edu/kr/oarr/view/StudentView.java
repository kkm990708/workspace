package edu.kr.oarr.view;

import java.security.Provider.Service;
import java.util.Scanner;

import edu.kr.oarr.model.dto.Student;
import edu.kr.oarr.model.service.StudentSevice;

public class StudentView {
	// 필드
	private Scanner sc = new Scanner(System.in);
	private StudentSevice sevice = new StudentSevice();
	
	public void displayMenu() {
		int input = 0; // 메뉴 번호 입력
		do {
			System.out.println("\n======== 학생관리 프로그램 ========");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 1명 정보 조회");
			System.out.println("4. 학생 이름으로 조회");
			System.out.println("5. 학생 정보 수정(인덱스)");
			System.out.println("6. 학생 1명 점수 조회(점수, 합계, 평균)");
			System.out.println("7. 학생 평균 최고점, 최저점 학생");
			System.out.println("0. 종료");
			System.out.print("메뉴 선택 : ");
			input = sc.nextInt();
			switch (input) {
			case 1:	System.out.println(addStudnet());	break;
			case 2:	selectAll();	break;
			case 3:	selectIndex();	break;
			case 4:	selectName();	break;
			case 5:	updateStudent();	break;
			case 6:	selectScore();	break;
			case 7:	selectMaxMin();	break;
			case 0:		System.out.println("[프로그램 종료]");		break;
			default:	System.out.println("잘못 입력");	break;
			}
		} while (input != 0);
	}
	
	
	// 학생 추가 화면
	private String addStudnet() {
		System.out.println("\n-------- 학생 추가 --------");
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		System.out.print("반 : ");
		int ban = sc.nextInt();
		System.out.print("번호 : ");
		int number = sc.nextInt();
		System.out.print("이름 : ");
		String name = sc.next();
		
		// 학년, 반, 번호, 이름을 StudentService로 전달하여
		// 객체 배열에 추가
		// 성공시 true, 실패 시 false 반환
		boolean result = sevice.addStudent(grade, ban, number, name);
		// 학생 추가 결과에 따라 수행
		if (result) {	//true
			return name + "학생이 추가되었습니다";
		}
		else {	// false
			return "학생을 더 이상 추가할 수 없습니다";
		}
	}
	
	
	/** 학생 전체 조회 */
	private void selectAll() {
		System.out.println("\n====== 학생 전체 조회 ======");
		// StudentService에서 학생배열(studentArr)을 반환 받아 오기
		Student[] arr = sevice.selectAll();
		// arr : 학생객체 배열 참조
		// arr[0] : 학생 객체 배열 중 0번 인덱스에 있는 참조 변수
		// -> 학생 객체 하나를 참조
		// 향상된 for 문
		// for ( 배열 요소 하나를 저장할 변수 : 배열명)
		// 배열 내 모든 요소를 접근하는 용도의 for문
		// 반복이 될 때 마다 인덱스가 자동으로 하나씩 증가
		for(Student s : arr) {
			if(s==null) { // 참조하는 학생 객체가 없는 참조 변수인 경우
				break;
			}
			// 학생 객체 필드에 있는 모든 값을 출력
			System.out.println(s.toString());
		}
	}
	
	
	/** 학생 1명 정보 조회(인덱스)*/
	private void selectIndex() {
		System.out.println("\n-------- 학생 1명 정보조회(인덱스) --------");
		System.out.print("조회할 학생의 인덱스 번호를 입력하세요 : ");
		int index = sc.nextInt();
		// StudentService 로 index를 전달하여
		// 해당하는 index에 학생 객체가 있으면 그 객체의 주소를 반환
		// 그런데 index에 학생이 없거나 범위가 초과되면 null 반환
		Student s = sevice.selectIndex(index);
		if (s == null) {	// 범위초과 또는 학생없음
			System.out.println("해당 인덱스에 학생정보가 존재하지 않습니다.");
			return;
		}
		else {
			System.out.println("학년 : " + s.getGrade());
			System.out.println("반 : " + s.getBan());
			System.out.println("번호 : " + s.getNumber());
			System.out.println("이름 : " + s.getName());
			System.out.println("국어점수 : " + s.getKor() + "점");
			System.out.println("영어점수 : " + s.getEng() + "점");
			System.out.println("수학점수 : " + s.getMath() + "점");
		}
	}
	
	
	/** 학생 1명 점수 조회(점수,합계,평균)*/
	private void selectScore() {
		System.out.println("\n-------- 학생 1명 점수조회(점수,합계,평균) --------");
		// 인덱스를 입력 받아 서비스로 전달하여(서비스) 
		// 인덱스 범위를 초과하거나 참조하는 학생 객체가 없으면
		// "해당 인덱스에 학생정보가 존재하지 않습니다"
		// 있으면 "[홍길동] 국어:30, 영어:40, 수학:50, 합계:120, 평균:40.0"
		// 문자열 (String)을 반환
		// 반환받은 문자열을 출력
		System.out.print("조회할 학생의 인덱스 번호를 입력하세요 : ");
		int index = sc.nextInt();
		String str = sevice.selectScore(index);
		System.out.println(str);
	}
	
	/** 학생 정보수정 */
	public void updateStudent() {
		// 인덱스 번호를 입력받고 해당 학생이 존재하면 국어,영어,수학 점수를 입력받아 수정후"수정되었습니다" 출력
		// 존재하지 않으면 "해당 인덱스에 학생정보가 존재하지 않습니다" 출력
		System.out.print("수정할 학생의 인덱스 번호를 입력하세요 : ");
		int index = sc.nextInt();
		Student s = sevice.selectIndex(index);
		if (s == null) {
			System.out.println("해당 인덱스에 학생정보가 존재하지 않습니다");
			return;
		}
		System.out.print("수정할 국어 점수를 입력하세요 : ");
		int kor = sc.nextInt();
		System.out.print("수정할 영어 점수를 입력하세요 : ");
		int eng = sc.nextInt();
		System.out.print("수정할 수학 점수를 입력하세요 : ");
		int math = sc.nextInt();
		
		sevice.updateScore(s, kor, eng, math);
		System.out.println("수정되었습니다");
	}
	
	public void selectName() {
		System.out.print("검색할 학생의 이름을 입력하세요 : ");
		String name = sc.next();
		Student[] arr = sevice.findName(name);
		if (arr == null) {
			System.out.println("일치하는 학생이 없습니다");
			return;
		}
		for( Student s : arr)
			System.out.println(s.toString());
	}
	
	public void selectMaxMin() {
		System.out.println("\n-------- 평균 최고점, 최저점 학생 찾기 --------");
		// 최고점 : 1학년 2반 3번 홍길동
		// 국어:100 / 수학:100 / 영어:100/ 평균:100.0
		// 최저점 : 3학년 5반 7번 최미영
		// 국어:50 / 수학:40 / 영어:30/ 평균:40.0
		
		Student[] arr = sevice.selectMaxMin();
		System.out.printf("최고점 : %d학년 %d반 %d번 %s \n"
				+ "국어:%d / 수학:%d / 영어:%d / 평균 : %.1f \n"
				, arr[0].getGrade(), arr[0].getBan(), arr[0].getNumber(), arr[0].getName()
				, arr[0].getKor(), arr[0].getMath(), arr[0].getEng(), 
				(arr[0].getKor() + arr[0].getMath() + arr[0].getEng() )/3.0);
		System.out.println();
		System.out.printf("최저점 : %d학년 %d반 %d번 %s \n"
				+ "국어:%d / 수학:%d / 영어:%d / 평균 : %.1f \n"
				, arr[1].getGrade(), arr[1].getBan(), arr[1].getNumber(), arr[1].getName()
				, arr[1].getKor(), arr[1].getMath(), arr[1].getEng(), 
				(arr[1].getKor() + arr[1].getMath() + arr[1].getEng() )/3.0);
	}
}






