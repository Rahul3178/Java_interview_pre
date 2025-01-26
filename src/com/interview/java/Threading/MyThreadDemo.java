package com.interview.java.Threading;

public class MyThreadDemo extends Thread{
	
	public void run() {
		Thread.currentThread().setPriority(5);
		for (int i = 0; i < 10; i++) {
			System.out.println("Run "+ i+Thread.currentThread().getName());
			
		}
	}
	
	
	
	public static void main(String[] args) {
		MyThreadDemo m= new MyThreadDemo();
		m.start();
		Thread.currentThread().setPriority(10);
		for (int i = 0; i < 3; i++) {
			System.out.println("Main"+i+Thread.currentThread().getName());
		}
		
		Thread th= new Thread(new ThreadInterfaceDemo());
		th.start();
	}
	
	
}


class ThreadInterfaceDemo implements Runnable {

	@Override
	public void run() {
		Thread.currentThread().setPriority(8);
		for (int i = 0; i < 10; i++) {
			System.out.println("Interface"+i+Thread.currentThread().getName());
		}
	}
	
}