package com.interview.java.basics;

public class Neon_number {

	public static void main(String[] args) {
		// 9 => 81 = 8+1=9
		
		int number=9;
		int sq=number*number;
		int sum=0;
		while(sq>0) {
			sum=sum+(sq%10);
			sq=sq/10;
		}
		if(number==sum) {
			System.out.println("Number is neon"+sum);
		}else {
			System.out.println("Number is not neon"+sum);
		}

	}

}
