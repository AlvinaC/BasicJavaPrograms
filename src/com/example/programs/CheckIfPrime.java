package com.example.programs;

import java.util.Scanner;

public class CheckIfPrime {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a no:");
		int x = s.nextInt();
		if (checkPrime(x, 2))
			System.out.println("The no is prime");
		else
			System.out.println("The no is not prime");
	}

	private static boolean checkPrime(int x, int divisor) {
		boolean isPrime = true;
		if (x == 1)
			return false;
		if (x == 2)
			return false;
		if (divisor < x)
			if ((x % divisor) == 0)
				isPrime = false;
			else
				isPrime = checkPrime(x, ++divisor);
		return isPrime;
	}
}
