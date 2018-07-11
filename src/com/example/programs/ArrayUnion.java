package com.example.programs;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ArrayUnion {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter size of first array:");
		int n1 = s.nextInt();
		int[] arr1 = new int[n1];
		System.out.println("Enter size of second array:");
		int n2 = s.nextInt();
		int[] arr2 = new int[n2];
		System.out.println("Enter elements of first array:");
		for (int i = 0; i < n1; i++)
			arr1[i] = s.nextInt();
		System.out.println("Enter elements of second array:");
		for (int i = 0; i < n2; i++)
			arr2[i] = s.nextInt();
		Set result = findUnion(arr1, arr2);
		System.out.println("The union is:");
		Iterator i = result.iterator();
		while (i.hasNext())
			System.out.print(i.next() + " ");
	}

	private static Set findUnion(int[] arr1, int[] arr2) {
		Set result = new LinkedHashSet<Integer>();
		for (int i = 0; i < arr1.length; i++)
			result.add(arr1[i]);
		for (int i = 0; i < arr2.length; i++)
			result.add(arr2[i]);
		return result;
	}
}
