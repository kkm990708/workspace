package edu.kh.oop.field.pack1;

public class FieldTest1 {
	//필드 (== 멤버 변수)
	// 객체의 속성을 필드라고 부름
	
	// 작성범
	// [접근제한자] [예약어] 자료형 변수형 [=자료값]
	// 접근 제한자 종류
	// public : 같은 패키지 + 다른 패키지 (모두,어디서든) 접근 가능
	// protected : 같은 패키지 + 다른 패키지중 상속 관계 클래스 에서만 접근 가능
	// (default) : 같은 패키지 내부에서만 접근 가능
	// private : 현재 클래스 내부에서(현재 객체)만 접근가능
	
	public int v1 = 10;
	protected int v2 = 20;
	/* (default) */ int v3 = 30;
	private int v4 = 40;
}
