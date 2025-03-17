package com.interview.java.basics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Demo_Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Demo_Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Demo_Student [name=" + name + ", age=" + age + "]";
	}
	
}
public class Demo_serilization {
	
	public static void main(String[] args) throws IOException{
		
		Demo_Student stu= new Demo_Student("Rahul", 1);
		FileOutputStream fos= new FileOutputStream("./ob.txt");
		
		ObjectOutputStream oss= new ObjectOutputStream(fos);
		oss.writeObject(stu);
		
		FileInputStream fis= new FileInputStream("./ob.txt");
		
		ObjectInputStream fo= new ObjectInputStream(fis);
		
		try {
//			fo.readObject();
			
			System.out.println(	fo.readObject());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		fos.close();
		oss.close();
		fis.close();
		fo.close();
	}
	
	
	
}
