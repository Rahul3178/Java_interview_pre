package com.interview.java.basics;

final class Demo_mutable {

	private int i;
	
	Demo_mutable(int i) {
		this.i=i;
	}
	
	public Demo_mutable modified(int i)
	{
		if(this.i==i)
		{
			return this;
		}
		return (new Demo_mutable(i));
	}
	
	

}
