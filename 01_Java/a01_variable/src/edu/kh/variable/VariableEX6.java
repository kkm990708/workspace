package edu.kh.variable;

import java.beans.JavaBean;

public class VariableEX6 {
	public static void main(String[] args) {
		
//		boolean(1byte)
//		byte(1byte)
//		short(2byte)
//		int(4byte)
//		long(8byte)
//		float(4byte)
//		double(8byte)
//		char(2byte)
//		
//		String(문자열)
//		- 문자열을 저장하고 다루기 위해 java에서 제공하는 자료형
//		- 기본 자료형X
//		 -> Java 에서는 기본 자료형이 아닌 것들은
//		 모두 참조형이라고 지침함
//		 Sring 리터럴 표기범 : ""
		
		String str1;
//		String 자료형(문자열) 변수 선언
//		String 은 어떤 값이 저장될지 모르기 때문에
//		기본 자료형 처럼 크기가 지정되어 있지 않음
//		-> 저장되는 값에 따라서 달라짐
		
		str1 = "Hello";
		String str2 = "World";//변수 선언과 동시에 초기화
	
		System.out.println(str1 +" "+ str2);
	
	}
}
