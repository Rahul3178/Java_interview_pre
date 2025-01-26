package com.interview.java.Threading;

public class ThreadDemo2 {

	public static void main(String[] args) {
		// By implementing runnable interface
		My m= new My();
		Thread t= new Thread(m);
		t.start();
		for(int i=0;i<20;i++)
		{
			System.out.println("Main Thread..."+i);
		}
	}

}

class My implements Runnable
{

	@Override
	public void run() {
		for(int i=0;i<10;i++)
		{
			System.out.println("Thread Running"+i);
		}
		
	}
	
}