package edu.kh.control.condition.ex;

import java.awt.Menu;
import java.util.Scanner;

public class SwitchEx {
	
	// switch문
	// 식 하나의 결과로 많은 경우의 수를 처리할 때 사용하는 조건문
	// 식의 결과에 맞는 case 구문이 수행됨;
	
	//switch 예제 1
	public void ex1() {
		Scanner scanner = new Scanner(System.in);
		// 키보드로 정수를 입력받아
		// 1 : RED
		// 2 : ORANGE
		// 3 : YELLOW
		// 4 : GREEN
		// 5 : BLUE
		// 1 ~ 5 가 아니면 : BLACK
		System.out.print("정수 입력 : ");
		int sellect = scanner.nextInt();
		String collor;
//		if (sellect == 1) {
//			collor = "RED";
//		}
//		else if (sellect == 2) {
//			collor = "ORANGE";
//		}
//		else if (sellect == 3) {
//			collor = "YELLOW";
//		}
//		else if (sellect == 4) {
//			collor = "GREEN";
//		}
//		else if (sellect == 5) {
//			collor = "BLUE";
//		}
//		else{
//			collor = "BLACK";
//		}
		
		switch (sellect) {
		case 1 : collor = "RED";
		break;
		case 2 : collor = "ORANGE";
		break;
		case 3 : collor = "YELLOW";
		break;
		case 4 : collor = "GREEN";
		break;
		case 5 : collor = "BLUE";
		break;
		default : collor = "BLACK";
			break;
		}
		System.out.println(collor);
	}
	
	// switch 예제 2
	public void ex2() {
		// 점심 결정 프로그램
		// 난수( Math.random(), switch문 )
		// 1부터 5 사이의 난수를 발생시켜
		// 일치하는 수의 메뉴를 출력
		
		// Math.random() : 0.0 <= x < 1.0
		// Math.random() * 5 : 0.0 <= x < 5.0
		// Math.random() * 5 + 1 : 1.0 <= x < 6.0
		
		int ramdomNumber = (int)(Math.random() * 5 + 1);
		
		String menu = null;	// null 참조하는 것이 없다
		
		switch (ramdomNumber) {
		case 1 : menu = "제육볶음";
		break;
		case 2 : menu = "서브웨이";
		break;
		case 3 : menu = "국밥";
		break;
		case 4 : menu = "파스타";
		break;
		case 5 : menu = "초밥";
		break;
		}
		System.out.printf("오늘의 점심 메뉴는 %s", menu);
	}
	
	// switch 예제 3
	public void ex3() {
		// 문자열로 메뉴를 입력 받아서
		// 해당 메뉴의 가격을 출력
		// [실행화면]
		// 메뉴를 선택해주세요 (김밥,라면,떡볶이) : 김밥
		// 김밥의 가격은 3000원 입니다
		// 메뉴를 선택해주세요 (김밥,라면,떡볶이) : 샌드위치
		// 존재하지 않는 메뉴입니다
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("메뉴를 선택해 주세요 (김밥, 라면, 떡볶이) : ");
		String menu = scanner.next(); // 단어(음절) 입력
		int price = 0;
		
		switch (menu) {
		case "김밥": price = 3000;
			break;
		case "라면": price = 2500;
		break;
		case "떡볶이": price = 4000;
		break; 
		default: price = -1; //잘못 입력되었다는 신호
			break;
		}
		
		// 값에 의미를 부여해서 조건식에 사용하는 방법을 이해해야한다
		
		if(price != -1) { // 정상 입력한 경우
			System.out.printf("%s의 가격은 %d원 입니다",menu, price);
			
		}
		else {	// 잘못 입력한 경우
			System.out.println("존재하지 않는 메뉴입니다");
		}
		}
	
		// switch 예제 4
	public void ex4() {
		// 산술 연산 계산기
		// 두 정수와 1개의 연산자(+ - * / %)를 입력 받아 연산 결과를 출력
		
		// [실행화면]
		// 정수1 입력 : 5
		// 연산자 입력 : +
		// 정수2 입력 : 4
		// 5 + 4 = 9
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수 1 입력 : ");
		int num1 = scanner.nextInt();
		
		System.out.print("연산자 입력 : ");
		String op = scanner.next(); // 한글자만 입력해도 String
		
		System.out.print("정수 2 입력 : ");
		int num2 = scanner.nextInt();
	
		boolean check = false;	// 상태를 기록하고 조건문에 사용할 변수
		int result = 0;	// 계산 결과 저장용 변수 선언 및 초기화
	switch (op) {
	case "+": result = num1 + num2;
	break;
	case "-": result = num1 - num2;
	break;
	case "*": result = num1 * num2;
	break;
	case "/": result = num1 / num2;
	break;
	case "%": result = num1 % num2;
	break;

	default: check = true;	// 연산자를 잘못임력 -> true 로 변경
		break;
	}
	
	if (check) {
		System.out.println("잘못 입력하였습니다");
	}
	else {
		System.out.printf("%d %s %d = %d", num1, op, num2, result);
	}
	}
	
	// switch 예제 5 - break 의 역할
	public void ex5() {
		// switch 문을 이용한 계절 판별기
		Scanner scanner = new Scanner(System.in);
		System.out.print("달(월) 입력 : ");
		int month = scanner.nextInt();
		
		String season = null;
		
		// break : 멈추다
		// 해당 case 를 멈추고 case 를 빠져나가다
		
		// break 가 없는 경우
		// break 를 만나거나 switch 가 끝날 때 까지
		// 다음 case 를 연달아 실행
		switch (month) {
		case 12: case 1: case 2: season = "겨울";
		break;
		case 3: case 4: case 5: season = "봄";
		break;
		case 6: case 7: case 8: season = "여름";
		break;
		case 9: case 10: case 11: season = "가을";
		break;
		default:season = "잘못 입력";
		break;
		}
		System.out.println(season);
		
	}
}
