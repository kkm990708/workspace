package edu.kh.operator.ex;

public class OperatorEx8 {
	public static void main(String[] args) {
		
		// 복합 대입 연산자 : += -= *= /= %=
		// 기존 변수 값에 새로 대입되는 값의 산술 연산결과를 저장한다
		
		int a = 10;
		System.out.println("a : " + a);
		
		a ++;
		a ++;
		System.out.println("a를 1증가 : " + a);
		
		a += 1;	// a = a + 1
		System.out.println("a를 1증가 : " + a);
		
		a += 4;	// a = a + 4
		System.out.println("a를 4증가 : " + a);
		
		a -= 12;//	a = a - 12
		System.out.println("a를 12감소 : " + a);
		
		a *= 3; // a = a * 3
		System.out.println("a를 3배 증가 : " + a);
		
		a /= 6; // a = a / 6
		System.out.println("a를 6으로 나누었을 때 몫 : " + a);
				
		a %= 2; // a = a % 2
		System.out.println("a를 2으로 나누었을 때 나머지 : " + a);
		
		
		
		
		
		
	}
}
