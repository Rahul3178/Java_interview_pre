package com.interview.java.Threading.crash;

public class CrashCourse {

	public static Object sharedObject = new Object();
	public static void main(String[] args) {
		
		System.out.println("Main thread running");
		/*
		 * Thread objectThread = new Thread(()-> {
		 * 
		 * System.out.println("Thread 1 executed"); try { Thread.sleep(3000); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } System.out.println("Thread 1 ended"); });
		 * 
		 * objectThread.start();
		 */
		
		
		
		
		
		
		Runnable rcobject1= ()->{
			System.out.println("Thread 2 Executed");
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getState());
			System.out.println(sharedObject.hashCode());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread 2 ended");
			
		};
		
		Thread objThread1= new Thread(rcobject1,"Runnable Thread 2");
		objThread1.setDaemon(true);
		objThread1.start();
		
		
		Runnable rcobject2= ()->{
			System.out.println("Thread 3 Executed");
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getState());
			System.out.println(sharedObject.hashCode());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread 3 ended");
			
		};
		
		Thread objThread2= new Thread(rcobject2,"Runnable Thread 3");
		objThread2.setDaemon(true);
		objThread2.start();
		
		
		System.out.println("Main thread Ended");
	}

}
