package com.example.programs;

import java.util.HashMap;
import java.util.Scanner;

public class CountLettersInPassage {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String str;
		System.out.println("Enter text:");
		while (s.hasNextLine() && !s.nextLine().equals("")) {
			str = s.nextLine();
			for (int i = 0; i < str.length(); i++)
				if (Character.isLetter(str.charAt(i))) {
					if (map.get(str.charAt(i) + "") == null)
						map.put(str.charAt(i) + "", 0);
					else {
						Integer val = (Integer) map.get(str.charAt(i) + "");
						val++;
						map.put(str.charAt(i) + "", val);
					}
				}
		}
		map.forEach((k, v) -> System.out.println("Key: " + k + ": Value: " + v));
	}
}
