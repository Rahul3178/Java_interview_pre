package com.interview.java.basics;

import java.io.IOException;
import java.io.ObjectInputStream;

public class WaysOfObjectCreation {

	public static void main(String[] args) throws CloneNotSupportedException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		
		WaysOfObjectCreation obj1= new WaysOfObjectCreation();
		
		WaysOfObjectCreation obj2= (WaysOfObjectCreation) obj1.clone();
		
		
		WaysOfObjectCreation obj3 = (WaysOfObjectCreation) Class.forName("WaysOfObjectCreation").newInstance();

		// using constructor
		
		WaysOfObjectCreation obj4 = WaysOfObjectCreation.class.newInstance();
		
		// Using deserialize
		ObjectInputStream o= new ObjectInputStream(null);
		
		WaysOfObjectCreation obj5 = (WaysOfObjectCreation) o.readObject();
		
		
		
	}

}


