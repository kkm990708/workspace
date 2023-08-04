package edu.kh.array.ex;

import java.util.Iterator;
import java.util.Scanner;

public class ArrayEx2 {
	public void ex1() {
		//2차원 배열 선언, 핳당}
		int[][] arr = new int[2][3];
		arr[0][0] = 7;
		arr[0][1] = 14;
		arr[0][2] = 21;
		arr[1][0] = 331;
		arr[1][1] = 15;
		arr[0][2] = 88;
	
		// 배열 참조변수.length
		// -> 참조하고 있는 배열의 길이를 반환
		// arr ==> 1차원배열 참조 변수의 묶음(배열)
		// arr.length = 2
		// arr[0] = 1차원 배열 참조 변수
		// arr.length 
		
		// 2중 for문을 이용해서 배열의 모든 요소에 접근하여 출력하기
		// row < 2 row<arr.length
		// -> 2차원 배열에서 배열명.length
		// 행제어
		for (int row = 0; row < arr.length; row++) {

			for (int col = 0; col < arr[row].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	// 2차원 배열 선언과 동시에 초기화
	public void ex2() {
		char[][] arr ={{'a','s','d'},{'z','x','c'},{'f','g','h'}};
		// 입력받은 알파벳의 위치를 검색하는 프로그램
		// 1. char 입력받기
		// String.charAt(index)를 이용해 0번 인덱스 값을 반환받기
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 알파벳을 입력해줴요 : ");
		char input = sc.next().charAt(0);
		// 입력된 알파벳(char) input에 대입
		// 2차원 배열을 참조하는 arr을 이용해서
		// 2차원 배열의 모든 요소를 접근하는 2중 for문 작성
		boolean flag = true;
		// 신호 용도의 변수
		// true : 검색 결과 없음
		// false : 검색 결과가 존재함
		
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				// 현재 접근한 2차원 배열 요소의 값이 입력받은 input과 같은지 확인
				if (input == arr[row][col]) {
					System.out.printf("%c는 %d행 %d열에 있습니다", arr[row][col],row,col);
					flag = false;
				}
			}
		}
		//2중 for문 코드가 끝난 후 flag의 상태를 검사
		if (flag) {
			System.out.println("검색 결과가 없습니다");
		}
	}
	
	public void ex3() {
		int[][] arr =  {{35,40,50,60},
						{14,33,46,52},
						{17,50,24,73}};
		double count = 0;
		int sum = 0;
		
//		for (int row = 0; row < arr.length; row++) {
//			for (int col = 0; col < arr[row].length; col++) {
//			// 현재 접근한 2차원 배열 요소의 값이 입력받은 input과 같은지 확인
//				sum += arr[row][col];
//				count++;
//			}
//		}
		// 모든 배열 요소를 접근하는 용도의 for 문
		// 장점 : 작성이 간단함
		// 단점 : 시작, 끝, 증감, 인덱스 지정 불가능
		// for (배열요소의 자료형으로 된 변수 : 배열명)
		// -> 오른쪽에 작성한 배열의 요소를
		//	  순서대로 하나씩 꺼나와 대입
		for(int[] row : arr) {
			for(int col : row) {
				sum += col;
				count++;
			}
		}
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + sum/count);
	}
	
	public void ex4() {
		// 4행 4열짜리 정수형 2차원 배열을 생성한 후
		// 각 배열 요소에 1 ~ 100 사이 난수를 대입
		// 2차원 배열에 저장된 값을 모두 출력
		// 모든 요소의 합
		// 최대값 최소값 출력
		int[][] arr = new int[4][4];

		int sum = 0;
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				int ramdom = (int)(Math.random() * 100 + 1);
				arr[row][col] = ramdom;

			}
		}
		int max = arr[0][0];
		int min = arr[0][0];
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				System.out.printf("%4d", arr[row][col]);
				sum += arr[row][col];
				if (arr[row][col] > max) {
					max = arr[row][col];
				}
				if (arr[row][col] < min) {
					min = arr[row][col];
				}
			}
			System.out.println();
		}
		System.out.println(" 합계   : " + sum);
		System.out.println(" 최대값 : " + max);
		System.out.println(" 최소값 : " + min);
		
	}
}

















