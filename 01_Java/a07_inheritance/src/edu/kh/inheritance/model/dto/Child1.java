package edu.kh.inheritance.model.dto;

// 상속키워드 extends
// public class 자식클래스 extends 부모클래스
public class Child1 extends Parent {
	private String car;
	public Child1() {
		super();	// super 생성자 = 부모 생성자
		// 부모 객체가 먼저 생성된 후 자식 객체가 생성됨
		System.out.println("Child1() 기본 생성자로 자식객체 생성");
	}
	
	public Child1(String car) {
		super();
		System.out.println("Child1(String) 매개변수 생성자로 자식객체 생성");
		this.car = car;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}
	// 오버라이딩( Overriding )
	// 코드를 덮어 씌움
	// 부모로 부터 상속받은 메서드를 자식이 원하는 형태로 재정의 하는것
	// 오버라이딩의 특징
	// 부모의 메서드와 반환형, 메서드형,매개변수 같이 똑같음 내부코드는 다름
	@Override
	public String toString() {
//		getMoney()		// 부모 private필드 직접 접근 불가능
//		getLastName()
		return getMoney() + " / " + getLastName() + " / " + "car";
	}
	// 오버라이딩
	// 부모로부터 상속받은 getmoney() 재정의
	@Override
	public int getMoney(){
		System.out.println("오버라이딩한 getMoney");
		return (int)(super.getMoney() * 0.7);
		// 부모의 getMoney()
	}
}
