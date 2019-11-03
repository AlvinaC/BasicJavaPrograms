package com.example.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Refactoring {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int a = Integer.parseInt(reader.readLine().trim());
			int b = refactor(a);
			System.out.print(b);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public static int refactor(int n) {
		return count(n, 2);
	}

	public static int count(int dividend, int lastDivisor) {
		int result = 0;
		for (int i = lastDivisor; i * i <= dividend; i++) {
			if (dividend % i == 0)
				result = result + count(dividend / i, i) + 1;
		}
		return result;
	}

}
