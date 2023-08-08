package edu.kh.collection.list.ex;

import java.util.ArrayList;
import java.util.List;

public class ListEx {
	// 컬렉션 특징
	// 1) 크기 제한X
	// 2) 추가, 수정, 삭제 등의 코드가 구현되어 있다
	// 3) 객체만 저장 가능
	
	// List : 자료를 순차적으로 나열한 자료구조 (배열과 비슷)
	// 특징 1 : 인덱스를 이용해서 순서를 구분
	// 특징 2 : 순서가 구분되기 때문에 중복데이터 저장이 가능
	
	public void ex1() {
//		List list = new ArrayList();	// 다형성 적용, 10칸짜리 생성
		List list = new ArrayList(3);	// 3칸짜리 생성
		
		// 1. boolean add(E e) : 마지막 요소로 추가
		// E(Element) : 요소를 뜻하는 상직적인 글자 (자료형 X)
		// -> Object를 생각하면 편함
		// Auto Boxing
		list.add("아무거나");
		list.add(123);		// int ->	Integer
		list.add(3.1313);	// double -> Double
		list.add(32.1313);	// double -> Double
		// 컬렉션에 저장되는 객체의 타입 제한 X
		// 기본 자료형
		// -> Wrapper Class(감싸는 클래스)
		// 기본 자료형을 객체로 만들 수 있게 감싸는 용도의 클래스
		// 기본 자료형 		boolean, byte, short, int		, long, float, double, char
		// Wraooer ckass	Boolean, Byte, Short, Integer	, Long, Float, Double, Character
		// 기본 -> 래퍼 : Boxing
		// 래퍼 -> 기본 : Unboxing
		// 상황에 따라 자동으로 <-> 객체가 되도록 구현됨
		// Auto Boxing / Auto Unboxing
		
		System.out.println(list);
		
		// 2. E get(int index) : 지정한 index요소 얻어오기
		System.out.println(list.add(1));
		System.out.println(list.add(21));
		System.out.println(list.add(1));
		System.out.println(list.get(1) instanceof Integer);
		System.out.println(list.get(2) instanceof Double);
		
		// List + for + if + instanceof + 다운 캐스팅
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof String) {
				String s = (String)list.get(i);
				System.out.println("첫 글자" + s.charAt(0));
			}
			if (list.get(i) instanceof Integer) {	// integer인 경우
				int number = (Integer)list.get(i);
				// Auto 언박식 자동으로 실행
				System.out.println(100+number);
			}
			if (list.get(i) instanceof Double) {
				Double d = (Double)list.get(i); // 다운캐스팅만
				System.out.println(d.BYTES + "바이트");
			}
		}
	}
}
