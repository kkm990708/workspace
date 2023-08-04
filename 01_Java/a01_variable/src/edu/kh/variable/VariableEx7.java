package edu.kh.variable;
import java.util.Scanner;

public class VariableEx7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		이름 : 홍길동
//		나이 : 20
//		성별 : 남자
//		키 : 177.4
//		희망재산 : 100,000,000,000,000
//		홍길동 님은 20세 남자이며 키는 177.4 
//		희망재산은 100,000,000,000,000 원 입니다
		System.out.print("이름 : ");
		String name = sc.next();	// 입력받은 문자열 name 에 저장

		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		System.out.print("성별 : ");
		String gender = sc.next();
		
		System.out.print("키 : ");
		double height = sc.nextDouble();
		
		System.out.print("희망재산 : ");
		long property = sc.nextLong();
		System.out.println(name + "님은 " + age +"세 "+ gender + "이며 키는" + height + " 희망재산은" + property + "원 입니다");
		
		String result = name + "님은 ";	
		result = result + age + "세 ";
		result = result + gender + "이며 키는";
		result = result + height ;
		result = result + "희망재산은 " + property + "원 입니다";
		System.out.println(result);
		
	}
}
