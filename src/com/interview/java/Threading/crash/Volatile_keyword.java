package com.interview.java.Threading.crash;

class SharedResource{
	private volatile boolean flag =false;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
}



public class Volatile_keyword{

	public static void main(String[] args) throws Exception {
		
		SharedResource sharedResouce = new SharedResource();
		
		new Thread(()->{
			System.out.println("Thread 1 execution started");
			try {
				
				System.out.println("Thread 1 logic Start");
				Thread.sleep(2000);
				System.out.println("Thread 1 logic Completed");
				sharedResouce.setFlag(true);
				System.out.println("Flag value changed by Thread 1");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		
		
		// Thread2
		
		new Thread(()->{
			System.out.println("Thread 2 started");
			while(!sharedResouce.isFlag())
			{
				// it will run until flag value true;				
			}
			System.out.println("Thread 2 Ended");
		}).start();
		
		
		
	}

}
