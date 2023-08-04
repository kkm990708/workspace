package edu.kh.control.condition.Practice;

import java.util.Scanner;

public class ConditionPractice {
	
	
	//실습 문제1
	public void practice1() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 한 개 입력하세요 : ");
		int input = scanner.nextInt();
		if (input <= 0) {
			System.out.println("양수만 입력해주세요");
		}
		else if (input % 2 == 0) {
			System.out.println("짝수입니다");
		}
		else {
			System.out.println("홀수입니다");
		}
		
	}

	
	//실습 문제2
	public void practice2() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어점수 : ");
		int korean = scanner.nextInt();
		System.out.print("영어점수 : ");
		int math = scanner.nextInt();
		System.out.print("수학점수 : ");
		int english = scanner.nextInt();
			
		int sum = korean + math + english;
		double avg = sum/3.0; 
		
		if (korean >= 40 && english >= 40 && math >=40 && avg >= 60) {
			System.out.println("국어 : " + korean);
			System.out.println("수학 : " + math);
			System.out.println("영어 : " + english);
			System.out.println("합계 : " + sum);
			System.out.println("평균 : " + avg);
			System.out.println("축하합니다, 합격입니다!");
		}
		else {
			System.out.println("불합격 입니다.");
		}
	}
	
	
	//실습 문제3
	public void practice3() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = scanner.nextInt();
		int data = 0;
		switch (month) {
		case 2 : data = 28;
		break;
		case 4: case 6: case 9: case 11: data = 30;
		break;
		case 1: case 3: case 5: case 7: case 8: case 10: case 12: data = 31; 
		break;
		}
		if (data == 0) {
			System.out.println(month + "월은 잘못 입력된 날입니다");
		}else {
			System.out.printf("%d월은 %d일까지 있습니다", month,data);
		}
		
	}
	
	
	//실습 문제4
	public void practice4() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = scanner.nextDouble();
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = scanner.nextDouble();
		double bmi = weight / (height * height);
		System.out.println("BMI 지수 : " + bmi);
		String result = null;
		
		
		if (bmi < 18.5) {
			result = "저체중";
		}
		else if (bmi < 23) {
			result = "정상체중";
		}
		else if (bmi < 25) {
			result = "과체중";
		}
		else if (bmi < 30) {
			result = "비만체중";
		}
		else {
			result = "고도 비만";
		}
		System.out.print(result);
	}
	
	
	//실습 문제5
	public void practice5() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("중간 고사 점수 : ");
		int middleTest = scanner.nextInt();
		System.out.print("기말 고사 점수 : ");
		int lastTest = scanner.nextInt();
		System.out.print("과제 점수 : ");
		int homeTest = scanner.nextInt();
		System.out.print("출석 횟수 : ");
		int check = scanner.nextInt();
		
		System.out.print("===============결과===============\n");
		
		if (check <= 14) {
			System.out.printf("Fail [출석 횟수 부족 (%d/20)]",check);
		}
		else {
			double midScore = middleTest * 0.2;
			double lastScore = lastTest * 0.3;
			double homeScore = homeTest * 0.3;
			double checkScore = (double)check;
			double totalScore = midScore + lastScore + homeScore + checkScore;

			System.out.println("중간 고사 점수(20) : " + midScore);
			System.out.println("기말 고사 점수(30) : " + lastScore);
			System.out.println("과제 점수	(30) : " + homeScore);
			System.out.println("출석 점수	(20) : " + checkScore);
			System.out.println("총점 : " + totalScore);
			if (totalScore >= 70) {
				System.out.println("PASS");
			}
			else {
				System.out.println("Fail [점수 미달]");
			}
		}
	}
}
