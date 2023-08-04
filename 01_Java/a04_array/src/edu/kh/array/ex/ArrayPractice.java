package edu.kh.array.ex;

import java.util.Scanner;

import javax.management.MXBean;

public class ArrayPractice {
	private Scanner sc = new Scanner(System.in);
	public void practice1() {
		int sum = 0;
		int[] arr = new int[9];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if (i % 2 == 0) {
				sum += arr[i];
			}
		}
		System.out.printf("\n짝수 번째 인덱스 합 : %d",sum);
	}
	
	public void practice2() {
		int sum = 0;
		int[] arr = new int[9];
		
		for (int i = arr.length - 1; i >= 0 ; i--) {
			arr[i] = i+1;
		}
		for (int i = arr.length - 1; i >= 0 ; i--) {
			System.out.print(arr[i] + " ");
			if (i % 2 == 1) {
				sum += arr[i];
			}
		}
		System.out.printf("\n홀수 번째 인덱스 합 : %d",sum);
	}
	
	public void practice3() {
		
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		int[] num = new int[input];
		for (int i = 0; i < num.length; i++) {
			num[i] = i + 1;
		}
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}
	
	public void practice4() {
		int[] arr = new int[5];
		int input = 0;
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("입력 %d : ", i);
			arr[i] = sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		input = sc.nextInt();
		boolean check = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == input) {
				System.out.printf("인덱스 : %d", i);
				check = false;
			}
		}
		if (check) {
			System.out.println("일치하는 값이 존재하지 않습니다");
		}
	}
	
	public void practice5() {
		System.out.print("문자열 : ");
		String str = sc.next();
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);
		int count = 0;
		
		char[] chArray = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			chArray[i] = str.charAt(i);
		}
		
		System.out.printf("%s에 %c가 존재하는 위치(인덱스) : ",str,ch);
		for (int i = 0; i < chArray.length; i++) {
			if (chArray[i] == ch) {
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.println("\ni의 개수 : " + count);
	}
	
	public void practice6() {
		
		System.out.print("정수 : ");
		int input = sc.nextInt();
		int sum = 0;
		int[] arr = new int[input];
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			sum += arr[i];
		}
		System.out.println("\n총 합 : " + sum);
	}
	
	public void practice7() {
		System.out.print("주민등록번호(-포함) : ");
		String str = sc.next();
		char[] arr = new char[str.length()];
		for (int i = 0; i < arr.length; i++) {
			if (i >= 8) {
				arr[i] = '*';
				continue;
			}
			arr[i] = str.charAt(i);
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
	
	public void practice8() {

		while (true) {
			System.out.print("정수 : ");
			int input = sc.nextInt();
			if (input % 2 == 0 || input < 3) {
				System.out.println("다시 입력하세요");
			}
			else {
				for (int i = 0; i < input/2 + 1; i++) {
					System.out.print((i + 1) + " ");
				}
				for (int i = input/2 ; i >= 1 ; i--) {
					System.out.print(i + " ");
				}
				break;
			}
		}
	}
	
	public void practice9() {
		int[] arr= new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
		}
		System.out.print("발생한 난수 : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public void practice10() {
		int[] arr= new int[10];
		int max = 0;
		int min = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
		}
		max = arr[0];
		min = arr[0];
		System.out.print("발생한 난수 : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println("\n최대값 : " + max);
		System.out.println("최소값 : " + min);
	}
	
	public void practice11() {
		int[] arr= new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			
			for (int j = 0; j < i; j++) {
				if (arr[j] == arr [i]) {
					i--;
					break;
				}
			}
		}
		System.out.print("발생한 난수 : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	
	public void practice12() {
		int[] arr = new int[6];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 99 + 1);
			for (int j = 0; j < i; j++) {
				if (arr[j] == arr [i]) {
					i--;
					break;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	public void practice13() {
		System.out.print("문자열 : ");
		String str = sc.next();
		int count = 0;
		boolean check = false;
		char[] chArray = new char[str.length()];
		int arrayLength = str.length();
		
		for (int i = 0; i < arrayLength; i++) {
			char temp = str.charAt(i);
			
			for (int j = 0; j < chArray.length; j++) {
				if (temp == chArray[j]) {
					check = true;
				}
			}
			
			if (check) {
				check = false;
				continue;
			}
			chArray[i] = temp;
			count++;
		}
		System.out.print("문자열에 있는 문자 : ");
		for (int i = 0; i < chArray.length; i++) {
			if (chArray[i] == 0) {
				continue;
			}
			System.out.print(chArray[i] + ", ");
		}
		System.out.println("\ni의 개수 : " + count);
	}
	
	
	public void practice14() {
		System.out.print("배열의 크기를 입력하세요 : ");
		String[] arr = new String[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d번째 배열의 값을 입력하세요 : ", i);
			arr[i] = sc.next();
		}
		while (true) {
			System.out.println("배열의 값을 추가로 입력하겠습니까?(1.예/0.아니오)");
			int select = sc.nextInt();
			if (select == 1) {
				System.out.println("추가로 입력할 배열의 길이를 입력하세요 : ");
				int lengthPlus = sc.nextInt();
				arr = new String
				continue;
			}
			if (select == 0) {
				break;
			}
			System.out.println("1 또는 0 을 입력해 주세요");
		}
		
	}
	public void practice15() {
		
	}
	public void practice16() {
		
	}
	public void practice17() {
		
	}
	public void practice18() {
		
	}
	public void practice19() {
		
	}
	public void practice20() {
		
	}
	public void practice21() {
		
	}
	public void practice22() {
		
	}
	public void practice23() {
		
	}
	public void practice24() {
		
	}
}
