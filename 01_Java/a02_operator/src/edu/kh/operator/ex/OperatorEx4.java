package edu.kh.operator.ex;

import java.util.Scanner;

public class OperatorEx4 {
	public static void main(String[] args) {
		// 배수 확인 프로그램
		// 확인할수 : 15
		// 배수 : 4
		//
		// 15는 4의 배수? false
		Scanner scanner = new Scanner(System.in);		
		System.out.print("[배수 확인 프로그램]");
		System.out.print("확인할수 : ");
		int checknum = scanner.nextInt();
		System.out.print("배수 : ");
		int num2 = scanner.nextInt();
		boolean result = checknum % num2==0;
		
		System.out.printf("\n%d는 %d의 배수? %b", checknum , num2, result);
	}
}
