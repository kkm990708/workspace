package edu.kh.thread.ex2;

public class ThreadControlRun {
	public static void main(String[] args) {
		Thread sleepTest = new Thread(new SleepThread1());
		
		Thread clockThread = new Thread(new MyClock());

		Thread thread = new Thread(new SleepThread2());
		
		InterruptTest it = new InterruptTest();
		
		StopWatchController watch = new StopWatchController();
		watch.watchStart();
	}
}


