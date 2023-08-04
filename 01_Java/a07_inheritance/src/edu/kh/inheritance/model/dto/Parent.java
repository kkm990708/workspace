package edu.kh.inheritance.model.dto;

// 클래스 final 상속불가
public class Parent extends Object {
					// 미작성 시 컴파일러가 추가
					// 모든 클래스의 최상위 클래스
	private int money = 100_000_000;
	private String lastName = "홍";
	public Parent() {
		System.out.println("Parent() 기본 생성자로 부모객체 생성");
	}
	
	public Parent(int money, String lastName) {
		System.out.println("Parent(int, String) 매개변수 생성자로 부모객체 생성");
		this.money = money;
		this.lastName = lastName;
	}
	
	// 메서드 final 오버라이딩
	public void setMoney(int money) {
		this.money = money;
	}
	public int getMoney() {
		return money;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}
	
	@Override // Object의 toString() 오버라이딩
	// toString() : 객체의 필드를 하나의 문자열로 변환
	public String toString() {
		return money + " / " + lastName; 
	}
}

// final 자료형 변수형 -> 상수
// public final class 클래스명 -> 상속불가
// public final void 메서드명() -> 오버라이딩 불가
