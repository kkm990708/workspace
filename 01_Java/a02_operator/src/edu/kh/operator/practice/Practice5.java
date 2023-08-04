package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice5 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int korean = scanner.nextInt();
		System.out.print("영어 : ");
		int english = scanner.nextInt();
		System.out.print("수학 : ");
		int math = scanner.nextInt();
		
		int sum = korean + english + math;
		double average = (double)sum / 3;
		String result = korean >= 40 && english >= 40 && math >=40 && average >=60 ? "합격" : "불합격";
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + average);
		System.out.println(result);
		
	}
}
