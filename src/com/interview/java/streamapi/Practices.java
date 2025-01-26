package com.interview.java.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practices {

	public static void main(String[] args) {

		List<String> list1 = Arrays.asList("Apple", "Pineapple", "Strawbery", "Orange");
		Optional<String> list2 = list1.stream().max(Comparator.comparingInt(String::length));
		Stream.of(list2).forEach(v -> System.out.println("Max length  of fruit name :" + v.get()));

		/*
		 * Intersection of two arrays
		 * 
		 */
		List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		List<Integer> l2 = Arrays.asList(4, 5, 6, 9, 11, 23);
		l1.stream().filter(l2::contains).forEach(System.out::println);

		/*
		 * Occurance of characters in WELCOME
		 */
		String name = "WELCOME";

		Map<Character, Long> l3 = name.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		l3.forEach((ca, cr) -> System.out.println(" " + ca + " " + cr));
		
		
		/*
		 * Write a program to convert a string into another string 
		 */
	
		String fruit="Pineapple";
		
		String re=Arrays.stream(fruit.split("(?<=Pine)")).collect(Collectors.joining("&"));
		System.out.println("New word "+re);
		
		
		
		/*
		 * Find substring into a string
		 */
		
		String names="Rahul";
		String find="ah";
		
		
		Boolean g=Arrays.stream(names.split("")).collect(Collectors.joining()).contains(find);
		
//		IntStream(0,names.length()).
		/*
		 * find word and its index
		 */
		
		String line="Hello world rah";
		
		Pattern pattern =Pattern.compile(" ");
		String[] word= pattern.split(line);
		
		
		// without sream api
		for(int i=0;i<word.length;i++)
		{
			if(word[i].length()==3)
			{
				System.out.println("index"+i);
			}
		}
		/*
		 * Using stream api
		 */
		
		IntStream.range(0, word.length)
		.filter(index->word[index].length() == 3);
		
	}

}
