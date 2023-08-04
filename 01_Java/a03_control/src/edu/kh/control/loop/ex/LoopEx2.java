package edu.kh.control.loop.ex;

import java.util.Iterator;
import java.util.Scanner;

public class LoopEx2 {
	
	//구구단 2단 출력하기
	public void ex1() {
		System.out.println("구구단 2단 출력하기");
		for (int i = 1; i <= 9; i++) {
			System.out.printf("2 X %d = %d\n", i, (2*i));
		}
	}
	
	// 입력 받은 단 출력하기
	// 단 입력 : 3
	// [구구단 3단]
	public void ex2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("단 입력 : "); 
		int dan = sc.nextInt();
		System.out.printf("[구구단 %d단] \n",dan);
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d X %d = %d\n",dan,i,dan*i);
		}
	}
	
	// 입력받은 단 출력하기
	// 조건 : 입력 받은 값이 2 ~ 9 사이 일때만 구구단 출력
	// 2 ~ 9 사이가 아닐 경우 "잘못 입력하셧습니다" 출력
	public void ex3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("단 입력 : "); 
		int dan = sc.nextInt();
		if (dan >= 2 && dan <= 9) {
			System.out.printf("[구구단 %d단] \n",dan);
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d X %d = %d\n",dan,i,dan*i);
			}
		}
		else {
			System.out.println("잘못 입력하셧습니다");
		}
	}
	
	// 5 4 3 2 1 출력하기
	public void ex4() {
		for(int i = 5 ; i >= 1 ; i--) {
			System.out.print(i + " ");
		}
	}
	
	// 9 8 7 6 5 4
	public void ex5() {
		for(int i = 9 ; i >= 4 ; i--) {
			System.out.print(i + " ");
		}
	}
	
	// 충첩 반복문
	// 12345
	// 12345
	// 12345
	// 12345
	// 12345
	public void ex6() {
		for (int j = 1; j <= 5; j++) {
			for (int i = 1; i <= 5; i++) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	// 54321
	// 54321
	// 54321
	// 54321
	public void ex7() {
		for (int j = 1; j <= 4; j++) {
			for (int i = 5; i >= 1; i--) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	//(0,0) (0,1) (0,2)
	//(1,0) (1,1) (1,2)
	public void ex8() {
		for (int j = 0; j <= 1; j++) {
			for (int i = 0; i <= 2; i++) {
				System.out.printf("(%d,%d) ", j,i);
			}
			System.out.println();
		}
	}
	
	// 2단부터 9단까지 모두 출력하기
	public void ex9() {
		for (int j = 2; j <= 9; j++) {
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d X %d = %d\n",j,i,j*i);
			}
			System.out.println("--------------------------");
		}
	}
	
	public void ex10() {
		for (int j = 9; j >= 2; j--) {
			System.out.printf("[%d단]\n", j);
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d X %d = %d\n",j,i,j*i);
			}
			System.out.println("--------------------------");
		}
	}
	
	// 구구단 입력하기
	// 1 입력시 2 ~ 9 순서로 출력
	// 2 입력시 9 ~ 2 순서로 출력
	// 1,2, 가 아니면 "잘못 입력하셧습니다" 출력
	public void ex11() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1) 2 ~ 9 순서대로  /  2) 9 ~ 2 역순으로 : ");
		int sellect = sc.nextInt();
		if (sellect == 1) {
			for (int j = 2; j <= 9; j++) {
				System.out.printf("[%d단]\n", j);
				for (int i = 1; i <= 9; i++) {
					System.out.printf("%d X %d = %d\n",j,i,j*i);
				}
				System.out.println("--------------------------");
			}
		}
		else if (sellect == 2) {
			for (int j = 9; j >= 2; j--) {
				System.out.printf("[%d단]\n", j);
				for (int i = 1; i <= 9; i++) {
					System.out.printf("%d X %d = %d\n",j,i,j*i);
				}
				System.out.println("--------------------------");
			}
		}
		else {
			System.out.println("잘못 입력하셧습니다");
		}
	}
	
	
	// 1 2 3
	// 4 5 6
	// 7 8 9
	public void ex12() {
		int count = 0;
		for (int row = 1; row <= 3; row++) {	// 1행,2행,3행
			for (int column = 1; column <= 3; column++) {	// 1열,2열,3열
				count++;
				System.out.printf("%d ", count);
			}
			System.out.println();
		}
	}
	
	// 1 2 3 4
	// 5 6 7 8
	// 9 10 11 12
	public void ex13() {
		int count = 0;
		for (int row = 1; row <= 3; row++) {
			for (int col = 1; col <= 4; col++) {
				count++;
				System.out.printf("%d ", count);
			}
			System.out.println();
		}
		System.out.println("--------------------------------");
		// 단일 for 문 + if
		for ( int i = 1 ; i <= 12 ; i++) {
			System.out.println(i+" ");
			if (i % 4 == 0) {
				System.out.println();
			}
		}
	}
	public void ex14() {
		Scanner sc = new Scanner(System.in);
		System.out.println("행 : ");
		int row = sc.nextInt();
		System.out.println("열 : ");
		int col = sc.nextInt();
		int count = 0;
		
		// 초기식, 조건식 ,증감식은 상황에 따라서
		// 늘어나거나 작성하지 않을수 있다
		// 초기식 작성 X -> 대신 row, col 사용
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				count++;
				System.out.printf("%d ", count);
			}
			System.out.println();
		}
	}
	
	// 1
	// 12
	// 123
	// 1234
	public void ex15() {
		String str = "";
		for (int i = 1; i <= 5; i++) {
			str += i;
			System.out.println(str);
		}
		
		for (int i = 1; i <= 5; i++) {
			
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
	}
	
	// 1 2 3 4
	// 1 2 3 
	// 1 2 
	// 1 
	public void ex16() {
		for (int i = 5; i >= 1; i--) {
			
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
	// 4 3 2 1
	// 3 2 1
	// 2 1
	// 1
	public void ex17() {
		for (int i = 5; i >= 1; i--) {
			
			for (int j = i; j >= 1; j--) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
	// 4
	// 43
	// 432
	// 4321
	public void ex18() {
		for (int i = 5; i >= 1; i--) {
			
			for (int j = 5; j >= i; j--) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
	}
}
