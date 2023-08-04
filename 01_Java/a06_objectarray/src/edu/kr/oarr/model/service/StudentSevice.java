package edu.kr.oarr.model.service;

import java.util.Random;

import edu.kr.oarr.model.dto.Student;

public class StudentSevice {
	// 필드
	private Student[] studentArr = new Student[10];
	// 학생 객체 참조 변수 10개의 묶음 Student[]을 할당
	// 그 주소를 studentArr에 대입
	// studentArr[0], studentArr[1], studentArr[2] ...
	// 각 배열 요소 하나하나는 Student 객체 참조 변수가 된다
	
	// 기본 생성자
	// 학생 객체 배열에 들어갈 샘플 학생 데이터를 3개 추가
	public StudentSevice() {
		studentArr[0] = new Student(1,2,3,"홍길동");
		studentArr[1] = new Student(2,3,13,"박철수");
		studentArr[2] = new Student(3,6,24,"최미영");
		
		Random random = new Random();	// 랜덤 객체 생성
		for (int i = 0; i < studentArr.length; i++) {
			// studentArr[3] 부터 참조하는 학생 개체가 없음
			// == null : 참조하는 객체가 없음을 뜻하는 값
			
			if(studentArr[i] == null) {
				break;	// 학생 객체가 없으면 반복문 멈춤
			}
			//random.nextInt(101)
			//정수형 난수 0 이상 101 미만의 정수형 난수를 반환
			studentArr[i].setKor(random.nextInt(101));
			studentArr[i].setEng(random.nextInt(101));
			studentArr[i].setMath(random.nextInt(101));
		}
	}
	
	
	/** 학생 추가 서비스 입니다 */
	public boolean addStudent(int grade, int ban, int number, String name) {
		// TODO Auto-generated method stub
		// 1. studentArr의 요소 중 참조하는게 없는 배열요소를 찾아
		// 그 중 index 번호가 가장 낮은 요소에 학생 객체 주소를 대입
		// true 반환
		for (int i = 0; i < studentArr.length; i++) {
			if (studentArr[i] == null) {	// 참조하는게 없을 경우 학생 객체를 생성하여 주소를 대입
				studentArr[i] = new Student(grade, ban, number, name); 
				// return : 현재 메서드를 즉시 멈추고 호출한 곳으로 돌아감
				return true;
			}
		}
		// 2. StudentArr의 요소 중 참조하는게 없는 배열요소가 없을경우 (꽉찬경우)
		// false 반환
		return false;
	}


	public Student[] selectAll() {
		return studentArr;
	}


	public Student selectIndex(int index) {
		// index가 배열 범위를 초과 하거나
		// studentArr[index] 요소가 저장한 값이 null인경우
		// null반환
		if (index < 0 ||
			index > studentArr.length ||
			studentArr[index] == null) {
			return null;
		}
		return studentArr[index];
	}


	public String selectScore(int index) {
		if (index < 0 ||
			index > studentArr.length ||
			studentArr[index] == null) {
			return "해당 인덱스에 학생정보가 존재하지 않습니다";
			}
		Student s = studentArr[index];
		int sum = s.getKor() + s.getEng() + s.getMath();
		return String.format("[%s] 국어:%s, 영어:%d, 수학:%d, 합계:%d, 평균:%.1f",
				s.getName(), s.getKor(), s.getEng(), s.getMath(), sum, sum/3.0 );
	}

	public void updateScore(Student s, int kor, int eng, int math) {
		s.setKor(kor);
		s.setEng(eng);
		s.setMath(math);
	}


	public Student[] findName(String name) {
		String str ="";
		int count = 0;
		for (Student s : studentArr) {
			// nullPointerException null을 참조해서 필드,메서드 접근시 발생
			// null 방지히
			if (s == null) {
				break;
			}
			// 1. 반환하려는 studnet 객체 배열의 크기를 StudentArr 과 똑같이 만든후 검색한 학생을 차례대로
			// 배열에 추가후 반환 -> for 문으로 출력시 배열 요소가 null 인경우 반복 종료
			// 2. 같은 이름의 학생을studnetArr 배열에서 찾아 카운트 한 후 카운트한 크기 만큼의 학생객체 배열을 생성 후
			// 같은 이름의 학생을 찾아 생성한 배열에 추가 
			if (s.getName().equals(name)) {
				count++;
				str = String.format("이름:%s, 반:%d, 번호:%d, 이름:%s, 국어:%d, 영어:%d, 수학:%d \n", 
									s.getName(),s.getGrade(),s.getNumber(),s.getName(),s.getKor(),s.getEng(),s.getMath());
						//학년, 반, 번호, 이름, 국어점수, 영어점수, 수학점수 
			}
			if (count == 0) {
				return null;
			}
		}
		Student[] arr= new Student[count];
		int index = 0;	// 검색된 학생 객체의 주소를 arr 배열의 몇번 인덱스에 대입해야 되는지를 제어
		for(Student s : studentArr) {;
			if (s == null) {
				break;
				}
			if (s.getName().equals(name)) {
				arr[index] = s;
			}
		}
	return arr;
	}


	public Student[] selectMaxMin() {
		Student[] arr = new Student[2]; // [0] : 최고점, [1] 최저점
		// 인덱스
		int max = 0;
		int min = 0;
		for (int i = 0; i < studentArr.length; i++) {
			if (studentArr[i] == null) {
				break;
			}
			
			Student s1 = studentArr[max];
			int maxSum = s1.getKor() + s1.getEng() + s1.getMath();

			Student s2 = studentArr[min];
			int minSum = s2.getKor() + s2.getEng() + s2.getMath();
			
			// 현재 인덱스(i) 번째 요소의 합
			Student s3 = new Student();
			int Sum = s3.getKor() + s3.getEng() + s3.getMath();
			if (Sum > maxSum) {
				max = i;
			}
			if (Sum < minSum) {
				min = i;
			}
					
		}
		arr[0] = studentArr[max];
		arr[1] = studentArr[min];
		return arr;
	}
	
}
