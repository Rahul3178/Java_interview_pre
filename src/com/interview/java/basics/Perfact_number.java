package com.interview.java.basics;

public class Perfact_number {

	public static void main(String[] args) {
		// 6 = 3+2+1 = 6
		
		int number=9;
		int result=0;
		
		for (int i = 1; i <number; i++) {
			
			if(number%i==0)
			{
				result=result+i;
			}
		}
		if(result==number)
		{
			System.out.println("Perfect number "+number);
		}else {
			System.out.println("Not perfact"+ number);
		}

	}

}
