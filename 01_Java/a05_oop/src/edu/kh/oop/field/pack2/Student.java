package edu.kh.oop.field.pack2;

public class Student {
	public int grade = 3;	//번호
						// 명시적 초기화
	public int ban;		//반
	public int number; //번호
	public String name; //이름 
	public static String SchoolName = "중구중학교";
	// 클래스 변수
	// 필드에 작성되고 static이 붙은 변수
	// static 메모리 영역에 생성될때
	// 클래스명.변수명 으로 생성되기 때문에 클래스 변수라고 부른다
	// static : 같은 타입의 객체끼리 필드 공유 목적
	// static 메모리 영역 == 정적 메모리 영역
	// 프로그램 실행시 static 영역에 고정
	// 고정된 static을 프로그램 어디서든 사용가능
	
	// 인스턴스 초기화 블럭
	// 인스턴스 변수 : 인스턴스 생성시 할당되는 변수
	// -> 필드에 작성되고 static이 없는 변수 
	{
		// 인스턴스 생성시
		// 인스턴스 변수 (static 없는 필드)를 초기화 하는 용도

		grade = 5;
		ban = 10;
		number = 99;
		name = "임시";
	}
	
	// 클래스 초기화 변수 
	static {
		SchoolName = "서울 중구 중학교"; // 인스턴스 변수는 클래스 초기화 블럭에서 초기화 불가능
	}
	public void study() {
		System.out.println("공부합시다");
	}
}
