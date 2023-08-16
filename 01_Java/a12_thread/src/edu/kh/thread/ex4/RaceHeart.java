package edu.kh.thread.ex4;

import java.util.Random;

public class RaceHeart implements Runnable{
	@Override
	public void run() {
		
		Random random = new Random(); // 난수 생성 객체
		
		try {
			
			for (int i = 0; i < 10; i++) {
				RaceRun.clear();
				
				if (i == 0) {
					System.out.println("준비");
					System.out.println("♡");
					System.out.println("★");
					Thread.sleep(1000);
					continue;
				}
				
				System.out.println( i + " 회차");
				int temp = random.nextInt(5)+1;// 난수발생
				// 생성된 난수를 heartCount 누적
				RaceRun.heartCount += temp;
				
				System.out.println("♡ " + temp + "칸 이동");
				// 하트카운트 누적된 숫자만큼 띄어쓰기
				// ♡ 난수 칸 이동
				for (int j = 0; j < RaceRun.heartCount; j++) {
					System.out.print("-");
				}
				System.out.println("♡");
				
				for (int s = 0; s < RaceRun.startCount; s++) {
					System.out.print("-");
				}
				System.out.print("★");
				
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
