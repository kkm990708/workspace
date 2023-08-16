package edu.kh.thread.ex1;

public class TestRun {
	public static void main(String[] args) {
		// main 메서드 실행 시
		// stack 영역에 main thread가 생성되며 해당 스레드에 main() 메서드가 올라가게 된다
		
		System.out.println(Thread.currentThread().getName() + "생성");
		// 방법1. Thread 클래스 상속
		TestThread1 test1 = new TestThread1(); // 객체 생성
		test1.start();
		
		// 방법2. Runnable 인터페이스 상속
		// new Thread(Runnable targer) :
		// Runnable 인터페이스를 상속 받은 객체를 인터페이스에 추가
		Thread test2 = new Thread(new TestThread2());
		test2.start();
		for(int i = 0; i<10 ; i++) {
			System.out.println("main 스레드 " + i);
		}
	}
}
