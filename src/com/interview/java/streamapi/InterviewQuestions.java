package com.interview.java.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterviewQuestions {

	public static void main(String[] args) {

		/*
		 * Find the longest string in a list of strings using Java streams:
		 */

		List<String> l2 = Arrays.asList("Apple", "Banana", "Pineapple", "Grapes");
		Optional<String> l3 = l2.stream().max(Comparator.comparingInt(String::length));

		Stream.of(l3).forEach(System.out::println);

		
		
		/*
		 * Calculate the average age of a list of Person objects using Java streams:
		 */
		

		List<Person> persons = Arrays.asList(new Person("Rahul", 28), new Person("Deepak", 34), new Person("Yuvi", 23));

		double average = persons.stream().mapToInt(Person::getAge).average().orElse(0);
		System.out.println(average);

		/*
		 * Check if a list of integers contains a prime number using Java streams:
		 */

		List<Integer> list = Arrays.asList(2, 4, 8, 78, 56, 34, 35, 1, 0, 33);

		boolean c = list.stream().anyMatch(n -> new InterviewQuestions().isPrime(n));

		System.out.println("prime " + c);
	
			/*
			 * Merge two sorted lists into a single sorted list using Java streams
			 */

		List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
		List<Integer> list2 = Arrays.asList(0, 2, 4, 6, 8, 10);
		List<Integer> list3 = Stream.concat(list1.stream(), list2.stream())
				.sorted((i1, i2) -> i1 > i2 ? -1 : i2 > i1 ? 1 : 0).collect(Collectors.toList());
		list3.stream().forEach(System.out::println);

		System.out.println("\n");

		/*
		 * Find the intersection of two lists using Java streams:
		 */

		List<Integer> com1 = Arrays.asList(1, 2, 3, 5, 6, 8);
		List<Integer> com2 = Arrays.asList(0, 2, 3, 4, 5, 6, 7);
		com1.stream().filter(com2::contains).forEach(System.out::println);

		System.out.println("\n");
		/*
		 * Remove duplicates from a list while preserving the order using Java streams:
		 */

		Arrays.asList(1, 2, 2, 3, 4, 5, 5, 6, 7, 5, 8).stream().distinct().forEach(System.out::println);

		/*
		 * Q. Given a list of transactions, find the sum of transaction amounts for each
		 * day using Java streams?
		 */

		System.out.println("\n");
		List<Transaction> transactions = Arrays.asList(new Transaction("2022-01-01", 100),
				new Transaction("2022-01-01", 200), new Transaction("2022-01-02", 300),
				new Transaction("2022-01-02", 400), new Transaction("2022-01-03", 500));

		Map<String, Integer> sumbyDate = transactions.stream().collect(
				Collectors.groupingBy(Transaction::getTransaction, Collectors.summingInt(Transaction::getAmount)));

		sumbyDate.forEach((date, amount) -> System.out.println("date " + date + " Amount " + amount));

		/*
		 * Find the kth smallest element in an array using Java streams:
		 */
		System.out.println("\n");
		int[] arr = { 1, 5, 3, 7, 4, 2 };
		int kth = 4;

		int small = Arrays.stream(arr).sorted().skip(kth - 1).findFirst().orElse(-1);

		System.out.println("Smallest element is :" + small);

		/*
		 * Given a list of strings, find the frequency of each word using Java streams:
		 * 
		 */
		System.out.println("\n");
		List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
		Map<String, Long> listing = words.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		listing.forEach((word, count) -> System.out.printf("word : %s  and count is : %s \n", word, count));

		/*
		 * Implement a method to partition a list into two groups based on a predicate
		 * using Java streams?
		 * 
		 */
		System.out.println("\n");
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Map<Boolean, List<Integer>> partition = numbers.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
		List<Integer> even = partition.get(true);
		List<Integer> odd = partition.get(false);
		System.out.println("Even numbers are : " + even + "\n" + "Odd numbers are : " + odd);

	}

	public boolean isPrime(int number) {

		if (number <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}
}

class Person {

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

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
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