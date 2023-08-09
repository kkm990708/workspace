package edu.kh.collection.list.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import edu.kh.collection.list.model.dto.Student;


public class StudentService {
	
	private List<Student> studentList // = new ArrayList<>();	// 검색 효율이 좋은 리스트
									  = new LinkedList<>();	// 추가, 제거 효율이 좋은 리스트
	
	public StudentService() {
		studentList.add(new Student(3, 2, 17, "홍길동", 'M', 75));
		studentList.add(new Student(5, 4, 30, "홍길동", 'F', 50));
		studentList.add(new Student(5, 4, 17, "홍길동", 'M', 40));
		studentList.add(new Student(2, 4, 12, "김갑순", 'F', 80));
		studentList.add(new Student(1, 1, 20, "박흥민", 'M', 55));
		studentList.add(new Student(3, 3, 4, "이미영", 'F', 90));
		studentList.add(new Student(1, 4, 9, "김샛별", 'F', 45));
	}

	/** param : parameter : ( 전달 인자 = 전달 받은값)
	 * @param grade	
	 * @param ban
	 * @param number
	 * @param name
	 * @param gender
	 * @param score
	 * @return boolean : true
	 */
	public boolean addStudent(int grade, int ban, int number, String name, char gender, int score) {
		// 전달 받은값을 이용해서 학생 객체를 만들어 
		// StudnetList에 추가 후 boolean 반환
		// 중복 검사 후 추가하기
		// 1) 중복 검사 메서드 호출(중복이면 true 아니면 false)
		boolean result = duplicateValidation(grade, ban, number, name, gender, score);
		
		// 2) 중복이면 false 반환 아니면 List.add() 호출 후 결과 반환
		if (result) {	// true 인 경우 == 중복
			return false;
		}
		return studentList.add(new Student(grade, ban, number, name, gender, score));
	}

	/** 학생 List 반환 service 메서드
	 * @return
	 */
	public List<Student> selectAllStudent() {

		return studentList;	// 학생이 저장된 List를 초룰한 곳으로 돌려보내줌
	}

	
	
	/** 인덱스가 일치하는 학생 1명 조회
	 * @param index
	 * @return
	 */
	public Student selectOne(int index) {
		// studentList의 index 범위를 넘어선 경우
		if (index >= studentList.size() || studentList.size() < 0) {
			return null;
		}
		return studentList.get(index);
	}

	
	/** 인덱스가 일치하는 학생 삭제 service 메서드
	 * @param index
	 * @return Student 객체 주소 또는 null
	 */
	public Student deleteStudent(int index) {
		return studentList.remove(index);
	}

	/** 학생 성별 조회 sevice 메서드
	 * @param gender
	 * @return searchList
	 */
	public List<Student> selectGender(char gender) {
		// 검색 결과를 저장할 List 부터 생성
		List<Student> searchList = new ArrayList<Student>();
		
		// 향상된 for문 : for(요소 1개 참조 변수 : 배열 또는 컬렉션)
		// -> 매 반복마다 배열 또는 컬렉션의 요소를 순서대로 하나씩 꺼내어 참조 변수에 대입하는 반복문
		for (Student s : studentList) {
			if (gender == s.getGender()) {
				searchList.add(s);
			}
		}
		return searchList;
	}

	public List<Student> selectGrade(int grade) {
		List<Student> searchList = new ArrayList<Student>();
		
		for (Student s : studentList) {
			if (grade == s.getGrade()) {
				searchList.add(s);
			}
		}
		return searchList;
	}

	/** 이름 검색 service 메서드
	 * @param name
	 * @return searchList
	 */
	public List<Student> selectName(String name) {
		List<Student> searchList = new ArrayList<Student>();
		for(Student s : studentList) {
			// String(객체) 값 비교시 A.equals(B) 사용
			// s.getName() == name (주소 비교)
			// s.getName().equals(name) (객체의 값(필드) 비교)
			if (s.getName().equals(name)) {
				searchList.add(s);
			}
		}
		return searchList;
	}

	/** 학생 중복 확인 service 메서드
	 * @param grade
	 * @param ban
	 * @param number
	 * @param name
	 * @param gender
	 * @param score
	 * @return 중복 있으면 true, 없으면 false
	 */
	public boolean duplicateValidation(int grade, int ban, int number, String name, char gender, int score) {
		// 전달받은 값으로 학생 객체 생성
		Student s = new Student(grade, ban, number, name, gender, score);
		// boolean List.conrains(요소)
		// - 요소가 List에 있으면 true 없으면 false
		//
		// contains 사용 전제조건 
		// 비교하려는 객체(클래스)에 Object의 equals()가
		// 오버라이딩 되어있어야 한다
		
		return studentList.contains(s);
	}

	/** 성적 순서로 정렬 service 메서드
	 * @return 정렬된 학생 목록
	 */
	public List<Student> sortScore() {
		// Objects / Arrays / Collections : 유용한 기능 모음
		// Collections : 컬렉션의 유용한 기능 모음
		// Collections.sort(List) : 원본 List가 정렬
		// -> 이 기능을 사용하려면 List의 요소(Student)에 정렬 기준을 정하는 코드가 있어야함
		Collections.sort(studentList); // -> 점수 오름차순 (점점 커지는 순서) 정렬
		Collections.reverse(studentList); // List 순서를 뒤집음 (오름 -> 내림)
		return studentList;
	}
	
	
}
