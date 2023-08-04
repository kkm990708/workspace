package edu.kh.oop.field.pack2;

import javax.swing.ActionMap;

public class StudentRun {
	public static void main(String[] args) {
		Student s1= new Student();
		
		s1.grade = 3;
		s1.ban = 5;
		s1.number = 12;
		s1.name = "홍길동";
		s1.SchoolName = "중구중학교";
		
		Student s2= new Student();
		
		s2.grade = 3;
		s2.ban = 5;
		s2.number = 12;
		s2.name = "홍길동";
		s2.SchoolName = "중구중학교";
		
		Student s3= new Student();
		
		s3.grade = 3;
		s3.ban = 5;
		s3.number = 12;
		s3.name = "홍길동";
		s3.SchoolName = "중구중학교";

		
		
		// 프로그램 실행 중 학교명 변경가능 추가
		System.out.println("변경전 학교명"); 
		System.out.println(s1.SchoolName);
		System.out.println(s2.SchoolName);
		System.out.println(s3.SchoolName);
		System.out.println("---------변경 후 학교명---------");
//		s1.SchoolName = "중고 과학중";
		
		//static 이 붙은 필드를 다룰때는 클래스명.필드명 으로 작성을 권장
		Student.SchoolName = "중구 외국어 중학교";
		
		System.out.println(s1.SchoolName);
		System.out.println(s2.SchoolName);
		System.out.println(s3.SchoolName);
		
		// SchoolName 필드를 static 으로 변경하면
		// 한학생의 학교명만 변경해도 모두 변경
	}
}
