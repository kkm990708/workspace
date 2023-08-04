package edu.kh.oop.constructor;

import java.security.PublicKey;
import java.util.jar.Attributes.Name;

public class UserRun {
	public static void main(String[] args) {
		User u1 = new User(); // -> 기본 생성자
		// 기본 생성자를 작성하지 않아도
		// 컴파일러가 자동으로 추가해주기 때문에 오류가 발생하지 않는다
		
		// 오버로딩으로 만든 다양한 생성자를 이용해 객체 생성
		User u2 = new User("김고");
		User u3 = new User(40, "박철수");
		User u4 = new User("김미영", 30);
		User u5 = new User("서울시 금천구", "홍길동");
		System.out.println("종료");
	}
	
}
