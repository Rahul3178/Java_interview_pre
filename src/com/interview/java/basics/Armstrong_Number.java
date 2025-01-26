package com.interview.java.basics;

import java.util.stream.IntStream;

public class Armstrong_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		 153 => 1^3+5^3+3^3=153 3= length of word

		int number = 153;
		if (isArmStrong(number)) {
			System.out.println("number is armstrong");
		} else {
			System.out.println("Number is not Armstrong");
		}

		// Using stream api

		String value = String.valueOf(number); // convert into String
		int length = value.length();

		int result = value.chars().map(Character::getNumericValue)
				.map(digit -> IntStream.range(0, length).reduce(1, (temp, i) -> temp * digit)).sum();

		if (result == number) {
			System.out.println("Numser is armstronmg" + number);
		} else {
			System.out.println("Number is not armstrong" + number);
		}

	}

	public static boolean isArmStrong(int number) {

		int originalNumber = number;
		int result = 0;
		int length = String.valueOf(number).length();

		while (number != 0) {
			int lastDigit = number % 10;
			int temp = 1;
			for (int i = 0; i < length; i++) {
				temp *= lastDigit;
			}

			result = result + temp;

			number = number / 10;
		}

		return result == originalNumber;

	}

}
