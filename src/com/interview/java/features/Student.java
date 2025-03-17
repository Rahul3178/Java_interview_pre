package com.interview.java.features;

public record Student (int id, String name) {};


class StudentImple{
	public static void main(String[] args) {
		Student s= new Student(1, "Rahul");
		Student s1= new Student(1,"Rahul");
		System.out.println(s.equals(s1));
	}
	
	
	
	
	
}


sealed  class A permits B{
	
}


non-sealed class B extends A{
	
}