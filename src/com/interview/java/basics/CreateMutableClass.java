package com.interview.java.basics;

final class CreateMutableClass {

	private int i;
	
	CreateMutableClass(int i)
	{
		this.i=i;
		
	}
	
	public CreateMutableClass modified(int i)
	{
		if(this.i==i)
		{
			return this;
		}
		return (new CreateMutableClass(i));
	}
	
	public static void main(String[] args) {
		
		CreateMutableClass c1 = new CreateMutableClass(10);
		CreateMutableClass c2= c1.modified(100);
		CreateMutableClass c3= c1.modified(10);
		
		System.out.println(c1==c2); // false
		System.out.println(c1==c3); // true
		CreateMutableClass c4 = c1.modified(100);
		System.out.println(c2==c4); // false
		System.gc();
		Runtime.getRuntime().gc();
	}

}
