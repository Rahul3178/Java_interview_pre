package com.interview.java.collectionStrem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Employee> employee = new ArrayList<>();
		employee.add(new Employee("Amit", 101, 23, 100000, new Department("AMD", 1, 101)));
		employee.add(new Employee("Rahul", 102, 33, 88000, new Department("CMD", 2, 102)));
		employee.add(new Employee("Btech", 103, 27, 93000, new Department("IVS", 3, 103)));
		employee.add(new Employee("Parth", 104, 38, 957000, new Department("CIS", 4, 104)));
		employee.add(new Employee("Rudra", 105, 40, 70000, new Department("IT", 5, 105)));
		employee.add(new Employee("Yuvi", 105, 44, 89000, new Department("CCD", 6, 106)));
		employee.add(new Employee("Nano", 107, 55, 55500, new Department("FEDEX", 7, 107)));
		employee.add(new Employee("Fano", 108, 22, 40440, new Department("HTAMD", 8, 108)));

		// 1. How to convert a List of object into map and handle Duplicate
		// old value and new value is a merger function which replace old value to new
		// value if keys are same

		Map<String, Employee> empMap = employee.stream()
				.collect(Collectors.toMap(Employee::getName, emp -> emp, (oldValue, newValue) -> newValue));

		empMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "\t" + e.getValue()));
		System.out.println("---------------------------------------------------------------------------");

		empMap.forEach((key, value) -> System.out.println(key + "\t" + value));
		System.out.println("---------------------------------------------------------------------------");

		// 2 Convert a list of Integer into a Map consider duplicates keys and values as
		// number of Occurrence of elements

		List<Integer> listNum = Arrays.asList(3, 5, 7, 8, 3, 5);

		Map<Integer, Integer> listMap = listNum.stream()
				.collect(Collectors.toMap(element -> element, element -> 1, Integer::sum));

		/*
		 * listNum.stream() Converts the listNum (assumed to be a list of integers) into
		 * a stream of integers. Collectors.toMap(...) Uses the collect method to
		 * accumulate elements of the stream into a Map. element -> element Lambda
		 * function specifying the key for the map; each element itself becomes the key.
		 * element -> 1 Lambda function specifying the value for the map; each element
		 * is mapped to the value 1. Integer::sum Merge function to handle duplicate
		 * keys by summing their values.
		 */
		listMap.forEach((key, value) -> System.out.println(key + "\t" + value));

		System.out.println("---------------------------------------------------------------------------");

		// 3. How to find the first longest substring without repeating the character
		// using stream API

		String ls = "pwwkew";

		// 4. How to find duplicates in a given list of integer using Stream api
		System.out.println("---------------------------------------------------------------------------");

		List<Integer> lst = Arrays.asList(3, 5, 7, 3, 5);
		Set<Integer> se = new HashSet<>();
		List<Integer> dup = lst.stream().filter(s -> !se.add(s)).collect(Collectors.toList());
		dup.forEach(System.out::println);
		System.out.println("---------------------------------------------------------------------------");
		Map<Integer, Long> dup2 = lst.stream().filter(s -> !se.add(s))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		dup2.forEach((key, value) -> System.out.println(key + "\t" + value));

		// now remove whose Occupancy is 1
		System.out.println("now remove whose Occurancy is 1");
		dup2.entrySet().stream().filter(e -> e.getValue() > 1).forEach(System.out::println);

		// 5. How to sort Arrays of String into reverse order using stream api

		String[] strArr = { "Rahul", "kumar", "Jangra" };

		String[] sorArr = Arrays.stream(strArr).sorted(Comparator.reverseOrder()).toArray(String[]::new);
		for (String s : sorArr) {
			System.out.println(s);
		}
		System.out.println("---------------------------------------------------------------------------");

		// 6 .How to find 3rd highest salary from from the list of employee

		employee.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).forEach(System.out::println);
		// .findFirst().get();

		// 7. Find the department name which have highest salary

		List<Emp> employee2 = Arrays.asList(new Emp("Rahul", 3400, "IT"), new Emp("Kumar", 3200, "ADM"),
				new Emp("Jangra", 2000, "DH"), new Emp("Infosys", 2300, "CIS"), new Emp("Rudra", 4300, "CIS"),
				new Emp("Yuvi", 2300, "CIS")

		);

		/*
		 * Map<Object,Integer> sortedEmpl=employee2.stream().
		 * collect(Collectors.groupingBy(e->e.getDept(),
		 * Collectors.summingInt(Emp::getSalary)));
		 * sortedEmpl.forEach((key,value)->System.out.println(key+"\t"+value));
		 */

		Optional<Map.Entry<String, Emp>> deptSalary = employee2.stream()
				.collect(Collectors.groupingBy(Emp::getDept,
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Emp::getSalary)),
								Optional::get)))
				.entrySet().stream().max(Comparator.comparingInt(e -> e.getValue().getSalary()));
		System.out.println("---------------------------------------------------------------------------");

		if (deptSalary.isPresent()) {
			System.out.println(deptSalary.get());
		}
		System.out.println("---------------------------------------------------------------------------");

		// 8. How to count number of Occurrence of a given word in a list opf String
		// using stream api
		List<String> count = Arrays.asList("Hello World", "Hello Java", "Hello Stream", "Reaction");
		String targetWord = "Hello";
		Long n = count.stream().flatMap(str1 -> Arrays.stream(str1.split("\s+")))
				.filter(word -> targetWord.equals(word)).count();
		System.out.println(targetWord + "\t" + "repeated" + "\t" + n);
		System.out.println("---------------------------------------------------------------------------");
		// 9. How to find department wise counting of employee
		System.out.println("---------------------------------------------------------------------------");
		// 10. How to find common elements from two array using stream api;
		int[] arr1 = { 2, 5, 7, 8, 9 };
		int[] arr2 = { 2, 5, 3, 4, 6 };

		List<Integer> ls1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());

		List<Integer> commonmList = Arrays.stream(arr2).boxed().filter(ls1::contains).collect(Collectors.toList());

		commonmList.forEach(System.out::println);
		System.out.println("---------------------------------------------------------------------------");
		// 11. from a list of integer find out all the numbers starting with 1 using
		// stream function.
		List<Integer> lst1 = Arrays.asList(23, 34, 56, 11, 12, 15, 18);
		List<Integer> found = lst1.stream().map(String::valueOf).filter(i -> i.startsWith("1")).map(Integer::valueOf)
				.collect(Collectors.toList());
		found.forEach(System.out::println);
		System.out.println("---------------------------------------------------------------------------");

		// 12. How to find first missing number from Array of integer using stream API

		int[] arr3 = { 4, -1, 3, 1 };

		List<Integer> positiveNumbers = Arrays.stream(arr3).filter(i -> i > 0).distinct().sorted().boxed()
				.collect(Collectors.toList());

		int missingNumber = IntStream.rangeClosed(1, positiveNumbers.size() + 1)
				.filter(i -> !positiveNumbers.contains(i)).findFirst().orElse(1);

		System.out.println("Missing Number is : \t" + missingNumber);

		System.out.println("---------------------------------------------------------------------------");

		// 13. How to find sum of list of Integers with stream api

		List<Integer> ls3 = Arrays.asList(1, 2, 3, 4, 5);

		int sumofNumbers = ls3.stream().mapToInt(Integer::intValue).sum();
		System.out.println("Sum of \t" + sumofNumbers);

		System.out.println("---------------------------------------------------------------------------");

		// 14. How to count occurrence of each character in string using java stream api

		String name = "RahulKumar";

		Map<Character, Long> occurence = name.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		occurence.forEach((key, value) -> System.out.println(key + "\t" + value));
		System.out.println("---------------------------------------------------------------------------");
		//16. Find the first repeating character from a string
		
		String input0 = "swiss";
		Optional<Character> result0=input0.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() > 1).map(c->c.getKey()).findFirst();
			System.out.println("repeting character : "+result0.get());
			
			System.out.println("---------------------------------------------------------------------------");
		// 17 find first non repeated character from a string using stream api
		// here linked hashed map is used to maintain the insertion order;
		String input1 = "swiss";
		Optional<Character> result1=input1.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() == 1).map(c->c.getKey()).findFirst();
			System.out.println("Non repeting character : "+result1.get());
			
			System.out.println("---------------------------------------------------------------------------");
		// 18. Remove element from a list duplicates from a list

		// 19. concat two list into a sorted order

		// 20.Calculate the average age of employee
	}

}

class Emp {
	private String name;
	private int salary;
	private String dept;

	public Emp(String name, int salary, String dept) {
		super();
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + ", salary=" + salary + ", dept=" + dept + "]";
	}

}
