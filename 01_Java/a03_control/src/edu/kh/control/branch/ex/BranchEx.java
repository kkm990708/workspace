package edu.kh.control.branch.ex;

import java.util.Scanner;

public class BranchEx {
	// 분기문
	// break : (가장 가까운)반복문을 멈춤
	// continue : (가장 가까운)반복문의 시작 부분으로 이동(다음 반복 진행)
	
	public void ex1() {
		for (int i = 1; i <= 10000; i++) {
			if (i % 2 == 1) { // 홀수인 경우 다음 반복으로 넘어감
				continue;
			}
			System.out.println(i);
			if (i == 20) { // i가 20인 경우 반복을 멈춤
				break;
			}
		}
	}
	
	// 0 입력시 까지 모든 정수의 합 출력하기
	//
	public void ex2() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int input = -1;
		// 방법 1. while문
		// 방법 2. do-while문
		// 방법 3. while + break
		
//		while(input != 0) {
//			System.out.print("입력 : ");
//			input = sc.nextInt();
//			sum += input;
//		}
		
//		do {
//			System.out.print("입력 : ");
//			input = sc.nextInt();
//			sum += input;
//		} while (input != 0);
		
		while (true) { // 무한 반복
			System.out.print("입력 : ");
			input = sc.nextInt();
			if (input == 0) {// 0 입력시 반복문 종료
				break;
			}
			sum += input;
		}
		
		// 도달할수 없는 코드
		System.out.println("합계 : " + sum);
	}
	
	//충첩 반복문에서 분기문 동작 확인
	public void ex3() {
		for (int row = 1; row <= 5; row++) {
			
			for (int col = 1; col <= 9; col++) {
				if ( col % 3 == 0) {
					continue;	// 다음 반복 수행
				}
				System.out.printf("(%d, %d)", row,col);
			}
			System.out.println();
			// row 가3 일 때 반복 종료
			if (row == 3) {
				break;		// break 를 감싸고 있는 row 제어 for 문이 멈춤
			}
		}
	}
	
	public void upDownGame() {
		// 1 ~ 100 까지 난수를 하나 생성해서
		// 사용자가 이를 맞히는데 걸리는 횟수를 카운트
		// 틀린 경우 입력한 경우 난수보다 큰지, 작은지 출력
		Scanner sc = new Scanner(System.in);
		// Math.random() : 0.0 이상 1.0 미만의 난수를 반환
		int answer = (int)(Math.random() * 100 + 1);
//		System.out.println(answer); // 임시로 답안 확인
		int count = 1; // 입력 횟수 저장용 변수
		while (true) {	// 언제 끝날지 모르니까 일단 무한 반복
			
			
			System.out.print(count + "번째 입력 : ");
			int input = sc.nextInt();
			// 잘못 입력한 경우
			if (input < 1 || input > 100) {
				System.out.println("*** 1 ~ 100 사이 수를 입력해 주세요 *** \n");
				continue;
			}
			if (input < answer) {
				System.out.println("UP");
			}
			else if (input > answer) {
				System.out.println("DOWN");
			}
			else {
				System.out.println("[정답!!]");
				System.out.printf("총 입력 횟수 : %d회", count);
				break;	// while 문 종료
			}
			
			count++;
		}
	}
}
