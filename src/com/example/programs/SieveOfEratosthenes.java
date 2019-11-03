package com.example.programs;

import java.util.Arrays;

//This program creates a table of primes using Sieve of Eratosthenes

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		boolean[] primes = new boolean[999999 + 1];
		Arrays.fill(primes, true);
		primes[0] = primes[1] = false;
		for (int i = 2; i * i <= primes.length - 1; i++) {
			if (primes[i]) {
				for (int j = 2 * i; j <= primes.length - 1; j += i) {
					primes[j] = false;
				}
			}
		}
	}

}
