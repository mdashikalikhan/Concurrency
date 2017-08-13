package com.concurrency.Threads.Synchronization;



public class TreadSynchronization {
	class SynchronizedCounter implements Runnable {
		private int c = 0;
		
		public synchronized void increment() {
			c++;
		}
		
		public synchronized void decrement() {
			c--;
		}
		
		public synchronized int value() {
			return c;
		}
		
		@Override
		public void run() {
			threadMessage(value());
			increment();
			threadMessage(value());
			decrement();
			threadMessage(value());
		}
		private void threadMessage(Object message) {
			String threadName = Thread.currentThread().getName();
			System.out.format("%s: %s%n", threadName, message.toString());
		}
	}
	
	public static void main(String[] args) {
		TreadSynchronization treadSynchronization = new TreadSynchronization();
		
		
		SynchronizedCounter synchronizedCounter = treadSynchronization.new SynchronizedCounter();
		Thread thread3 = new Thread(synchronizedCounter);
		Thread thread4 = new Thread(synchronizedCounter);
		
		thread3.start();
		thread4.start();
	}

}
