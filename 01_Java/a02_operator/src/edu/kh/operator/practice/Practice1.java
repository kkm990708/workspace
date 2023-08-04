package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice1 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("인원 수 : ");
		int mans = scanner.nextInt();
		System.out.print("사탕 개수 : ");
		int candys = scanner.nextInt();
		
		System.out.println("1인당 사탕 개수 : " + candys / mans);
		System.out.println("남는 사탕 개수 : " + candys % mans);
	}
}
