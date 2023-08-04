package edu.kh.control.loop.ex;

import java.util.Scanner;

public class LoopEx3 {
	// while문
	// 반복 조건만을 설정하는 반복문 
	// 조건식이 true인 경우에 계속 반복
	// 조건식이 false 가 되는 상황을 같이 구현해야함
	// [작성법]
	// while (조건식){
	// 조건식이 true 일 때 수행할 구문
	// + 조건식이 특정 상황에 false가 되게하는 구문도 같이 작성
	// }
	
	public void ex1() {
		// 숫자 0이 입력될 때까지 프로그램 종료 X
		Scanner sc = new Scanner(System.in);
		
		int input = -1; // 입력 받을 값을 저장할 변수 + 종료 조건과 관련없는 값으로 초기화
		while(input != 0) { // input이 0이 아닐 때 true
			//true 일 때 반복
			System.out.print("숫자를 입력해주세요 : ");
			input = sc.nextInt();
			
		}
	}
	
	// 0 이 입력되기 전까지 입력된 모든 숫자의 합 출력
	public void ex2() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;	
		int input = -1; 
		while(input != 0) { 
			System.out.print("정수 입력 : ");
			input = sc.nextInt();
			sum += input;
		}
		System.out.println("합계 : "+sum);
	}
	
	// 분식집 주문 프로그램
	public void ex3() {
		Scanner sc = new Scanner(System.in);
		int sum = 0; // 주문한 메뉴의 합
		int input = 0;
		String orderMenu = ""; // 빈 문자열 (빈칸)
		while (input != 9) {	// 9 입력 시 조건식이 false 가 되어 while문 종료
			System.out.println("\n-----메뉴-----");
			System.out.println("1. 김밥(3000원)");
			System.out.println("2. 라면(3500원)");
			System.out.println("3. 떡볶이(4000원)");
			System.out.println("9. 주문완료");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt(); // input에 메뉴 번호 저장
			
			switch (input) {
			case 1: 
				sum += 3000; 
				orderMenu += "김밥 ";
				break;
			case 2: sum += 3500;
				orderMenu += "라면 ";
				break;
			case 3: sum += 4000;
				orderMenu += "떡볶이";
				break;
			case 9: System.out.println("주문 완료!");
				break;		
			default: System.out.println("<<메뉴에 작성된 번호만 입력해주세요>>");
				break;
			}
		}//while 종료
		System.out.println("주문한 메뉴 : " + orderMenu);
		System.out.println("총 가격 : " + sum + "원");
		
	}
	
	
	public void ex4() {
		// 1 2 3 4 5 출력(while문 사용)
		System.out.println("\n-------------------------------");
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + " ");
		}
		int i = 1;
		while (i <= 5) {
			System.out.println(i + " ");
			i++;
		}
	}
	
	// do while
	// while 문의 조건식 확인 위치를 끝으로 보낸 while문
	public void ex5() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int input; // 변수를 선언만
		
		do {
			System.out.print("숫자 입력 : ");
			input = sc.nextInt();
			sum += input;
		} while (input !=0); 
		// do 구문에서 input이 무조건 초기화 되기 때문에
		// input 선언시 초기화를 하지 않아도
		// while 조건식에서 오류가 발생하지 않는다
		System.out.println("합계 : " + sum);
	}
	
	
}
