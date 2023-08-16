package edu.kh.thread.ex2;

public class SleepThread2 implements Runnable {
	@Override
	public void run() {
		
		int count = 0;
		
		// Thread.currentThread().isInterrupted()
		// 현재 스레드의 interrupted 필드 값 반환
		// -> 수행 중이면 false, 멈춰야되면 true
		
		// interrupted 필드 값이 false 이면 반복 true 이면 멈춰라
		while (!Thread.currentThread().isInterrupted()) {
			
			try {
				Thread.sleep(500);
				
				System.out.println( ++count);
			} catch (InterruptedException e) {
				System.out.println("=== 인터럽트에 의해서 종료 ===");
				// sleep() 중 interrupt() 메서드가 호출되면
				// InterruptedException 이 발생하고
				// interrupted 필드 값이 true로 변하지 못하게 된다
				// -> catch문에서 interreupted 필드 값을 true 로 변경
				Thread.currentThread().interrupt();// false -> true 변경
			}
			
		}
		
	}
}
