package edu.kh.exception.model.dto;

public class UserException extends Exception{
	// 사용자 정의 예외
	// 자바에서 제공하지 않는 예외를 직접 만드는 방법
//	1. Exception 클래스 아무거나 상속받기 
//		단 Unchecked 로 만들고 싶으면 RuntimeEXception 관련 예외 상속받기
//	2. 생성자 만들기
	public UserException() {
		super("사용자 예외 발생");
	}
}










