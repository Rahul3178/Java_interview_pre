package com.interview.java.Threading;

public class ThreadDemo {

	public static void main(String[] args) {
		/*
		 * Implementing multiThreading  Implementing Thread class
		 */
		
		MyThread th= new MyThread();
		th.start();
		for(int i=0;i<20;i++)
		{
			System.out.println("Main Thread"+i);
		}
	}

}

class MyThread extends Thread
{

	@Override
	public void run() {
		
		for(int i=1;i<=10;i++)
		{
			System.out.println("Thread running ...."+i);
			
		}
	}
	
}