package com.interview.java.patterns;

public class Singleton {
	
	// private static  instance 
	private static Singleton instance;
	
  // Constructor
	
	private Singleton() {}
	
	public static Singleton getInstance()
	{
		if(instance==null)
		{
			return new Singleton();
		}
		return instance;
	}
	
}


class Test {
	
	
	public static void main(String[] args) {
		Singleton in = Singleton.getInstance();
		
		System.out.println("print the singleton instance"+in);
//		System.out.println("2nd "+Singleton.getInstance());
		System.out.println(Singleton.getInstance()==Singleton.getInstance());
		;
	}
}