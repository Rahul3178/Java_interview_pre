package com.interview.java.basics;

public class palindrom_number {

	public static void main(String[] args) {
		
		// reverse of a number = original number
		
		int number=121;
		
		int originalNumber=number;
		int result=0;
		
		while (number>0) {
			
			result=result*10+(number%10);
			number=number/10;
			
		}
		
		if(originalNumber==result)
		{
			System.out.println("number is palindrom"+result);
		}else {
			System.out.println("Number is not palindrom"+result);
	
		}
		
		
//		 using stream api
		
		
		
		
		
		
		
	}

}
