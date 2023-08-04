package edu.kh.operator.ex;

import java.util.Scanner;

public class OperatorEx6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("[홀짝 검사기]");
		System.out.print("정수를 입력하세요 : ");
		int input = scanner.nextInt();
		
		//삼항 연산자
		//조건식(true/false) ? true 인 경우 : false 인 경우;
		
		String result = input % 2 == 0 ? "짝수" : "홀수" ;
		
		System.out.println(result);
		
		
		
		
		
		
		
		
		
	
	}
}
