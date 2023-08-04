package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("나이 : ");
		int input = scanner.nextInt();
		
		String result = input > 19 ? "성인" : (input <= 13 ? "어린이" : "청소년");
		System.out.println("\n" + result);
	
	}
}
