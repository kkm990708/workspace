package edu.kh.operator.ex;

public class OperatorEx2 {
	
	
	public static void main(String[] args) {
		
		//증감 연산사  ++ --
		// - 피연산자를 1씩 증가 또는 1씩 감소 시키는 연산자
		
		System.out.println("[전위연산]");
		
		System.out.println("증가 연산 테스트");
		int num1 = 0;
		
		System.out.println(num1);
		System.out.println(++num1);
		System.out.println(++num1);
		System.out.println(++num1);
		System.out.println(++num1);
		System.out.println(++num1);
		System.out.println(++num1);
		System.out.println(++num1);
		System.out.println(++num1);

		System.out.println("감소 연산 테스트");
		int num2 = 10;
		System.out.println(num2);
		System.out.println(--num2);
		System.out.println(--num2);
		System.out.println(--num2);
		System.out.println(--num2);
		System.out.println(--num2);
		System.out.println(--num2);
		System.out.println(--num2);
		
		System.out.println("-----------------------------");
		System.out.println("[후위연산]");
		System.out.println("증가 연산 테스트");
		int num3 = 20;
		System.out.println(num3);
		System.out.println(num3++);
		System.out.println(num3);
		System.out.println(num3++);
		
		System.out.println("감소 연산 테스트");
		int num4 = 99;
		System.out.println(num4--);
		System.out.println(num4--);
		System.out.println(num4--);
		System.out.println(num4--);
		System.out.println(num4--);
		System.out.println(num4--);
		System.out.println(num4);
		
		int a = 3;
		int b = 5;
		int c = a++ + --b;
		
		System.out.printf("a = %d, b = %d, c = %d",a,b,c);
		
	}
}
