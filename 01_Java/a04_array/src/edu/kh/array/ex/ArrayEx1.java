package edu.kh.array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx1 {
	// 배열
	// 같은 자료형의 변수를 하나의 묶음으로 다루는 것
	// 묶여진 변수들은 하나의 이름(배열명) 으로 불려지고
	// 각 변수들은 index를 이용해서 구분하게 된다
	// index : 색인, 자료의 위치
	// index 번호는 0번 부터 시작
	
	public void ex1() {
		// 배열 선언
		int a;	// int 자료형을 저장할 변수 a 선언(메모리 공간 할당)
		int[] arr; // int 자료형 변수를 묶어서 다루는 배열 arr을 선언
		//int[]은 참조형
		// 변수 대입 == 값 자체를 대입
		a = 10;
		// 배열 대입 == 할당
		arr = new int[3];	//int 변수 3칸짜리 배열
		// new 연산자 : heap 영역에 새로운 메모리를 할당
		// 메모리 할당 = 메모리 공간을 차지한다
		// new int[3]
		// heap 영역에 int 변수 3칸짜리 배열을 새롭게 할당
		// -> 할당된 배열에 시작 주소가 생김
		// arr = new int[3]
		// new int[3]으로 생성된 배열의 시작 주소를 arr에 대입
		// arr 호출시 arr에 저장된 주소를 참조해
		// Heap 영역에 할당된 배열을 찾아감 -> 이래서 int[]을 참조형 이라고 한다
		
		
		// 배열 다루기
		System.out.println("arr : " + arr);	// 주소값 출력
		System.out.println("arr[0] : " + arr[0]);	// 기본값 출력
		System.out.println("arr[1] : " + arr[1]);	// 기본값 출력
		System.out.println("arr[2] : " + arr[2]);	// 기본값 출력
	}
	
	// 배열 선언 및 할당 + 직접 초기화
	 public void ex2() {
		// int 자료형 4개를 묶음으로 다루는 배열 numbers를 선언 및 할당해라
		 int[] numbers = new int[4];
		 numbers[0] = 10;
		 numbers[1] = 100;
		 numbers[2] = 1000;
		 numbers[3] = 10000;
		 // 인덱스는 0부터 시작해서 배열의 크기(길이) - 1 까지 이다.
		 System.out.println(numbers[0]);
		 System.out.println(numbers[1]);
		 System.out.println(numbers[2]);
		 System.out.println(numbers[3]);
		 
		 // 배열 + 반복문(for)
		 for (int i = 0; i <= 3; i++) {
			 System.out.printf("numbers[%d] = %d \n", i,numbers[i]);
		}
		 System.out.printf("--------------------------------\n");
		 for (int i = 3; i >= 0; i--) {
			 System.out.printf("numbers[%d] = %d \n", i,numbers[i]);
		 }
	}
	
	 // 3명의 키를 입력 받아
	 // 입력받은 키 + 평균 키 출력 (배열 이용)
	public void ex3() {
		Scanner sc = new Scanner(System.in);
		double[] heightArray = new double[3];	
		// double 형 배열을 참조한 변수 선언 후
		// Heap 영역에 double 3칸짜리 배열을 할당하여
		// 그 주소에 heightArray 저장
		for (int i = 0; i < heightArray.length; i++) {
			System.out.printf("%d번 키 입력 : ",i);
			heightArray[i] = sc.nextInt();
		}
		double sum = 0.0;
		for (int i = 0; i < heightArray.length; i++) {
			System.out.printf("[%d번째의 키] : %d \n",i,heightArray[i]);
		}
		System.out.println("평균 : " + sum/3.0);
	}
	
	// 점심메뉴 뽑기 프로그램
	public void ex4() {
//		String[] menuArray = new String[5];
//		menuArray[0] = "햄버거";
//		menuArray[1] = "돈까스";
//		menuArray[2] = "제육볶음";
//		menuArray[3] = "샐러드";
//		menuArray[4] = "닭갈비";
		String[] menuArray = {"햄버거","돈까스","제육볶음","샐러드","닭갈비","순대국밥",
							  "평양냉면","삼각김밥+컵라면","도시락","육회비빔밥"};
		
		// index 범위 내 난수를 발생
		int index = (int)(Math.random() * menuArray.length);
		System.out.println("오늘의 메뉴 : " + menuArray[index]);
	}	
	
	// 분식집 주문 프로그램
	public void ex5() {
		// 배열 2개를 생성후
		// 같은 인덱스 번호에 메뉴명, 가격을 작성
		String[] menus = {"원조김밥","참치김밥","치즈김밥","라면","떡볶이"};
		int[] prices = {3000,4000,4000,3500,5000};
		Scanner sc = new Scanner(System.in);
		String orderMenu = ""; // 주문할 메뉴를 저장할 변수
		int sum = 0;	// 주문한 메뉴의 가격을 저장할 변수
		
		while (true) {
			System.out.println("----------메뉴----------");
			for (int i = 0; i < menus.length; i++) {
				System.out.printf("%d) %s (%d)\n", i, menus[i], prices[i]);
			}
			System.out.println("9) 주문완료\n");
			System.out.print("메뉴 선택 >> ");
			int input = sc.nextInt();
			if (input == 9) {
				break;
			}
			// 메뉴 인덱스 범위를 초과할때
			else if (input < 0 || input >= menus.length) {
				System.out.println("잘못 입력");
			}
			else {	// 정상입력
				orderMenu += menus[input] + " ";
				sum += prices[input];
			}
			
		}	// while 종료
		System.out.println("주문  한 메뉴 : " + orderMenu);
		System.out.println("합계 : " + sum + "원");
	}
	
	// 입력받은 정수 만큼의 크기를 가지는 배열만들기
	public void ex6() {
		
		// [평균 점수 구하기]
		// 입력 받을 인원 수 : 4
		// 1번 점수 입력
		// 2번 점수 입력
		// 3번 점수 입력
		// 4번 점수 입력
		// 합계 :
		// 평균 : 
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 받을 인원 수 : ");
		int num = sc.nextInt();
		int sum = 0;
		int[] scores = new int[num]; 
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("%d번 점수 입력 : ", i+1);
			scores[i] = sc.nextInt();
			sum += scores[i];
		}
		System.out.println("합계 : " + sum + "점");
		System.out.println("평균 : " + sum/scores.length + "점");
	}
	
	
	// 생성할 배열의 길이 : 3
	// 0번 인덱스 요소 : 40
	// 1번 인덱스 요소 : 60
	// 2번 인덱스 요소 : 80
	// 저장된 값을 확인하려는 인덱스(-1 종료) : 0
	// 0번 인덱스 : 40
	// 저장된 값을 확인하려는 인덱스(-1 종료) : 99
	// 존재하지 않는 인덱스 번호 입니다
	// 저장된 값을 확인하려는 인덱스(-1 종료) : -1
	// 프로그램 종료
	public void ex7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("생성할 배열의 길이 : ");
		int num = sc.nextInt();
		int[] index = new int[num]; 
		for (int i = 0; i < index.length; i++) {
			System.out.printf("%d번 인덱스 요소 : ", i);
			index[i] = sc.nextInt();
		}
		while (true) {
			System.out.print("저장된 값을 확인하려는 인덱스(-1 종료) : ");
			int input = sc.nextInt();
			if (input == -1) {
				System.out.println("프로그램 종료");
				break;
			}
			if (input >= index.length || input < 0) {
				System.out.println("존재하지 않는 인덱스 번호 입니다");
				continue;
			}
			
			System.out.printf("%d번 인덱스 : %d\n", input,index[input]);
			
		}
	}
	
	public void ex8() {
		// 얕은 복사
		// 참조하는 주소만을 복사하여
		// 서로 다른 참조 변수가 하나의 배열을 참조하게 만드는 것
		// 특징 : 하나의 배열을 참조하기 때문에 값을 공유함
		int[] arr = {10,20,30,40,50};
		int[] copyArr = arr;	// arr 에 저장된 주소를 copyArr에 저장함
		System.out.println(arr);
		System.out.println(copyArr);
		System.out.println(arr == copyArr);
		
		// Arrays 클래스 : 배열 관련 기능을 모아둔 클래스(자바에서 제공)
		// Arrays.toString(배열명) : 배열에 저장된 값을 하나의 문자열로 반환
		System.out.println(Arrays.toString(arr));
	}
	
	public void ex9() {
		// 깊은 복사
		// 원본과 같은 참조형 변수와
		// 원본과 같거나 더 큰 배열을 만들어
		// 원본의 데이터를 모두 복사하여 참조하는 방법
		int[] arr = {10,20,30,40,50};
		//1. for문을 이용한 깊은 복사
		int[] copyArr1 = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			copyArr1[i] = arr[i];
		}
		//2. System.arraycopy(원본배열명, 원본 복사 시작 인덱스, 복사 배열명, 복사 배열의 삽입 시작 인덱스, 복사 길이)
		int[] copyArr2 = new int[arr.length];
		System.arraycopy(arr, 0, copyArr2, 0, arr.length);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(copyArr1));
		System.out.println(Arrays.toString(copyArr2));
		
		arr[0] = 1;
		copyArr1[0] = 999;
		copyArr2[0] = 6789;
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(copyArr1));
		System.out.println(Arrays.toString(copyArr2));
	}
}












