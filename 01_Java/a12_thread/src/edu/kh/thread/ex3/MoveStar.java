package edu.kh.thread.ex3;

public class MoveStar implements Runnable{
	@Override
	public void run() {
		
		try {
			
			for (int i = 0; i < 9; i++) {	// 9번 움직임
				for (int j = 0; j < 40; j++) System.out.println();
				
				// i 이하 만큼 반복하며 한칸 띄어쓰기
				for (int h = 0; h <= i; h++) System.out.print(" ");
				System.out.print("♡");
				System.out.println();
				for (int s = 0; s < i ; s++) System.out.print(" ");
				System.out.print("★");
				
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			
		}
		
	}
}
