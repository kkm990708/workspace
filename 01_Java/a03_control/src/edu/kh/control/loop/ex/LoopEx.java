package edu.kh.control.loop.ex;

import java.util.Iterator;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class LoopEx {
	/* for 문
	* 끝이 정해져 있는 경우에 사용하는 반복분
	* (몇 번 반복할지 알고 있을 때 사용)
	*
	* [작성법]
	* for(초기식 ; 조건식 ; 증감식){
	* 조건이 true일 경우 수행할 코드 (+ 반복)
	* }
	* 
	* 
	*/

	// for 예제 1
	public void ex1() {
		// 안녕하세요 10번 출력하기
		
		for(int i = 1; i <= 10 ; i++) {
			System.out.println("안녕하세요");
		}
		// for문 해석 순서
		// 1) 초기식 (반복을 세는 용도의 변수)
		// 2) 조건식 (초기식에 사용된 변수의 값에 따라)
		// 3) for문 내부 코드
		// 4) 증감식(초기식 변수의 값을 변화)`
		
	}
	
	public void ex2() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}
	
	// for 예제 3 - 3 부터 8 까지 출력하기
	public void ex3() {
		for (int i = 3; i <= 8; i++) {
			System.out.println(i);
		}
	}
	
	// for 예제 4 - 2 부터 20 까지 2씩 증가하며 출력
	public void ex4() {
		for( int i = 2 ; i <= 20 ; i+= 2) {
			System.out.println(i);
		}
	}
	
	// for 예제 5 - 1 부터 10까지 정수의 합
	public void ex5() {
		int sum = 0;	// 합계를 저장할 변수
		// 0으로 초기화 하는 이유 : 0은 더해도 영향이 없어서
		// 곱하기 나누기를 누적할때 초기값 1 사용
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println("합계 : " + sum);
	}
	
	// for 예제 6 - 50 부터 100 까지의 모든 정수의 합  
	public void ex6() {
		int sum = 0;	
		for (int i = 50; i <= 100; i++) {
			sum += i;
		}
		System.out.println("합계 : " + sum);
	}	
	
	// for 예제 7 - 3부터 30까지 3씩 증가하면 출력
	// + 출력되는 수의 합을 마지막에 출력
	public void ex7() {
		int sum = 0;	
		for (int i = 3; i <= 30 ; i += 3) {
			System.out.println(i);
			sum += i;
		}
		System.out.println("합계 : " + sum);
	}
	
	// 시작, 끝, 증가할 수를 입력 받아
	// 지정된 범위까지 모두 출력 후
	// 합계도 출력
	// 시작 : 1
	// 끝 : 5
	// 증가할 수 : 2
	// 1 3 5
	// 합계 9
	
	public void ex8() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("시작 : ");
		int start = scanner.nextInt();
		System.out.print("끝 : ");
		int end = scanner.nextInt();
		System.out.print("증가할 수 : ");
		int step = scanner.nextInt();
		int sum = 0;
		
		for (int i = start; i <= end ; i += step) {
			System.out.printf("%d ",i);
			sum += i;
		}
		System.out.println("\n합계 : " + sum);
	}
	
	// 1부터 10까지 모든 정수 출력
	// 단, 짝수는 [] 로 감싸서 출력
	// 1 [2] 3 [4] 5 [6]
	public void ex9() {
		for (int i = 1; i <= 10 ; i ++ ) {
			if (i % 2 == 0) {
			System.out.printf("[%d] ", i);
			}
			
			else {
			System.out.printf("%d ", i);
			}
			
		}
	}
	
	// 1부터 10까지 모든 정수 출력
	// 단 ,홀수는 () 감싸서 출력
	// 1은 "시작" 10은 끝 이라고 출력
	public void ex10() {

		for (int i = 1; i <= 10 ; i ++ ) {
			
			if (i == 1) {
				System.out.printf("시작 ");
				
			}
			else if (i == 10) {
				System.out.printf("끝 ", i);
				
			}
			else if (i % 2 == 0) {
				System.out.printf("%d ", i);
			}
			
			else {
				System.out.printf("(%d) ", i);
			}
			
		}
	}
	
	// 1부터 20까지 1씩 증가하는 반복문을 이용해 
	// 짝수의 합, 홀수의 합을 구해서 출력
	public void ex11() {
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 1; i <= 20; i++) {
			if (i % 2 == 0) {
				sum1 += i;
			}
			else {
				sum2 += i; 
			}
		}
		System.out.println("짝수의 합 : " + sum1);
		System.out.println("홀수의 합 : " + sum2);
	}
	
	// 1부터 100까지 1씩 증가하는 반복문을 이용
	// 1 ~ 100 사이 수 중
	// 입력받은 수의 배수를 뺀 나머지 수의 합을 출력
	public void ex12() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("제외할 배수 입력 : ");
		int input = scanner.nextInt();
		int sum = 0;
		for (int i = 1; i <= 100 ; i++) {
			if(i % input != 0) {
				sum += i;
			}
		}
		System.out.println("합계 : "+sum);
		
		
	}
}
	
	

