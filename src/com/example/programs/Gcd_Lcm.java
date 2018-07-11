package com.example.programs;

import java.util.Scanner;

public class Gcd_Lcm {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter X:");
		int x = s.nextInt();
		System.out.println("Enter Y:");
		int y = s.nextInt();

		// find the greater no
		int a = (x > y) ? x : y;
		// find the smaller no
		int b = (x < y) ? x : y;

		int gcd = findGcd(a, b);
		int lcm = findLcm(a, b, gcd);
		
		System.out.println("The gcd is:"+gcd);
		System.out.println("The lcm is:"+lcm);
	}

	private static int findLcm(int a, int b, int gcd) {
		return (a * b) / gcd;
	}

	private static int findGcd(int a, int b) {
		int remainder = 0;
		while ((a % b) != 0) {
			remainder = a % b;
			a = b;
			b = remainder;
		}
		return remainder;
	}
}
