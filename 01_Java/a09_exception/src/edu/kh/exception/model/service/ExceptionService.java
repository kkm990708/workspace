package edu.kh.exception.model.service;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.security.PublicKey;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

import edu.kh.exception.model.dto.UserException;

public class ExceptionService {
	public void ex1() {
		// Checked Exception 확인
		// 예외처리 구문(try-catch)
		
		// BufferdReader : 빨리 읽어오는 객체
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 키보드 입력을 효율적으로 읽어오는 객체
		// Scanner 보다 기능은 부족하지만 속도가 매우 빠름
		System.out.print("문자열 입력 : ");
		try {
		String input = br.readLine(); // 한줄 읽어오기
		System.out.println("입력 받은 문자열 : " + input);
		// Unhandled exception type IOException -> IOException에 대한 처리가 강제되고 있음
		// -> 이렇게 꼭 예외처리 하라는 예외를 묵어 Checked Exception 이라고 한다
		
		}catch (IOException e) {
			// catch : try 구문에서 던져진 예외 객체를 잡는 구문
			System.out.println("예외 처리함");
		}
	}
	
	
	public void ex2() {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("숫자 1 : ");	// InputMismatchException 발생 가능성 있음
			int input1 =sc.nextInt();
			System.out.print("숫자 2 : ");
			int input2 =sc.nextInt();
			System.out.print("숫자 : " + input1/input2);
		} catch (ArithmeticException e) {	// ArithmeticException 산술적 예외
			System.out.println("0으로 나눌 수 없습니다");
		} catch (InputMismatchException e) { 
			// catch 연달아서 작성 가능
			System.out.println("잘못 입력");
		}
		// Unchecked Exception
		// -> 예외 처리가 강제되지 않는 예외(개발자, 사용자의 단순 실수)

	}
	
	
	public void ex3() {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("숫자 1 : ");
			int input1 =sc.nextInt();
			
			System.out.print("숫자 2 : ");
			int input2 =sc.nextInt();
			
			System.out.print("숫자 : " + input1/input2);
		} catch (RuntimeException e) {
			// RuntimeException은 ArithmeticException, InputMismatchException 의 부모
			// 부모 타입예외 참조변수로 자식 타입예외 객체를 참조한다 = 다형성 업캐스팅
			// -> 부모 타입으로 모든 자식 예외를 잡아서 처리 가능
			System.out.println("예외 발생");
		} 
	}

public void ex4() {
	Scanner sc = new Scanner(System.in);

	try {
		System.out.print("숫자 1 : ");
		int input1 =sc.nextInt();
		
		System.out.print("숫자 2 : ");
		int input2 =sc.nextInt();
		
		System.out.print("숫자 : " + input1/input2);
	}catch (InputMismatchException e) {
		// catch문 여러 개 작성 시 자식 타입처리 코드가 부모 타입 처리 코드보다 먼저 작성 되어야 한다
		System.out.println("잘못 입력");
	}catch (RuntimeException e) {	// 부모 타입
		System.out.println("예외 발생");
	}//catch(InputMismatchException) {
		// InputMismatchException 도달할 수 업는
		// 부모타입이 InputMismatchException 되도 잡아서 처서
		// 현재 catch문 실행될
	
	}

	public void ex5() {
		try {
			
		} catch (Exception e) {
 		}finally {
//			try : 예외가 발생할 것 같은 구문을 실행
			// catch : try에서 발생한 예외를 잡아서 처리
// 			finall : 예외처리가 되든말든 무조건 실행
 			// 강제 예외 발생 throw new 예외클래스명();
 			
		}
		System.out.println("1. 정상동작 / 2. 예외강제 발생");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		try {
			switch (input) {
			case 1 : System.out.println(" 정상 동작 ");
			break;
			//			ExceptionService 클래스 : 최상위 예외(모든 예외의 부모)
			case 2 : throw new Exception(" 강제 발생 ");
			default : System.out.println("잘못 입력");break;
			}
			
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage()); // 강제발생
		}
		finally {
			System.out.println(" 무조건 실행");
		}
	}
	
	public void ex6() {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("입력 1 : ");
			int num1 = scanner.nextInt();
			System.out.print("입력 2 : ");
			int num2 = scanner.nextInt();
			System.out.printf("%d + %d = %d", num1, num2, num1+num2);
		} catch (InputMismatchException e) {
		
		
		} finally {
			// 예외가 발생되던발던
			// 메모리 누수를 막기위해 스캐너(또는 IO)를 닫아줌
			scanner.close();
		}
	}
	
	public void ex7() {
		// throws : 메서드에서 발생한 예외를 호출한 상위 메서드로 던지는것(책임 전가)
		// 장점 : 한곳에 예외를 몰아서 처리 가능
		try {
			mathodA();
		} catch (IOException e) { // 던져진 예외를 잡아서 처리
			System.out.println("IOException 예외처리 완료");
			e.printStackTrace();
			// 예외 발성 메서드까지의 모든 스택 메서드를 출력
			
		} catch (DataFormatException e) {
			e.printStackTrace();
		}
		// e : 예외 객체를 참조하는 참조 변수
		
		
		System.out.println("프로그램 정상 종료");
	}
	private void mathodA() throws IOException, DataFormatException{
		mathodB();
	}
	private void mathodB() throws IOException, DataFormatException{
		mathodC();
	}
	private void mathodC() throws IOException, DataFormatException{
//		throw new IOException();	// 부모 타입 예외 처리
									// IOException 또는 IOException 자식 예외를 모두 던짐 (다형성)
//		throw new EOFException();	// 자식 타입 예외
		// EOFException : IOException 의 자식

		throw new DataFormatException();
		//IOException 와 관련 없는 예외 -> 별도 처리 필요 -> throws가 여러 예외를 던지게 함
		
	}
	
	public void ex8() {
		try {
			ex9();
		} catch (UserException e) {
			e.printStackTrace();
		}
	}
	// 숫자를 입력받아 출력하는 메서드 단, 100초과시 예외발생
	public void ex9() throws UserException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		
		int input = sc.nextInt();
		
		if (input > 100) {	// 입력한 숫자가 100 초과일 때 예외 발생
//			throw new UserException();
			throw new UserException("100을 초과하는 " + input + "이 입력됨");
			
		}
		System.out.println("입력한 숫자 : " + input);
	}
}



