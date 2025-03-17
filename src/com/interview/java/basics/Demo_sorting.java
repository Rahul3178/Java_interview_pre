package com.interview.java.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.interview.java.shared.*;
public class Demo_sorting {

	public static void main(String[] args) {
		
		List<Employee> employee = new ArrayList<>();
		employee.add(new Employee("Amit", 101, 23, 100000, new Department("AMD", 1, 101)));
		employee.add(new Employee("Rahul", 102, 33, 88000, new Department("CMD", 2, 102)));
		employee.add(new Employee("Btech", 103, 27, 93000, new Department("IVS", 3, 103)));
		employee.add(new Employee("Parth", 104, 38, 957000, new Department("CIS", 4, 104)));
		employee.add(new Employee("Rudra", 105, 40, 70000, new Department("IT", 5, 105)));
		employee.add(new Employee("Yuvi", 105, 44, 89000, new Department("CCD", 6, 106)));
		employee.add(new Employee("Nano", 107, 55, 55500, new Department("FEDEX", 7, 107)));
		employee.add(new Employee("Fano", 108, 22, 40440, new Department("HTAMD", 8, 108)));

		
		
		
		
		
	Map<String,Employee> emp1=	employee.stream().collect(Collectors.toMap(Employee::getName,emp->emp,(oldValue,newValue)->newValue ));
		
		
	// 2 Convert a list of Integer into a Map consider duplicates keys and values as
			// number of Occurrence of elements

			List<Integer> listNum = Arrays.asList(3, 5, 7, 8, 3, 5);
			
	Map<Integer, Integer>	ls=	listNum.stream().collect(Collectors.toMap(e->e,e->1,Integer::sum));
		
		ls.entrySet().forEach(entry-> System.out.println(entry.getKey()+"\t"+entry.getValue()));
		
		System.out.println("------------------------------------------");
		String str= "Java is Awsome language";
		
	Map<Character,Long>res=	str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
	Optional<Character> res2=	res.entrySet().stream().filter(i->i.getValue()>1).map(i->i.getKey()).findFirst();
	
		System.out.println("First repeated character : "+res2.get());
	
		res.entrySet().forEach(System.out::println);
		
		
		
		System.out.println("------------------------------------------------");
		
		
		// find the missing numbers
		
		int[] arr3 = { 4, -1, 3, 1 };
		
		List<Integer> ls3=Arrays.stream(arr3).filter(i->i>0).distinct().sorted().boxed().collect(Collectors.toList());
		
	int missingNumber=	IntStream.range(1, ls3.size()).filter(i->!ls3.contains(i)).findFirst().getAsInt();
		
	
	System.out.println("Missing number is :"+missingNumber);
	
	System.out.println("--------------------------------");
	
Double avSalary=	employee.stream().mapToInt(Employee::getSalary).average().getAsDouble();
	
System.out.println("Average Salary : "+avSalary);

Map<Department,Object> salByDept=employee.stream().collect(Collectors.groupingBy(Employee::getDepartment,
		Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)), Optional::get)));
	
	salByDept.entrySet().stream().forEach(e->System.out.println(e.getKey()+"\t"+e.getValue()));
	System.out.println("--------------------------------");
		// Arrays shorting 
		
		int[] arr= {50,10,1,20,33};
		
		Arrays.sort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
		
		List<Integer> ls2= Arrays.asList(22,3,4,23,6,56);
		
		Collections.sort(ls2);
		
		System.out.println(ls2);
		
		List<Student> stu = Arrays.asList(
				new Student(23,"Rahul"),
				new Student(3,"Kumar"),
				new Student(33,"Jangra"),
				new Student(53,"Yuvan"),
				new Student(43,"Rudra"),
				new Student(36,"Khushans")
				
				);
		
//		Collections.sort(stu);
		
		stu.forEach(System.out::println);
		System.out.println("----------------------------------------------");
		
		Collections.sort(stu,new idComparator());
		
		stu.forEach(System.out::println);
	}

}

class Student implements Comparable<Student>{
	int age;
	String name;
	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		
//		return Integer.compare(this.age, o.age);
		return this.name.compareToIgnoreCase(o.name);
	}
	
}


class idComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o2.age, o1.age);
	}
	
}