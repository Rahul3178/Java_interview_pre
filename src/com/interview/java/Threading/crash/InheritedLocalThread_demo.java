package com.interview.java.Threading.crash;

public class InheritedLocalThread_demo {
	
	public static void main(String[] args) {
		InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
		ThreadLocal<String> localThread = new ThreadLocal<>();
		String name="Rahul";
		
		Thread t1= new Thread(()->{
			System.out.println("Thread 1 get Executed");
			inheritableThreadLocal.set(name);
			localThread.set("Nothing");
			Thread t2 = new Thread(()->{
				System.out.println("inner thread get executed");
				System.out.println("inner Value "+inheritableThreadLocal.get());
//				System.out.println("local Value "+localThread.get()));
				System.out.println("inner thread get completed");
			});
			
			t2.start();
			System.out.println("Thread 1 get Completed");
		});
		t1.start();
		
		System.out.println("End of main thread : "+inheritableThreadLocal.get());
		inheritableThreadLocal.remove();
		localThread.remove();
		
		System.out.println("removed "+inheritableThreadLocal.get());
		System.out.println("removed "+localThread.get());
		
	}
}
