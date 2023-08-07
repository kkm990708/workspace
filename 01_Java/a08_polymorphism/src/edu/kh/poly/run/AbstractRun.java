package edu.kh.poly.run;

import edu.kh.poly.model.dto.Animal;
import edu.kh.poly.model.dto.Fish;
import edu.kh.poly.model.dto.Person;

public class AbstractRun {
	public static void main(String[] args) {
		// 1. 추상 클래스는 진짜로 개채를 못만들까?
//		Animal animal = new Animal();
		
		// 상속받은 자식 클래스는 객체 생성 가능
		Person person = new Person("포유류","잡식","홍길동", 25);
		Fish fish = new Fish("어류","육식", 4);
		
		// 추상 클래스는 부모 타입 참조 변수는 가능
		Animal a1 = person;	// Animal 참조변수 = Person 객체 주소
		Animal a2 = fish;	// Animal 참조변수 = fish 객체 주소
		
		// 추상 클래스 + 다형성 업캐스팅 + 동적 바인딩
		System.out.println(a1.toString());
		a1.breath();
		// 동적 바인딩의 성질을 이용하여
		// 추상 메서드인 Animal.breath()가 호출되는 경우가 없게 만듬
		System.out.println();
		System.out.println(a2.toString());
		a2.breath();
		
		System.out.println("\n-----------------------------------");
		System.out.println(a1);
		// 참조변수를 print 구문에 작성시 컴파일러가 .toString()을 붙여줌
		
	}
}
