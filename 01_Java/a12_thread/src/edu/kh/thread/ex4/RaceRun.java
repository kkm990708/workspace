package edu.kh.thread.ex4;

import java.security.PublicKey;
import java.util.Scanner;

public class RaceRun {
	// 여기에 생성되면 클래스명.필드명으로 어디서든 공유가능
	public static int heartCount = 0;
	public static int startCount = 0;
	
	public static void main(String[] args) {
		Thread th1 = new Thread(new RaceHeart());
		Thread th2 = new Thread(new RaceStar());
		
		// 승패 여부 맞추기
		Scanner sc = new Scanner(System.in);
		System.out.println("<승패 여부를 예상해 보세요>");
		System.out.print("1. ♡ 승  /  2. ★ 승  /  3. 무승부 >> ");
		int input = sc.nextInt();
		
		System.out.print("<배팅할 포인트를 입력해 주세요>");
		int point = sc.nextInt();
		
		// 승패 여부 저장할 변수
		int win = 0;	// 1 . ♡ 승  /  2. ★ 승  /  3. 무승부
		
		try {
			th1.start();
			Thread.sleep(500);
			th2.start();

			th1.join();
			th2.join();
			
			// Thread.join()
			// 지정된 스레드(th1, th2)가 끝날 때까지
			// 현재 스레드(main)를 대기 시킴
			
		} catch (Exception e) {
		}
		
		// 하트, 별 중 누가 더 멀리 이동했는가에 따라
		// 승 패 여부 출력
		System.out.println("\n---------- 결과 ----------\n");
		
		String result = null;
		if (heartCount > startCount) {	// 하트가 더 멀리간 경우
			result = "[♡ 승!]";
			win = 1;
		}else if (heartCount < startCount) {
			result = "[★ 승!]";
			win = 2;
		}else {
			result = "[무승부]";
			win = 3;
		}
		System.out.println(result);
		// 예측 성공 시
		if (input == win) {
			System.out.println("\n[예측 성공!!]");
			if (win == 3) {		// 무승부 예측 성공 시 포인트 3배
				point *= 3;
			}else {	 // 나머지 2배
				point *= 2;
			}
			System.out.println("포인트 " + point + " 를 획득 했습니다.");
		}else {	// 예측 실패시
			System.out.println("\n[예측 실패]");
		}
	}
	
	public static void clear() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 40; i++) {
			// StringBuffer : String 불변성 문제를 해결한 객체
			sb.append("\n");	// sb += "\n"
		}
		System.out.println(sb.toString());
	}
}
