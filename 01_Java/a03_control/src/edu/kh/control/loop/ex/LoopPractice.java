package edu.kh.control.loop.ex;

import java.util.Iterator;
import java.util.Scanner;

public class LoopPractice {
	public void ex1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		if (input >= 1) {
			for (int i = 1; i <= input; i++) {
				System.out.print(i + " ");
			}
		}
		else {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}
	}
	
	public void ex2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		if (input >= 1) {
			for (int i = input; i >= 1; i--) {
				System.out.print(i + " ");
			}
		}
		else {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}
	}
	
	public void ex3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 하나 입력하세요 : ");
		int sum = 0;
		int input = sc.nextInt();
		for (int i = 1; i <= input; i++) {
			if (i == input) {
				System.out.print(i + " = ");
			}
			else {
				System.out.print(i + " + ");
			}
			sum += i;
		}
		System.out.println(sum);
	}
	
	public void ex4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 숫자 : ");
		int input = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int input2 = sc.nextInt();
		if (input < 1 || input2 < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요");
			}
		else if (input >= input2) {
			for (int i = input2; i <= input; i++) {
				System.out.print(i + " ");
			}
		}
		else {
			for (int i = input; i <= input2; i++) {
				System.out.print(i + " ");
				}
			}
		}
	
	public void ex5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : "); 
		int dan = sc.nextInt();
		System.out.printf("======= %d단 ======= \n",dan);
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d X %d = %d\n",dan,i,dan*i);
		}
	}
	
	public void ex6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : "); 
		int dan = sc.nextInt();
		if (dan >= 2 && dan <= 9) {
			for (int j = dan; j <= 9; j++) {
				System.out.printf("\n======= %d단 =======\n",j);
				for (int i = 1; i <= 9; i++) {
					System.out.printf("%d X %d = %d\n",j,i,j*i);
				}
			}
		}
		else {
			System.out.println("2 ~ 9 사이 숫자만 입력해 주세요");
		}
	}
	
	public void ex7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for (int i = 1; i <= input ; i++) {
			
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	public void ex8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for (int i = 1; i <= input ; i++) {
			
			for (int j = input; j >= i; j--) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	public void ex9() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for (int i = 1; i <= input ; i++) {
			
			for (int j = input -1 ; j >= i; j--) {
				System.out.print(" ");
			}
			
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	public void ex10() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for (int i = 1; i <= input ; i++) {
			
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = 1; i <= input -1 ; i++) {
			
			for (int j = input - 1; j >= i; j--) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	public void ex11() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for (int i = 1; i <= input ; i++) {
			
			for (int j = input -1 ; j >= i; j--) {
				System.out.print(" ");
			}
			
			for (int j = 1 ; j <= i * 2 - 1 ; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	public void ex12() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		for (int i = 1; i <= input; i++) {
			System.out.print("*");
		}
		System.out.println();
		for (int i = 1; i <= input; i++) {
			System.out.print("*");
			for (int j = 1; j < input - 1; j++) {
				System.out.print(" ");
			}
			System.out.print("*\n");
		}
		for (int i = 1; i <= input; i++) {
			System.out.print("*");
		}
	}
	
	public void ex13() {
		Scanner sc = new Scanner(System.in);
		System.out.print("자연수 하나를 입력하세요 : ");
		int input = sc.nextInt();
		int sum = 0;
		for (int i = 2; i <= input; i++) {
			
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
			else if (i % 3 == 0) {
				System.out.print(i + " ");
			}
			if (i % 2 == 0 && i % 3 == 0) {
				sum++;
			}
		}
		System.out.println("\ncount : " + sum);
	}
}
