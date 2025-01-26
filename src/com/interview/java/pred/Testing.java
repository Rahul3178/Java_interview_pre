package com.interview.java.pred;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.interview.java.streamapi.InterviewQuestions;

public class Testing {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Predicate<String> st = s -> s.length() == 5;
		System.out.println(st.test("Hello"));

		/*
		 * Calculate the average age of a list of Person objects using Java streams:
		 */

		List<Person> persons = Arrays.asList(new Person("Rahul", 28), new Person("Deepak", 34), new Person("Yuvi", 23));

		Double averaeAge = persons.stream().mapToInt(Person::getAge).average().orElse(0);

		System.out.println(averaeAge);

		/*
		 * Check if a list of integers contains a prime number using Java streams:
		 */

		List<Integer> listofInt = Arrays.asList(3, 5, 67, 54, 35);

		boolean c = listofInt.stream().anyMatch(n -> new InterviewQuestions().isPrime(n));
		System.out.println(c);

		/*
		 * Merge two sorted lists into a single sorted list using Java streams
		 */

		List<Integer> l1 = Arrays.asList(3, 5, 7, 30, 37);
		List<Integer> l2 = Arrays.asList(4, 9, 25, 55, 45);

		List<Integer> l3 = Stream.concat(l1.stream(), l2.stream()).sorted((I1, I2) -> I1 < I2 ? -1 : I1 > I2 ? 1 : 0)
				.collect(Collectors.toList());

//		l3.stream().forEach(System.out::print);
		System.out.println(l3);

		/*
		 * Find the intersection of two lists using Java streams:
		 */
		List<Integer> com1 = Arrays.asList(1, 2, 3, 5, 6, 8);
		List<Integer> com2 = Arrays.asList(0, 2, 3, 4, 5, 6, 7);

//		to find interdsection means need to find common space
		List<Integer> list3 = com1.stream().filter(com2::contains).collect(Collectors.toList());
		System.out.println(list3);

		/*
		 * Remove duplicates from a list while preserving the order using Java streams:
		 */

		List<Integer> list4 = Arrays.asList(2, 3, 3, 44, 55, 33, 33, 45, 22, 33, 44, 55).stream().distinct().sorted()
				.collect(Collectors.toList());
		System.out.println(list4);

		/*
		 * Q. Given a list of transactions, find the sum of transaction amounts for each
		 * day using Java streams?
		 */

		System.out.println("\n");
		List<Transaction> transactions = Arrays.asList(new Transaction("2022-01-01", 100),
				new Transaction("2022-01-01", 200), new Transaction("2022-01-02", 300),
				new Transaction("2022-01-02", 400), new Transaction("2022-01-03", 500));

		Map<String, Integer> transSum = transactions.stream().collect(
				Collectors.groupingBy(Transaction::getTransaction, Collectors.summingInt(Transaction::getAmount)));

		System.out.println(transSum);

		/*
		 * Given a list of strings, find the frequency of each word using Java streams:
		 * 
		 */

		System.out.println("\n");
		List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");

		Map<String, Long> listofeach = words.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(listofeach);

		/*
		 * Implement a method to partition a list into two groups based on a predicate
		 * using Java streams?
		 * 
		 */
		System.out.println("\n");
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		Map<Boolean, List<Integer>> m = numbers.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));

		System.out.println(m);

		List<Integer> even = m.get(true);
		List<Integer> odd = m.get(false);
		System.out.println("Even" + even);
		System.out.println("Odd" + odd);

		/*
		 * Given a list of integers, find out all the numbers starting with 1 using
		 * Stream functions?
		 */

		List<Integer> numbers2 = Arrays.asList(10, 23, 45, 1, 11, 25);

		List<String> listd = numbers2.stream().map(s -> s + "").filter(s -> s.startsWith("1"))
				.collect(Collectors.toList());

		listd.stream().map(Integer::parseInt).forEach(System.out::println);

		/*
		 * Given the list of integers, find the first element of the list using Stream
		 * functions?
		 */

		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		Set<Integer> set = new HashSet<>();

		List<Integer> map = myList.stream().filter(t -> !set.add(t)).collect(Collectors.toList());

		System.out.println(map);

//		Find the word which have maximum length 

		List<String> list1 = Arrays.asList("Apple", "Pineapple", "Strawbery", "Orange");

		Optional<String> result = list1.stream().max(Comparator.comparingInt(String::length));
		System.out.println(result.get() + " == " + result.get().length());

//		

		String fruit = "Pineapple Apple Kumar";
		String result1 = Arrays.stream(fruit.split(" ")).collect(Collectors.joining("Rahul"));

		String result2 = Arrays.stream(fruit.split("(le>=?)")).collect(Collectors.joining("Rahul"));

		System.out.println(result2);

		/*
		 * Find substring into a string
		 */

		String line = "Hello world rah";
		String find = "ah";
		Pattern p = Pattern.compile(" ");
		String[] word = p.split(line);

		IntStream.range(0, word.length).filter(s -> word[s].contains(find)).forEach(System.out::println);

		Arrays.stream(line.split(" ")).filter(s -> s.contains(find)).forEach(System.out::println);

		List<Integer> ar = Arrays.asList(3, 5, 34, 4, 3, 45, 32, 1, 3, 6, 9, 8, 77, 66);

		Map<Boolean, List<Integer>> am = ar.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));

		am.get(true).forEach(System.out::println);
		am.get(false).forEach(System.out::println);

		/*
		 * How to find only duplicate elements with its count from the String ArrayList
		 * in Java8?
		 */

		List<String> names = Arrays.asList("AA", "BB", "AA", "CC", "BB", "aa");

		Map<String, Long> result4 = names.stream().filter(x -> Collections.frequency(names, x) > 1)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(result4);
		
		
		
		/*
		 * Factorial of number //reduce( identity value = initial value , (binary
		 * operation))
		 */
		
		
		int n=5;
		
		int z=IntStream.rangeClosed(1, n).reduce(1,(x,y)->x*y);
			
			System.out.print(z);
	
			/*
			 *  Prime number
			 * 
			 */
			
			int limit=50;
			
			IntStream.rangeClosed(2, limit).filter(u->isPrime(u)).forEach(System.out::println);
			
	
	}

	public static Boolean isPrime(int n) {
		return IntStream.rangeClosed(2,(int) Math.sqrt(n)).allMatch(k->n%k!=0);
	}
}

class Person {

	private String name;
	private int age;

	Person(String name, int age) {
		this.age = age;
		this.name = name;
	}

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

}

class Transaction {
	private int amount;

	private String transaction;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public Transaction(String transaction, int amount) {
		super();
		this.amount = amount;
		this.transaction = transaction;
	}

}