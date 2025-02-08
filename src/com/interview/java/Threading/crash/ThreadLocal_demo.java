package com.interview.java.Threading.crash;



public class ThreadLocal_demo {

	public static void main(String[] args) {
		ThreadLocal<Long> threadLocalDemo= new ThreadLocal<Long>();
		
		Long userId1=123456789L;
		Long userId2=123456788L;
		
		Thread localThread1= new Thread(()->{
			System.out.println("Thread 1 get executed");
			threadLocalDemo.set(userId1);
			System.out.println("Thread 1 get completed"+ threadLocalDemo.get());
			threadLocalDemo.remove();
		});
		Thread localThread2= new Thread(()->{
			System.out.println("Thread 2 get executed");
			threadLocalDemo.set(userId2);
			System.out.println("Thread 2 get completed"+ threadLocalDemo.get());
			threadLocalDemo.remove();
			System.out.println("Removed " + threadLocalDemo.get());
			
		});
		
		localThread1.start();
		localThread2.start();
		
		try {
			localThread1.join();
			localThread2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
