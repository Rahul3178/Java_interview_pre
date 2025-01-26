package com.interview.java.streamapi;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InterviewQuestions2 {

	public static void main(String[] args) {

		/*
		 * Given a list of integers, find out all the numbers starting with 1 using
		 * Stream functions?
		 */

		List<Integer> numbers = Arrays.asList(10, 23, 45, 1, 11, 25);
		numbers.stream().map(s -> s + "").filter(s -> s.startsWith("1")).forEach(System.out::println);

		/*
		 * How to find duplicate elements in a given integers list in java using Stream
		 * functions?
		 */
		System.out.println("\n");

		// Method 1
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		Set<Integer> set = new HashSet<>();
		myList.stream().filter(n -> !set.add(n)).forEach(System.out::println);
		System.out.println("\n");
		// Method 2
		myList.stream().distinct().forEach(System.out::println);

		/*
		 * Given the list of integers, find the first element of the list using Stream
		 * functions?
		 */

		System.out.println("\n");
		myList.stream().sorted().findFirst().ifPresent(System.out::println);

		/*
		 * Given a list of integers, find the maximum value element present in it using
		 * Stream functions?
		 */

		int max = myList.stream().max(Integer::compare).get();
		System.out.println("Maximum number is : " + max);
		int min = myList.stream().min(Comparator.naturalOrder()).get();
		System.out.println("Minimum number is : " + min);

		myList.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);

		/*
		 * How to check if list is empty in Java 8 using Optional, if not null iterate
		 * through the list and print the object?
		 */

		List<Notes> noteLst = new ArrayList<>();
		noteLst.add(new Notes(1, "note1", 11));
		noteLst.add(new Notes(2, "note2", 22));
		noteLst.add(new Notes(3, "note3", 33));
		noteLst.add(new Notes(4, "note4", 44));
		noteLst.add(new Notes(5, "note5", 55));
		noteLst.add(new Notes(6, "note6", 66));

//	    

		Optional.of(noteLst).orElse(Collections.emptyList()) // creates empty immutable list: [] in case noteLst is null
		.stream().filter(Objects::nonNull) //loop throgh each object and consider non null objects
		.map(Notes::getTagName)// method reference, consider only tag name
				.forEach(System.out::println); //// it will print tag names

		/*
		 * System.out.println("On empty list"); List<Notes> noteLst2 = null;
		 * Optional.of(noteLst2).orElse(Collections.emptyList()) .stream()
		 * .filter(Objects::nonNull)
		 * .map(Notes::getTagName).forEach(System.out::println);
		 */
		
		
		
		
		/*
		 * How to use map to convert object into LowerCase in Java 8?
		 */
		
		
		 List<String> names = Arrays.asList("AA", "BB", "AA", "CC","BB","aa");
		 
	List<String> names2=names.stream().map(s->s.concat("Rahul")).collect(Collectors.toList());
	
	
	int n=10;
	
	int[]f = new int[n];
	f[0]=0;
	f[1]=1;
	
	IntStream.range(2,n).forEach(i->f[i]=f[i-1]+f[i-2]);
	IntStream.of(f).forEach(System.out::println);
	
	
//	names.stream().collect(Collectors.toList(),Collectors.joining("Rahul"));
	
	
	System.out.println(names2);
//		names.stream().map(String::toLowerCase).forEach(System.out::println);
		
		
		/*
		 * How to find only duplicate elements with its count from the String ArrayList in Java8?
		 */
		
	Map<String,Long> duplicateResult=names.stream()
			.filter(x->Collections.frequency(names, x)>1)
			.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	duplicateResult.forEach((name,value)->System.out.printf("Name : %s and times %s \n",name,value));
	
	
	
	
	
	
	
	
	}	
	
	
	
}

class Notes {

	private int nodeId;
	private String tagName;
	private int tagId;

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	public Notes(int nodeId, String tagName, int tagId) {
		super();
		this.nodeId = nodeId;
		this.tagName = tagName;
		this.tagId = tagId;
	}

}
