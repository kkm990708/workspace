package edu.kh.operator.ex;

import java.util.zip.ZipEntry;

public class OperatorEx3 {
	public static void main(String[] args) {
		//비교 연산자
		// >	<	 >=	  <=   ==	  !=
		//초과 미만 이상 이하 같은 같지않음
		
		int a = 100;
		int b = 200;
		
		System.out.println(a == b); //false
		System.out.println(a != b); //true
		System.out.println(a > b); //false
		System.out.println(a < b - 100); //false
		System.out.println(b <= a + a);
		System.out.println(a < b == true);
		
		System.out.println("[짝수 검사]");
		System.out.printf("3은 짝수? %b \n", 3 % 2 == 0);//%b 는 논리형 출력
		System.out.printf("4은 짝수? %b \n", 4 % 2 == 0);//%b 는 논리형 출력
		System.out.printf("6은 짝수? %b \n", 6 % 2 != 1);//%b 는 논리형 출력
		
		System.out.println("\n[홀수 검사]");
		System.out.printf("12345은 홀수? %b \n", 12345 % 2 == 1);
		System.out.printf("432는 홀수? %b \n", 432 % 2 != 0);
	
		System.out.println("---------------------");
		System.out.println("[3의 배수 검사]");
		//3의 배수 = 3의 나누었을때 나머지가 0인 수
		System.out.printf("12341234는 3의 배수? %b \n", 12341234 % 3 == 0);
		System.out.printf("999는 3의 배수? %b \n", 999 % 3 == 0);
	
		System.out.println("[13의 배수 검사]");
		//13 으로 나누었을때 나머지가 0인 수
		System.out.printf("3913는 13의 배수? %b \n", 3913 % 13 == 0);
		
	}
}
