package edu.kh.operator.ex;
import java.util.Scanner;

public class OperatorEx1 {
public static void main(String[]args) {
	// 두수를 입력받아
	// + - * / % 모두 출력
	// %.1f : 소수점 아래 1자리 까지 출력
	
	
	Scanner scanner = new Scanner(System.in);	//스캐너 생성
	System.out.print("정수 입력 1 : ");
	int input1 = scanner.nextInt();
	System.out.print("정수 입력 2 : ");
	int input2 = scanner.nextInt();
	System.out.println();//줄바꿈
	
	int minus = input1 - input2;
	
	System.out.println(input1 + " + " + input2 + " = " + (input1 + input2));
	
	System.out.println(input1 + " - " + input2 + " = " + minus);
	
	System.out.printf("%d * %d = %d ", input1, input2 , input1 * input2);

	System.out.println();
	
	System.out.printf("%d / %d = %.1f ", input1, input2 , (double)input1 / (double)input2);
	
	System.out.println();
	
	// 5/2 의 결과는 2.5 가 아닌 2인 이유 컴퓨터의 값 처리 원칙에 의해 int / int = int 다
	System.out.printf("%d %% %d = %d ", input1, input2 , input1 % input2);
	
}
}
