package com.interview.java.Threading.crash;

import java.util.concurrent.atomic.AtomicInteger;

class SharedResource_demo{
	private int counter1;
	private AtomicInteger counter2= new AtomicInteger(0);
	
	
	public int getCounter1()
	{
		return this.counter1;
	}
	
	public int getCounter2()
	{
		return this.counter2.get();
	}
	
	
	public void increment1()
	{
		counter1++;
	}
	
	public void increment2()
	{
		counter2.incrementAndGet();
	}
	
//	 we can make method synchronize which do increment
	
	/*
	 * public synchronized void increment3() { counter1++; }
	 */
	
}


public class Atomic_keyword {

	public static void main(String[] args) {
		SharedResource_demo sharedResource = new SharedResource_demo();
		
		Thread t1= new Thread(()->{
			System.out.println("Thread 1 get Executed");
			for (int i = 0; i < 1000; i++) {
				sharedResource.increment1();
				sharedResource.increment2();
			}
			
			
			System.out.println("Thread 1 get Completed");
		});
		
		Thread t2= new Thread(()->{
			System.out.println("Thread 2 get Executed");
			for (int i = 0; i < 1000; i++) {
				sharedResource.increment1();
				sharedResource.increment2();
			}
			
			
			System.out.println("Thread 2 get Completed");
		});

		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("The value of couter without Atomic"+sharedResource.getCounter1());
		System.out.println("The value of couter with Atomic "+sharedResource.getCounter2());
		
		
	}

}
