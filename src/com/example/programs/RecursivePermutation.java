package com.example.programs;

public class RecursivePermutation {

	public static void main(String[] args) {
		String[] s = new String[] { "A", "B", "C" };
		new RecursivePermutation().permute(s, 0, s.length - 1);
	}

	void permute(String[] s, int start, int end) {
		if (start == end) {
			for (int i = 0; i < s.length; i++)
				System.out.print(s[i]);
			System.out.println("");
		} else {
			for (int i = start; i <= end; i++) {
				String temp = s[start];
				s[start] = s[i];
				s[i] = temp;
				permute(s, start + 1, end);
				temp = s[i];
				s[i] = s[start];
				s[start] = temp;
			}
		}
	}
}
