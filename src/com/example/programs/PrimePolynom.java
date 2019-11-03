package com.example.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimePolynom {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int a = Integer.parseInt(reader.readLine().trim());
			int b = Integer.parseInt(reader.readLine().trim());
			int c = Integer.parseInt(reader.readLine().trim());
			reveal(a, b, c);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public static int reveal(int a, int b, int c) {
		int m = 0;
		for (int i = 0; i <= 100; i++) {
			long no = (a * i * i) + (b * i) + c;
			if (no > 0) {
				if (!isPrime(no)) {
					m = i;
					break;
				}
			}
		}
		return m;
	}

	public static boolean isPrime(long no) {
		if (no < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(no); i++) {
			if (no % i == 0)
				return false;
		}
		return true;
	}
}
