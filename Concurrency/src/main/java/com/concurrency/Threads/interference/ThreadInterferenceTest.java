package com.concurrency.Threads.interference;

public class ThreadInterferenceTest  {

	class Counter implements Runnable{
		private int c = 0;
		
		public void increment() {
			c++;
		}
		
		public void decrement() {
			c--;
		}
		
		public int value() {
			return c;
		}
		
		@Override
		public void run() {
			threadMessage(c);
			increment();
			threadMessage(c);
			decrement();
			threadMessage(c);
		}
		
		private void threadMessage(Object message) {
			String threadName = Thread.currentThread().getName();
			System.out.format("%s: %s%n", threadName, message.toString());
		}
	}
	
	public static void main(String[] args) {
		ThreadInterferenceTest threadTest = new ThreadInterferenceTest();
		Counter counter = threadTest.new Counter();
		Thread thread1 = new Thread(counter);
		Thread thread2 = new Thread(counter);
		
		thread1.start();
		thread2.start();
	}
}
