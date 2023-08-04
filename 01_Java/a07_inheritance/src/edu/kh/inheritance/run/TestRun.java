package edu.kh.inheritance.run;

import edu.kh.inheritance.model.dto.Child1;
import edu.kh.inheritance.model.dto.Child2;
import edu.kh.inheritance.model.dto.Parent;

public class TestRun {
	public static void main(String[] args) {
		// 부모 객체 생성
		Parent p1 = new Parent();
		// ctrl + shift + o : import 자동추가
		// 단점 : 개발자가 직접 작성한 import 구문이 사라질 수도 있다
		Parent p2 = new Parent(100,"하");
		System.out.println("-----------------------------");
		Child1 c1 = new Child1("G70");
		Child2 c2 = new Child2("시그니엘");
		// 자식 객체를 생성했기 때문에 자식의 생성자가 실행됨
		// 왜 부모의 기본 생성자가 같이 실행?
		
		// 아무리 상속 받았다고 해도 private는 직접 접근이 불가능하다
		System.out.println("-----------------------------");
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println("-----------------------------");
		System.out.println(c1.getMoney());
		System.out.println("-----------------------------");
		Child2 c3 = new Child2(900, "김", "원룸");
		System.out.println(c3.getMoney());	//Parent
		System.out.println(c3.getLastName()); //Parent
		System.out.println(c3.getHouse());	//Child2
		System.out.println(c3.toString());
	}
	
}
