package edu.kh.oop.constructor;

public class MemberRun {
	public static void main(String[] args) {
		// 회원 객체 생성
		Member member1 = new Member();
		// Member() : 생성자
		Member member2 = new Member("testMember");
		Member member3 = new Member("다른 아이디1");
		System.out.println("종료");
	}
}
