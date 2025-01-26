package com.interview.java.randoms;

import java.util.HashSet;

public class FirstName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			int [] arr= {2,4,6,7,8,10};
			int temp=18;
			
//			new FirstName();
			FirstName.findNumbers(arr, temp);
			
			for(int i=1;i<arr.length;i++)
			{
				System.out.println(arr[i]);
				for(int j=0;j<i&&i<arr.length;j++)
				{
					if(arr[i]+arr[j] == temp)
					{
						System.out.println("Match found"+i+","+j);
						break;
					}
//					System.out.println( arr[j]);
				}
			}
	}
	
	/*
	 * Optimized code o(n) for above code O(n power 2)
	 */
	
	public static void findNumbers(int arr[], int temp)
	{
		HashSet<Integer> set= new HashSet<>();
		
		for(int number :arr)
		{
			int complement =temp-number;
			if(set.contains(complement))
			{
				System.out.println("Match found loop : "+number +" "+complement);
			}
			set.add(number);
		}
	}

}


