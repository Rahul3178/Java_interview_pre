package com.interview.java.Threading;

public final class classloaderdemo {

	public static void main(String[] args) {
		
		ClassLoader details1 = args.getClass().getClassLoader();
		
		printDetails(details1);
		

	}
	
	public static void printDetails(ClassLoader details) {
		if(details==null)
		{
			System.out.println("Bootstrap ClassLoader");
		}
//		}else {
//			System.out.println("ClassLoader name : "+details.getName()+" | "+details.getClass().getName());
//		}
	}

}
