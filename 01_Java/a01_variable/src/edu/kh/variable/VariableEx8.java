package edu.kh.variable;

public class VariableEx8 {
	public static void main(String[] args) {
//		형변환 : 값의 자료형을 변환하는것
//		->	컴퓨터의 값 처리 원픽을 위배하는 경우를 해결하기 위해
//		
//		자동 형변환
//		[값의 범위] 가 서로 다른 값의 연산시
//		컴파일러 가 자동으로 [값의 범위]가 작은 자료형을 큰 자료형으로 변경
		
		//	자동 형변환 1
		int num = 10;
		long num2 = 100L;
		//	num + num2;
		//	(int)num + (long)num2;
		//	(long)num + (long)num2;
		long result1 = num + num2;
		System.out.println("result1 : "+ result1);
	
		//	자동 형변환 2
		int num3 = 300;
		double num4 = 12.3;
		//	(int)num3 + (double)num4;
		//	(double)num3 + (double)num4;
		double result2 =  num3 + num4;
		System.out.println(num3 + " + " + num4 + " = " + (num3+num4));
		
		//	자동 형병환 3
		char ch1 = 'A';
//		문자 A 가 저장되는게 아니라
//		유니코드 표에서 A 에 대응되는 값 65 가 저장된다
		int result3 = ch1 + 0;
//		(char)'A' + (int)0
//		(int)65 + (int)0
		System.out.println("result3 : " + result3);
		
//		강제 형변환
//		값의 범위가 큰 자료형을 작은 자료형으로 변경
		
		
//		강제 형변환 1: 실수 -> 정수(데이터 손실)
		double test1 = 3.14;
//		int test2 = test1;
//		double 자료형을 int 로 바꿀수 없다
		int test2 = (int)test1;
		// 실수 -> 정수 강제 형변환시
		// 소수점 아래 버림 처리 (데이터 손실)
		System.out.println("test1 : "+ test1);
		System.out.println("test2 : "+ test2);
		
		
//		강제 형변환 2 : 정수 -> 정수 (데이터 손실)
		int test3 = 290;
		byte test4 = (byte)test3;
		System.out.println("test3 : "+ test3);
		System.out.println("test4 : "+ test4);
	
		
//		강제 형변환 3 : 실수 -> 실수 (데이터 손실)
		double test5 = 3.12345678901234;
		float test6 = (float)test5;
		System.out.println("test5 : "+ test5);
		System.out.println("test6 : "+ test6);
	
		
//		강제 형변환 4
		int test7 = 123;
		System.out.println("(double)test7 : " + (double)test7);
			
		System.out.println('A');
		System.out.println((int)'A');
		System.out.println((char)66);
		
		// 오버 플로우
		byte bNum1 = 127;
		byte bNum2 = (byte)(bNum1 + 1);
		System.out.println("bNum1 : " + bNum1);
		System.out.println("bNum2 : " + bNum2);
		
	}
}
