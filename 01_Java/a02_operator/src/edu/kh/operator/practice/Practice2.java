package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = scanner.nextInt();
		String result = input > 0 ? "양수" : "양수아님";
		System.out.println("\n"+result);
	}
}
