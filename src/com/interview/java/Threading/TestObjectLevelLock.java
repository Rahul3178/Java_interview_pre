package com.interview.java.Threading;

class A1 extends Thread{
	Hello1 h;
	String msg;
	
	public A1(Hello1 h, String msg)
	{
		this.h=h;
		this.msg=msg;
	}
	
	public void run() {
		h.display(msg);
	}
}

class Hello1{
	
	// for class level lock (static data) add static synchronize
	public static synchronized void display(String msg)
	{
//		synchronized (this) {
		try {
			System.out.print("[");
			System.out.print(msg);
			System.out.print("]");
			System.out.println("");
			Thread.sleep(10000);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
//		}
	}
}


public class TestObjectLevelLock {
	public static void main(String[] args) {
		Hello1 hello1= new Hello1();
		
		A1 thread1 = new A1(hello1,"message-1");
		A1 thread2 = new A1(hello1,"message-2");
		
		Hello1 hello2= new Hello1();
		
		A1 thread3 = new A1(hello2,"message-3_JAVA");
		A1 thread4 = new A1(hello2,"message-4_CJC");
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
	}
}
