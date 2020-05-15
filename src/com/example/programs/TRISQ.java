package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TRISQ {

	public static void main(String[] args) {
		try {
			TRISQ t = new TRISQ();
			List<Integer> list = new ArrayList<Integer>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Integer tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				Integer b = Integer.parseInt(reader.readLine().trim());
				int no = t.calculateSquares(b);
				list.add(no);
			}
			for (int i = 0; i < tc; i++)
				System.out.println(list.get(i));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private int calculateSquares(Integer b) {
		if (b == 0 || b == 1)
			return 0;
		int no = ((b - 2) / 2) + calculateSquares(b - 2);
		return no;
	}

}
