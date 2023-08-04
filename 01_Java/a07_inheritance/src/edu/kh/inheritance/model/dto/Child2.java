package edu.kh.inheritance.model.dto;

// Parent를 상속 받겠다
// Chile2가 Parent의 필드, 메서드를 내부에 포함하게되어 자신의 것처럼 사용
// 단 Parent의 필드 메서드 중 private 설정된것은 자식이 다룰 수 없다
public class Child2 extends Parent {
	private String house;
	public Child2() {
		super(); // 상속 관계 시 부모 객체가 먼저 생성되어야 하기 때문에
		// 자식 생성자 첫 번째 줄에 무조건 작성!
		// 미작성 시 컴파일러가 추가
		System.out.println("Child2() 기본 생성자로 자식객체 생성");
	}
	public Child2(String house) {
		super();
		System.out.println("Child2(String) 매개변수 생성자로 자식객체 생성");
		this.house = house;
	}
	
	public Child2(int money, String lastName, String house) {
		// 자식 객체 생성시
		// 매개변수가 있는 super()생성자를 이용해 부모 객체의 필드도 초기화할 수 있다.
		super(money, lastName);
		this.house = house;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	
	@Override	// 오버라이딩 문법검사
	public String toString() {
		
		// 부모로부터 상속받은 멤버(필드, 메서드)를 자식이 자신의 것 처럼 사용 가능하다
		// 부모의 toString()을 사용하여 반환된 결과를 사용
		return super.toString()+ " / " + house;
	}
}
